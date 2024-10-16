import com.google.gson.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Visitor.class, new VisitorDeserializer())
                .registerTypeAdapter(Book.class, new BooksDeserializer())
                .create();

        String json = new String(Files.readAllBytes(Paths.get("src\\main\\resources\\books.json")));
        Visitor[] visitors = gson.fromJson(json, Visitor[].class);

        List<Visitor> visitorsList = new ArrayList<>(Arrays.asList(visitors));

        System.out.println("\n\n1)");
        System.out.println("Visitors:" + visitorsList);
        System.out.println("Visitors count:" + visitorsList.size());

        System.out.println("\n\n2)");
        List<Book> allBooks = new ArrayList<>();
        for(Visitor visitor : visitorsList) {
            allBooks.addAll(visitor.getFavoriteBooks());
        }

        List<Book>favBooks = allBooks.stream().distinct().toList();

        System.out.println("Visitors favorite books:" + favBooks);
        System.out.println("Books count:" + favBooks.size());

        System.out.println("\n\n3)");

        allBooks = favBooks.stream().sorted(Comparator.comparing(Book::getPublishingYear)).collect(Collectors.toList());
        System.out.println("Books sorted by year:" + allBooks);

        System.out.println("\n\n4)");
        System.out.println("Jane Austen :" + allBooks.stream().anyMatch(book -> Objects.equals(book.getAuthor(), "Jane Austen")));

        System.out.println("\n\n5)");
        System.out.println("max books:");
        visitorsList.stream()
                .max(Comparator.comparingInt(h -> h.getFavoriteBooks().size()))
                .ifPresent(visitor -> System.out.println(visitor.getFavoriteBooks().size()));

        System.out.println("\n\n6)");
        List<Visitor> subscribedVisitorsList = visitorsList.stream().filter(Visitor::isSubscribed).toList();
        double average = visitorsList.stream().mapToDouble(x -> x.getFavoriteBooks().size()).sum() / visitorsList.size();
        System.out.println("Average favorite books:" + average);

        System.out.println(subscribedVisitorsList.stream()
                .filter(x -> x.getFavoriteBooks().size() > average)
                .map(x -> new Sms(x.getPhone(), "you are a bookworm")).toList());
        System.out.println(subscribedVisitorsList.stream()
                .filter(x -> x.getFavoriteBooks().size() < average)
                .map(x -> new Sms(x.getPhone(), "read more")).toList());
        System.out.println(subscribedVisitorsList.stream()
                .filter(x -> x.getFavoriteBooks().size() == average)
                .map(x -> new Sms(x.getPhone(), "fine")).toList());
    }
}

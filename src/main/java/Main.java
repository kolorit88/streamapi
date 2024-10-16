import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {

        Gson gson = new Gson();
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
        System.out.println("Visitors count:" + favBooks.size());

        System.out.println("\n\n3)");

        allBooks = favBooks.stream().sorted(Comparator.comparing(Book::getPublishingYear)).collect(Collectors.toList());
        System.out.println("Books sorted by year:" + allBooks);

        System.out.println("\n\n4)");
        System.out.println("Jane Austen :" + allBooks.stream().filter(book -> Objects.equals(book.getAuthor(), "Jane Austen")).count());

        System.out.println("\n\n5)");
        System.out.println(Arrays.stream(visitors).max((h1, h2) -> Integer.compare(h1.getFavoriteBooks().size(), h2.getFavoriteBooks().size())).get().getFavoriteBooks().size());
    }
}

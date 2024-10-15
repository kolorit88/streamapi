//import com.google.gson.JsonDeserializationContext;
//import com.google.gson.JsonDeserializer;
//import com.google.gson.JsonElement;
//import com.google.gson.JsonParseException;
//
//import java.lang.reflect.Type;
//import java.util.*;
//
//public class BooksDeserializer implements JsonDeserializer<Book>
//{
//    @Override
//    public Book deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException
//    {
//        Book book = new Book();
//        String data = json.getAsString();
//        List<String> parts = Arrays.asList(data.split(" "));
//
//        System.out.println(parts);
//
//        if(parts.contains("name"))
//            book.setName(true);
//        if(parts.contains("mustache"))
//            book.setHaveMustache(true);
//        if(hair.isHaveBeard() || hair.isHaveMustache())
//            book.setColor(parts.get(0));
//        return book;
//    }
//
//}
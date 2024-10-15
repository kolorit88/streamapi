import com.google.gson.*;

import java.lang.reflect.Type;

public class BooksDeserializer implements JsonDeserializer<Book> {

    public Book deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject json = jsonElement.getAsJsonObject();

        Book book = new Book();

        book.setName(json.get("name").getAsString());
        book.setAuthor(json.get("author").getAsString());
        book.setPublisher(json.get("publisher").getAsString());
        book.setIsbn(json.get("isbn").getAsString());
        book.setPublishingYear(json.get("publishingYear").getAsInt());

        return book;
    }
}

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.*;

public class VisitorDeserializer implements JsonDeserializer<Visitor> {

    @Override
    public Visitor deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) throws JsonParseException {
        JsonObject json = jsonElement.getAsJsonObject();

        Visitor visitor = new Visitor();
        List<Book> books = new ArrayList<Book>();

        json.get("books").getAsJsonArray().forEach(book -> {books.add((Book) context.deserialize(book, Book.class));});

        visitor.setName(json.get("name").getAsString());
        visitor.setSurname(json.get("surname").getAsString());
        visitor.setPhone(json.get("phone").getAsString());
        visitor.setSubscribed(json.get("subscribed").getAsBoolean());
        visitor.setFavoriteBooks(books);

        return visitor;
    }
}

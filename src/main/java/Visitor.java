import lombok.*;
import java.util.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Visitor {
    private String name;
    private String surname;
    private String phone;
    private boolean subscribed;
    private List<Book> favoriteBooks;
}
import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Book {
    private String name;
    private String author;
    private Integer publishingYear;
    private String isbn;
    private String publisher;
}
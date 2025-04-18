import java.util.List;

public interface BookRepository {
    void add(String isbn, Book book);

    List<Book> byAuthor(String author);
}

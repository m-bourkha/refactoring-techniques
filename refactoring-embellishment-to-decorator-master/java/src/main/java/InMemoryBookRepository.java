import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryBookRepository implements BookRepository {
    final Map<String, Book> books = new HashMap<>();

    @Override
    public void add(String isbn, Book book) {
        books.put(isbn, book);
    }

    @Override
    public List<Book> byAuthor(String author) {
        return books.values()
                .stream()
                .filter(book -> book.author.equals(author))
                .toList();
    }
}
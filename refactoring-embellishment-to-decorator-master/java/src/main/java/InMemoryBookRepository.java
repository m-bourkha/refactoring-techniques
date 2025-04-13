import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InMemoryBookRepository {

    private final Map<String, Book> books = new HashMap<>();
    private final Map<String, List<Book>> byAuthorsCache = new HashMap<>();


    public void add(String isbn, Book book) {
        byAuthorsCache.clear();
        books.put(isbn, book);
    }


    public List<Book> byAuthor(String author) {
        if (byAuthorsCache.containsKey(author)) {
            return byAuthorsCache.get(author);
        }

        List<Book> result = books.values()
            .stream()
            .filter(book -> book.author.equals(author))
            .collect(Collectors.toList());
        byAuthorsCache.put(author, result);
        return result;
    }
}

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CachingBookDecorator implements BookRepository {

    private final Map<String, List<Book>> byAuthorsCache = new HashMap<>();

    public CachingBookDecorator(InMemoryBookRepository bookRepository) {
        this.decorated = bookRepository;
    }

    private final BookRepository decorated;


    public void add(String isbn, Book book) {
        byAuthorsCache.clear();
        decorated.add(isbn, book);
    }

    private void _add(String isbn, Book book) {
        decorated.add(isbn, book);
    }


    public List<Book> byAuthor(String author) {
        if (byAuthorsCache.containsKey(author)) {
            return byAuthorsCache.get(author);
        }

        byAuthorsCache.put(author, decorated.byAuthor(author));
        return decorated.byAuthor(author);
    }

}

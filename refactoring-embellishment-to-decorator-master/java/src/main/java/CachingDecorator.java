import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CachingDecorator implements BookRepository {

    private final Map<String, List<Book>> byAuthorsCache;
    private final BookRepository bookRepository;

    public CachingDecorator(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        byAuthorsCache = new HashMap<>();
    }


    public void add(String isbn, Book book) {
        byAuthorsCache.clear();
        bookRepository.add(isbn, book);
    }


    public List<Book> byAuthor(String author) {
        if (isCached(author)) return byAuthorsCache.get(author);

        byAuthorsCache.put(author, bookRepository.byAuthor(author));
        return bookRepository.byAuthor(author);
    }

    private boolean isCached(String author) {
        return byAuthorsCache.containsKey(author);
    }

}

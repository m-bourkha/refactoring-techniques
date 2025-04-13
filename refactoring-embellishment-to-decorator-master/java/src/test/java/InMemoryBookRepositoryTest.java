import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class InMemoryBookRepositoryTest {

    private final InMemoryBookRepository repository = new InMemoryBookRepository();

    @Test void
    should_find_book_by_author() {
        var refactoringToPatterns = new Book("Refactoring to Patterns", "Joshua");
        repository.add("abcd", refactoringToPatterns);

        var result = repository.byAuthor("Joshua");

        assertThat(result).containsExactly(refactoringToPatterns);
    }

    @Test void
    should_utilize_author_cache() {
        var refactoringToPatterns = new Book("Refactoring to Patterns", "Joshua");
        repository.add("abcd", refactoringToPatterns);
        repository.byAuthor("Joshua");

        var result = repository.byAuthor("Joshua");

        assertThat(result).containsExactly(refactoringToPatterns);
    }

    @Test void
    should_invalidate_cache_when_adding_a_book() {
        var refactoringToPatterns = new Book("Refactoring to Patterns", "Joshua");
        var anotherBook = new Book("Some other Book", "Joshua");
        repository.add("abc", refactoringToPatterns);
        repository.byAuthor("Joshua");
        repository.add("def", anotherBook);

        var result = repository.byAuthor("Joshua");

        assertThat(result).containsExactly(refactoringToPatterns, anotherBook);
    }
}
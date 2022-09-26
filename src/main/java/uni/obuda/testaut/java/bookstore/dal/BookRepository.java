package uni.obuda.testaut.java.bookstore.dal;

import org.springframework.stereotype.Repository;
import uni.obuda.testaut.java.bookstore.domain.Book;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Repository
public class BookRepository {

    private Map<UUID, Book> store = new HashMap<>();

    public Book getBook (UUID id) {
        return store.get(id);
    }

    public List<Book> getBooksByTitle (final String titleQueryParam) {
        return store
                .values()
                .stream()
                .filter(getBookByTitle(titleQueryParam))
                .collect(Collectors.toList());
    }

    private Predicate<Book> getBookByTitle(String titleQueryParam) {
        return book -> book.getTitle().contains(titleQueryParam);
    }

    public List<Book> getAllBooks () {
        return new ArrayList<>(store.values());
    }

    public void storeBook (final Book book) {
        store.put(book.getId(), book);
    }

}

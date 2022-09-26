package uni.obuda.testaut.java.bookstore.service;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uni.obuda.testaut.java.bookstore.dal.BookRepository;
import uni.obuda.testaut.java.bookstore.domain.Book;
import uni.obuda.testaut.java.bookstore.domain.BookListPresenter;
import uni.obuda.testaut.java.bookstore.domain.BookPresenter;
import uni.obuda.testaut.java.bookstore.domain.exception.BadRequestException;

import java.util.List;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@Setter
public class BookService {

    public static final String QUERY_PARAM_LENGTH_VALIDATION_ERROR_MESSAGE = "The length of the title must be at least 3 characters";
    public static final int MIN_LENGTH_OF_QUERY_PARAM = 3;
    @Autowired
    private BookFactory bookFactory;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookValidator bookValidator;

    public void saveBook (BookPresenter bookPresenter) {
        final Book book = bookFactory.createBook(UUID.randomUUID(), bookPresenter);
        bookValidator.validateBook(book);
        bookRepository.storeBook(book);
    }

    public BookListPresenter getAllBooks () {
         List<BookPresenter> bookPresenters = bookRepository
                 .getAllBooks()
                 .stream()
                 .map(createBookPresenter())
                 .collect(Collectors.toList());

         return new BookListPresenter(bookPresenters);

    }

    public BookListPresenter getBooksByTitle (final String titleQueryParam) {
        validateTitleQueryParam(titleQueryParam);
        List<BookPresenter> bookPresenters = bookRepository
                .getBooksByTitle(titleQueryParam)
                .stream()
                .map(createBookPresenter())
                .collect(Collectors.toList());

        return new BookListPresenter(bookPresenters);
    }

    private void validateTitleQueryParam(String titleQueryParam) {
        if (titleQueryParam.length() < MIN_LENGTH_OF_QUERY_PARAM)
        {
            throw new BadRequestException(QUERY_PARAM_LENGTH_VALIDATION_ERROR_MESSAGE);
        }
    }

    private Function<Book, BookPresenter> createBookPresenter() {
        return book -> bookFactory.createBookPresenter(book);
    }
}

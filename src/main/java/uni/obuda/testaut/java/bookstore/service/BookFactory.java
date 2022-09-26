package uni.obuda.testaut.java.bookstore.service;

import org.springframework.stereotype.Component;
import uni.obuda.testaut.java.bookstore.domain.Book;
import uni.obuda.testaut.java.bookstore.domain.BookPresenter;

import java.util.UUID;

@Component
public class BookFactory {

    public Book createBook (UUID id, BookPresenter bookPresenter) {
        return new Book (id, bookPresenter.getTitle(), bookPresenter.getAuthor(), bookPresenter.getYearOfPublication(), bookPresenter.getPopularityIndex());
    }

    public BookPresenter createBookPresenter (Book book) {
        return new BookPresenter(book.getTitle(), book.getAuthor(), book.getYearOfPublication(), book.getPopularityIndex());
    }
}

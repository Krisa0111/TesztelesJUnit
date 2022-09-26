package uni.obuda.testaut.java.bookstore.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import uni.obuda.testaut.java.bookstore.domain.BookListPresenter;
import uni.obuda.testaut.java.bookstore.domain.BookPresenter;
import uni.obuda.testaut.java.bookstore.service.BookService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/book")
public class BookStoreController {

    @Autowired
    private BookService bookService;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void createBook (@Valid @RequestBody BookPresenter bookPresenter) {
        bookService.saveBook(bookPresenter);
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public BookListPresenter findBooks() {
        return  bookService.getAllBooks();
    }

    @GetMapping("/filter")
    @ResponseStatus(HttpStatus.OK)
    public BookListPresenter findBooksByTitle(@RequestParam String titleQueryParam) {
        return  bookService.getBooksByTitle(titleQueryParam);
    }
}

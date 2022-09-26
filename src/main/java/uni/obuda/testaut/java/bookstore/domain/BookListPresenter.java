package uni.obuda.testaut.java.bookstore.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Setter;

import java.util.List;

@Setter
public class BookListPresenter {

    private List<BookPresenter> books;

    @JsonCreator
    public BookListPresenter (List<BookPresenter> books) {
        this.books = books;
    }

    @JsonProperty("books")
    public List<BookPresenter> getBooks () {
        return books;
    }
}

package uni.obuda.testaut.java.bookstore.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class BookPresenter {
    public static final String POPULARITY_INDEX_ERROR_MESSAGE = "The popularity index must be set.";
    public static final String TITLE_ERROR_MESSAGE = "The title must be set.";
    public static final String AUTHOR_ERROR_MESSAGE = "The author must be set.";
    public static final String YEAR_OF_PUBLICATION_ERROR_MESSAGE = "The year of the publication must be set.";

    @NotNull (message = TITLE_ERROR_MESSAGE)
    private String title;
    @NotNull (message = AUTHOR_ERROR_MESSAGE)
    private String author;

    @NotNull (message = YEAR_OF_PUBLICATION_ERROR_MESSAGE)
    private int yearOfPublication;

    @NotNull (message = POPULARITY_INDEX_ERROR_MESSAGE)
    private int popularityIndex;

    @JsonCreator
    public BookPresenter (@JsonProperty("title") String title,
                          @JsonProperty("author")String author,
                          @JsonProperty("yearOfPublication") int yearOfPublication,
                          @JsonProperty("popularityIndex") int popularityIndex) {
        this.title = title;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
        this.popularityIndex = popularityIndex;
    }
}

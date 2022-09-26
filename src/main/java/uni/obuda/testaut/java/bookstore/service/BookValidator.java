package uni.obuda.testaut.java.bookstore.service;

import org.springframework.stereotype.Component;
import uni.obuda.testaut.java.bookstore.domain.Book;
import uni.obuda.testaut.java.bookstore.domain.exception.ValidationException;

import java.time.Year;

@Component
public class BookValidator {

    public static final String YEAR_VALIDATION_ERROR = "The year of the publication is not valid";
    public static final String POPULARITY_INDEX_ERROR_MESSAGE = "The popularityIndex must be between 0 and 100";
    public static final String FIRST_LETTER_UPPERCASE_ERROR_MESSAGE = "The first letter of the title must be uppercase.";
    public static final String LENGTH_OF_THE_TITLE_ERROR_MESSAGE = "The length of the title must be between 10 and 10000.";
    Year minYear = Year.of (1900);
    Year maxYear = Year.now();
    int minimumPopularityIndex = 0;
    int maximumPopularityIndex = 101;
    int minLengthOfTitle = 10;
    int maxLengthOfTitle = 1000;


    public void validateBook(Book book) {
        validateTitle (book.getTitle());
        validateYearOfPublication (book.getYearOfPublication());
        validatePopularityIndex (book.getPopularityIndex());
    }

    private void validatePopularityIndex(int popularityIndex) {
        if (popularityIndex < minimumPopularityIndex || popularityIndex > maximumPopularityIndex) {
            throw new ValidationException(POPULARITY_INDEX_ERROR_MESSAGE);
        }
    }

    private void validateTitle(String title) {
     char firstLetter = title.charAt(0);
     int lengthOfTheTitle = title.length();

     if (!Character.isUpperCase(firstLetter)) {
         throw new ValidationException(FIRST_LETTER_UPPERCASE_ERROR_MESSAGE);
     }

     if (lengthOfTheTitle < minLengthOfTitle || lengthOfTheTitle > maxLengthOfTitle) {
         throw new ValidationException(LENGTH_OF_THE_TITLE_ERROR_MESSAGE);
     }

    }

    private void validateYearOfPublication(int yearOfPublicationInt) {
        Year yearOfPublication = Year.of (yearOfPublicationInt);
        if (minYear.isAfter(yearOfPublication) || maxYear.isBefore(yearOfPublication)) {
            throw new ValidationException(YEAR_VALIDATION_ERROR);
        }
    }
}

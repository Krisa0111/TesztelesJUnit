package uni.obuda.testaut.java.bookstore.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class Book extends BaseObject{

    private UUID id;
    private String title;
    private String author;
    private int yearOfPublication;
    private int popularityIndex;

}

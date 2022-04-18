package vn.techmaster.baitap2.crud_rest.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Book {
    private String id;
    private String title;
    private String author;
    private int year;
}

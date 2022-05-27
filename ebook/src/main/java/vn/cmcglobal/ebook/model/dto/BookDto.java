package vn.cmcglobal.ebook.model.dto;

import lombok.Data;

@Data
public class BookDto {
    private String title;
    private String authorName;
    private String publishName;
    private Long totalBookSold;

}

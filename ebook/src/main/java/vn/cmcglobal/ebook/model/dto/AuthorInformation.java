package vn.cmcglobal.ebook.model.dto;

import lombok.Data;
import vn.cmcglobal.ebook.entity.Author;

import java.util.List;

@Data
public class AuthorInformation extends Author {
    private Long bookOwner;
    private List<String> topThreeBooks;

}

package vn.cmcglobal.ebook.service;

import vn.cmcglobal.ebook.entity.Author;
import vn.cmcglobal.ebook.model.dto.AuthorInformation;

import java.util.List;

public interface AuthorService {
    void deleteAuthor(Long id);

    Author addAuthor(Author author);

    List<Author> getListAuthors();

    Author updateAuthor(Author author, Long id);

    AuthorInformation getAuthorInformation(Long id);
}

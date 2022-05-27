package vn.cmcglobal.ebook.model.mapper;

import vn.cmcglobal.ebook.entity.Author;
import vn.cmcglobal.ebook.model.dto.AuthorInformation;
public class AuthorMapper {
    public void authorToAuthorInformation(Author author) {
        AuthorInformation authorInfo = new AuthorInformation();
        authorInfo.setId(author.getId());
        authorInfo.setFirstName(author.getFirstName());
        authorInfo.setLastName(author.getLastName());
        authorInfo.setDescription(author.getLastName());
        authorInfo.setWebsite(author.getWebsite());
        authorInfo.setYearOfBirth(author.getYearOfBirth());
    }
}

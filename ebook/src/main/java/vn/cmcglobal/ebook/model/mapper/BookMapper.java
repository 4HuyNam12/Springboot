package vn.cmcglobal.ebook.model.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import vn.cmcglobal.ebook.entity.Author;
import vn.cmcglobal.ebook.entity.Ebook;
import vn.cmcglobal.ebook.entity.Publisher;
import vn.cmcglobal.ebook.exception.NotFoundException;
import vn.cmcglobal.ebook.model.dto.BookDto;
import vn.cmcglobal.ebook.repository.AuthorRepository;
import vn.cmcglobal.ebook.repository.PublisherRepository;

import java.util.Optional;

public class BookMapper {
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private PublisherRepository publisherRepository;
    public BookDto toBookReduce(Ebook ebook) {
        BookDto bookDto = new BookDto();
        bookDto.setTitle(ebook.getTitle());
        Optional<Author> rs = authorRepository.findById(ebook.getAuthorId());
        String authorName ="";
        String publishName="";
        if (rs.isPresent()) {
            authorName = rs.get().getFirstName() + rs.get().getLastName();
        }
        bookDto.setAuthorName(authorName);
        Optional<Publisher> pb = publisherRepository.findById(ebook.getPublisherId());
        if(pb.isPresent())
            publishName =pb.get().getName();
        bookDto.setPublishName(publishName);
        return bookDto;
    }
}

package vn.cmcglobal.ebook.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.cmcglobal.ebook.entity.Ebook;
import vn.cmcglobal.ebook.exception.NotFoundException;
import vn.cmcglobal.ebook.repository.EbookRepository;
import vn.cmcglobal.ebook.service.EbookService;

import java.util.List;
import java.util.Optional;

@Service
public class EbookServiceImpl implements EbookService {
    @Autowired
    private EbookRepository ebookRepository;

    @Override
    public Ebook createOrUpdateEbook(Ebook ebook) {
        Optional<Ebook> ebookOptional = ebookRepository.findByIsbn(ebook.getIsbn());
        if (!ebookOptional.isPresent()) {
            ebookRepository.save(ebook);
            return ebook;
        }
        Ebook existedEbook = updateEbook(ebook, ebook.getIsbn());
        return existedEbook;
    }

    @Override
    public Ebook updateEbook(Ebook ebook, String isbn) {
        Optional<Ebook> ebookOptional = ebookRepository.findByIsbn(isbn);
        if (ebookOptional.isPresent()) {
            Ebook result = ebookOptional.get();
            result.setQuantity(result.getQuantity() + 1);
            result.setAuthorId(ebook.getAuthorId());
            result.setDeleted(ebook.isDeleted());
            result.setPages(ebook.getPages());
            result.setPrice(ebook.getPrice());
            result.setPublishedDate(ebook.getPublishedDate());
            result.setTitle(ebook.getTitle());
            result.setDescription(ebook.getDescription());
            ebookRepository.save(result);
            return result;

        }
        throw new NotFoundException("book with isbn" + isbn + "not found");
    }

    @Override
    public List<Ebook> findEbooksByName(String name) {
        return null;
    }

    @Override
    public List<Ebook> findEbookByAuthorId(Long authorId) {
        return null;
    }

    @Override
    public List<Ebook> findEbookByPublisher(Long publisherId) {
        return null;
    }

    @Override
    public List<Ebook> findEbookByPrice(Long price) {
        return null;
    }

    @Override
    public Ebook findEbookByISBN(String isbn) {
        return null;
    }

    @Override
    public void deleteEbook(String isbn) {
        Optional<Ebook> ebookOptional = ebookRepository.findByIsbn(isbn);
        if (ebookOptional.isPresent()) {
            Ebook result = ebookOptional.get();
            result.setDeleted(true);
            ebookRepository.save(result);
        }
        throw new NotFoundException("book with isbn" + isbn + "not found");
    }

    @Override
    public List<Ebook> getListEbook() {
        return null;
    }
}

package vn.cmcglobal.ebook.service;

import vn.cmcglobal.ebook.entity.Ebook;

import java.util.List;


public interface EbookService {

    List<Ebook> findEbooksByName(String name);

    List<Ebook> findEbookByAuthorId(Long authorId);

    List<Ebook> findEbookByPublisher(Long publisherId);

    List<Ebook> findEbookByPrice(Long price);

    Ebook findEbookByISBN(String isbn);

    void deleteEbook(String isbn);

    List<Ebook> getListEbook();

    Ebook createOrUpdateEbook(Ebook eBook);

    Ebook updateEbook(Ebook ebook, String isbn);
}

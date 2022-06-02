package vn.cmcglobal.ebook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.cmcglobal.ebook.entity.Book;
import vn.cmcglobal.ebook.service.EbookService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/ebooks")
public class EbookController {
    @Autowired
    private EbookService ebookService;

    @GetMapping
    public ResponseEntity<?> getListEbooks() {
        List<Book> result = ebookService.getListEbook();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PostMapping
    public ResponseEntity<?> createOrUpdateEbook(@Valid @RequestBody Book eBook) {
        Book result = ebookService.createOrUpdateEbook(eBook);
        return ResponseEntity.ok(result);
    }
    @PutMapping("/{isbn}")
    public ResponseEntity<?> updateEbook(@Valid @RequestBody Book book, @PathVariable String isbn) {
        Book result =ebookService.updateEbook(book,isbn);
        return ResponseEntity.ok(result);
    }


    @DeleteMapping("/{isbn}")
    public ResponseEntity<?> deleteEbook(@PathVariable String isbn) {
        ebookService.deleteEbook(isbn);
        return ResponseEntity.ok("Delete success");
    }
}

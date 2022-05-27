package vn.cmcglobal.ebook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.cmcglobal.ebook.entity.Ebook;
import vn.cmcglobal.ebook.service.EbookService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/ebook")
public class EbookController {
    @Autowired
    private EbookService ebookService;

    @GetMapping
    public ResponseEntity<?> getListUser() {
        List<Ebook> result = ebookService.getListEbook();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PostMapping("")
    public ResponseEntity<?> createOrUpdateEbook(@Valid @RequestBody Ebook eBook) {
        Ebook result = ebookService.createOrUpdateEbook(eBook);
        return ResponseEntity.ok(result);
    }
    @PutMapping("/{isbn}")
    public ResponseEntity<?> updateEbook(@Valid @RequestBody Ebook ebook,@PathVariable String isbn) {
        Ebook result =ebookService.updateEbook(ebook,isbn);
        return ResponseEntity.ok(result);
    }


    @DeleteMapping("/{isbn}")
    public ResponseEntity<?> deleteEbook(@PathVariable String isbn) {
        ebookService.deleteEbook(isbn);
        return ResponseEntity.ok("Delete success");
    }
}

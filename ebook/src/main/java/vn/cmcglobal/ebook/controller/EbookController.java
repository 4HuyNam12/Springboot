package vn.cmcglobal.ebook.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ebook")
public class EbookController {
    @PostMapping("/add")
    public ResponseEntity<?> addOrUpdateBook() {

    }
}

package vn.cmcglobal.ebook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.cmcglobal.ebook.entity.Ebook;
import vn.cmcglobal.ebook.model.dto.BookDto;
import vn.cmcglobal.ebook.service.StatisticService;

import java.util.List;

@RestController
@RequestMapping("statistical")
public class StatisticalController {
    @Autowired
    private StatisticService statisticService;

    @GetMapping
    public ResponseEntity<?> list10BestBook() {
        List<Ebook> top10Books = statisticService.findTop10BySold();
        return null;
    }
}

package vn.techmaster.baitap1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequestMapping("/")
public class RandomQuote {
    @GetMapping("/quote")
    public String randomQuote() {
        int number = ThreadLocalRandom.current().nextInt(1, 5);
        switch (number) {
            case 1:
                return "Kiến tha lâu đầy tổ";
            case 2:
                return "Có công mài sắt, có ngày nên kim";
            case 3:
                return "Không thầy đố mày làm nên";
            default:
                return "Học thầy không tày học bạn";
        }
    }
}

package vn.techmaster.baitap1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequestMapping("/")
public class RandomString {
    private static final String alphaLower = "abcdefghijklmnopqrstuvwxyz";
    private static final String alphaUpper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String digits = "0123456789";
    private static final String alphaNumeric = alphaLower + alphaUpper + digits;

    @GetMapping("/random")

    public String randomAlphaNumeric() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            int number = ThreadLocalRandom.current().nextInt(0, alphaNumeric.length());
            sb.append(alphaNumeric.charAt(number));
        }
        return sb.toString();
    }


}

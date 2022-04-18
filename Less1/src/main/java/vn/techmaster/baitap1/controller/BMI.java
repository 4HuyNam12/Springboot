package vn.techmaster.baitap1.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")

public class BMI {
    @PostMapping("/bmi")
    public float calculateBMI(@RequestParam(name = "h") float height, @RequestParam(name = "w") float weight) {
        return weight / (height * height);
    }

}

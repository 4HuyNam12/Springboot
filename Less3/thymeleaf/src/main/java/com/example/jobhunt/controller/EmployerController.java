package com.example.jobhunt.controller;

import com.example.jobhunt.model.entity.Employer;
import com.example.jobhunt.model.request.EmployerRequest;
import com.example.jobhunt.repository.EmployerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/employers")
public class EmployerController {
    @Autowired
    private EmployerRepository employerRepository;

    @GetMapping
    public String getAllEmployer(Model model) {
        List<Employer> employers = employerRepository.getListOfEmployers();
        model.addAttribute("employers", employers);
        return "/employer/employers";
    }

    @GetMapping("/add")
    public String showEmployerRegistrationForm(Model model) {
        model.addAttribute("employerReq", new Employer());
        return "/employer/employer_registration_form";
    }

    @PostMapping("/save")
    public String createNewEmployer(@ModelAttribute("employerReq") @Valid EmployerRequest req, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "/employer/employer_registration_form";
        }
        String randomUUID = UUID.randomUUID().toString();
        Employer employer = new Employer(randomUUID, req.getName(), req.getAddress(), req.getPhone());
        employerRepository.addEmployer(employer);
        model.addAttribute("employerReq", employer);
        return "/employer/employer_display_form";
    }

}

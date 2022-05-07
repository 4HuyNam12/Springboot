package com.example.jobhunt.controller;

import com.example.jobhunt.model.entity.Employer;
import com.example.jobhunt.model.request.EmployerRequest;
import com.example.jobhunt.repository.EmployerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
public class EmployerController {
    @Autowired
    private EmployerRepository employerRepository;
    @GetMapping("employers")
    public String getAllEmployer(Model model) {
        List<Employer> employers = employerRepository.getListOfEmployers();
            model.addAttribute("employers",employers);
        return "/employer/employers";
    }
    @GetMapping("/employer_registration_form")
    public String showEmployerRegistrationForm(Model model) {
        model.addAttribute("employerReq", new Employer());
        return "/employer/employer_registration_form";
    }
    @PostMapping("/save_employer")
    public String createNewEmployer( EmployerRequest req,Model model) {
        String randomUUID = UUID.randomUUID().toString();
        Employer employer = new Employer(randomUUID,req.getName(),req.getAddress(),req.getPhone());
        employerRepository.addEmployer(employer);
        model.addAttribute("employerReq",employer);
        return "/employer/employer_display_form";
    }

}

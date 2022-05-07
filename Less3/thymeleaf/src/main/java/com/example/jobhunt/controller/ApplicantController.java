package com.example.jobhunt.controller;

import com.example.jobhunt.model.entity.Applicant;
import com.example.jobhunt.model.request.ApplicantRequest;
import com.example.jobhunt.repository.ApplicantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.UUID;

@Controller
public class ApplicantController {
    @Autowired
    private ApplicantRepository applicantRepository;

    @GetMapping("/applicants")
    public String getAllApplicants(Model model) {
        List<Applicant> applicants = applicantRepository.getListOfApplicants();
        model.addAttribute("applicants",applicants);
        return "/applicant/applicants";
    }

    @GetMapping("/applicant_registration_form")
    public String showApplicantRegistrationForm(Model model,Applicant applicantReq) {
        Applicant applicant = new Applicant();
        model.addAttribute("applicantReq", applicant);
        return "/applicant/applicant_registration_form";
    }

    @PostMapping("/save_applicant")
    public String createNewApplicant(Model model, ApplicantRequest req) {
        String uuid = UUID.randomUUID().toString();
        Applicant newApplicant = new Applicant(uuid,req.getName(),req.getAge(),req.getAddress(),req.getSkills());
        applicantRepository.addNewApplicant(newApplicant);
        model.addAttribute("applicantReq",newApplicant);
        return "/applicant/applicant_display_form";
    }
}

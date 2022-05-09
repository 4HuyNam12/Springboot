package com.example.jobhunt.controller;

import com.example.jobhunt.model.entity.Applicant;
import com.example.jobhunt.model.request.ApplicantRequest;
import com.example.jobhunt.repository.ApplicantRepository;
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
@RequestMapping("/applicants")
public class ApplicantController {
    @Autowired
    private ApplicantRepository applicantRepository;

    @GetMapping
    public String getAllApplicants(Model model) {
        List<Applicant> applicants = applicantRepository.getListOfApplicants();
        model.addAttribute("applicants", applicants);
        return "/applicant/applicants";
    }

    @GetMapping("/add")
    public String showApplicantRegistrationForm(Model model, ApplicantRequest applicantReq) {
        Applicant newApplicant = new Applicant();
        model.addAttribute("ApplicantRequest", newApplicant);
        return "/applicant/applicant_registration_form";
    }

    @PostMapping("/save")
    public String createNewApplicant(@ModelAttribute("ApplicantRequest") @Valid ApplicantRequest req, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "/applicant/applicant_registration_form";
        }
        String uuid = UUID.randomUUID().toString();
        Applicant newApplicant = new Applicant(uuid, req.getName(), req.getAge(), req.getAddress(), req.getSkills());
        applicantRepository.addNewApplicant(newApplicant);
        model.addAttribute("ApplicantRequest", newApplicant);
        return "/applicant/applicant_display_form";
    }
}

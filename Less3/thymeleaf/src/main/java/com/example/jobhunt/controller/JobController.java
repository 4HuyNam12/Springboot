package com.example.jobhunt.controller;

import com.example.jobhunt.model.entity.Job;
import com.example.jobhunt.model.request.JobRequest;
import com.example.jobhunt.repository.JobRepository;
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
@RequestMapping("/jobs")
public class JobController {
    @Autowired
    private JobRepository jobRepository;

    @GetMapping
    public String getAllJob(Model model) {
        List<Job> jobs = jobRepository.getListOfJobs();
        model.addAttribute("jobs", jobs);
        return "job/jobs";
    }

    @GetMapping("/add")
    public String showJobRegistrationForm(Model model) {
        model.addAttribute("jobRequest", new Job());
        return "job/job_registration_form";
    }

    @PostMapping("save")
    public String createNewJob(@ModelAttribute("jobRequest") @Valid JobRequest req, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "job/job_registration_form";
        }
        String uuid = UUID.randomUUID().toString();
        Job newJob = new Job(uuid, req.getEmployerName(), req.getJobTitle(), req.getJobDescription(), req.getSalary());
        jobRepository.addJob(newJob);
        model.addAttribute("jobRequest", newJob);
        return "job/job_display_form";
    }

}

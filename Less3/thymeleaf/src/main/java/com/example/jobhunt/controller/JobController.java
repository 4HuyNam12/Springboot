package com.example.jobhunt.controller;

import com.example.jobhunt.model.Job;
import com.example.jobhunt.model.request.JobRequest;
import com.example.jobhunt.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.UUID;

@Controller
public class JobController {
    @Autowired
    private JobRepository jobRepository;
    @GetMapping("/jobs")
    public String getAllJob(Model model) {
        List<Job> jobs = jobRepository.getListOfJobs();
        model.addAttribute("jobs", jobs);
        return "job/jobs";
    }
    @GetMapping("/job_registration_form")
    public String showJobRegistrationForm(Model model) {
        model.addAttribute("jobRequest",new JobRequest());
        return "job/job_registration_form";
    }
    @PostMapping("save_job")
    public String createNewJob(Model model, JobRequest req) {
        String uuid = UUID.randomUUID().toString();
        Job newJob = new Job(uuid,req.getEmployerName(),req.getJobTitle(),req.getJobDescription(),req.getSalary());
        jobRepository.addJob(newJob);
        model.addAttribute("jobRequest",newJob);
        return "job/job_display_form";
    }

}

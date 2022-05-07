package com.example.jobhunt.repository;

import com.example.jobhunt.model.Job;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Component
public class JobRepository {
    private static final ConcurrentHashMap<String, Job> jobs = new ConcurrentHashMap<>();

    static {
        jobs.put("1", new Job("1", "TechMaster", "Back End", "Hà Nội", 100));
        jobs.put("2", new Job("2", "Google", "Front End", "Đà Nẵng", 200));
        jobs.put("3", new Job("3", "Facebook", "Full Stack", "TP HCM", 300));
        jobs.put("4", new Job("4", "Tiktok", "All", "Hà Nội", 400));
    }


    public List<Job> getListOfJobs() {
        return jobs.values().stream().collect(Collectors.toList());
    }

    public void addJob(Job job) {
        jobs.put(job.getId(), job);
    }
}

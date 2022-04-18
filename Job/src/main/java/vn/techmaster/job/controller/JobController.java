package vn.techmaster.job.controller;

import org.springframework.web.bind.annotation.*;
import vn.techmaster.job.dto.JobRequest;
import vn.techmaster.job.model.Job;
import vn.techmaster.job.model.Location;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/job")
public class JobController {
    private List<Job> jobs;
    public JobController() {
        jobs = new ArrayList<Job>();
        jobs.add(new Job("1","Tuyển dụng java dev","Java,Spring FrameWork", Location.HA_NOI,500,2000,"Nam@gmail.com"));
        jobs.add(new Job("2","Tuyển dụng Front end","JavaScript, React", Location.HO_CHI_MINH,400,1500,"Nam@gmail.com"));
    }
    @GetMapping
    public List<Job> getAllJob() {
        return jobs;
    }

    @GetMapping("/sortbylocaition")
    public List<Job> getAllJobSortByLocaition() {
        return jobs.stream().sorted(Comparator.comparing(Job ::getLocation).reversed()).collect(Collectors.toList());
    }

    @PostMapping
    public Job createNewJob(@RequestBody JobRequest jobRequest) {
        String id =  UUID.randomUUID().toString();
        Job newJob = new Job(id, jobRequest.title(),jobRequest.description(),jobRequest.location(),jobRequest.minSalary(),jobRequest.maxSalary(),jobRequest.email());
        jobs.add(newJob);
        return newJob;
    }


}

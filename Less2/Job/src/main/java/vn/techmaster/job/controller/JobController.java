package vn.techmaster.job.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.techmaster.job.dto.JobRequest;
import vn.techmaster.job.enums.Location;
import vn.techmaster.job.exception.ErrorResponse;
import vn.techmaster.job.exception.NotFoundException;
import vn.techmaster.job.model.Job;
import vn.techmaster.job.service.JobService;

import java.util.List;

import static vn.techmaster.job.exception.Message.*;

@RestController
@RequestMapping("/jobs")
public class JobController {
    @Autowired
    private JobService jobService;

    @GetMapping
    public ResponseEntity<?> getAllJob() {
        try {
            List<Job> listJob = jobService.getAllJob();
            return ResponseEntity.ok(listJob);
        } catch (NotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(listNoJob);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getJobById(@PathVariable("id") String id) {
        try {
            Job job = jobService.getJobById(id);
            return ResponseEntity.ok(job);
        } catch (NotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(HttpStatus.NOT_FOUND, jobWithID + id + " not found"));
        }
    }


    @GetMapping("/sortbylocation")
    public ResponseEntity<?> getAllJobSortByLocation() {
        try {
            List<Job> listJobSortByLocation = jobService.getAllJobSortByLocation();
            return ResponseEntity.status(HttpStatus.OK).body(listJobSortByLocation);
        } catch (NotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(listNoJob);
        }
    }

    @GetMapping("/salary/{salary}")
    public ResponseEntity<?> getJobBySalary(@PathVariable(value = "salary") int salary) {
        try {
            List<Job> listJobBySalary = jobService.getJobBySalary(salary);
            return ResponseEntity.status(HttpStatus.OK).body(listJobBySalary);
        } catch (NotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("There are no job in the salary range");
        }
    }

    @PostMapping
    public ResponseEntity<?> createNewJob(@RequestBody JobRequest jobRequest) {
        Job newJob = jobService.createNewJob(jobRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(newJob);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateJob(@PathVariable("id") String id, @RequestBody JobRequest jobRequest) {
        try {
            Job job = jobService.updateJob(id, jobRequest);
            return ResponseEntity.status(HttpStatus.OK).body(job);
        } catch (NotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(jobWithID + id + " not found");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteJob(@PathVariable("id") String id) {
        try {
            Job deleteJob = jobService.deleteJob(id);
            return ResponseEntity.status(HttpStatus.OK).body(deleteJob);
        } catch (NotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(jobWithID + id + " not found");
        }
    }

    @GetMapping("/keyword/{keyword}")
    public ResponseEntity<?> getJobByTitleAndDescription(@PathVariable("keyword") String keyword) {
        try {
            List<Job> listJobByTitleAndDescription = jobService.getJobByTitleAndDescription(keyword);
            return ResponseEntity.status(HttpStatus.OK).body(listJobByTitleAndDescription);
        } catch (NotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No job contains " + keyword + " in title and description");
        }
    }

    @GetMapping("/query")
    public ResponseEntity<?> getJobByTitleDescriptionAndLocation(@RequestParam(name = "location") Location location, @RequestParam(name = "keyword") String keyword) {
        try {
            List<Job> listJobByTitleAndDescription = jobService.getJobByTitleDescriptionAndLocation(location, keyword);
            return ResponseEntity.status(HttpStatus.OK).body(listJobByTitleAndDescription);
        } catch (NotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(notFoundJobMessage);
        }
    }
}

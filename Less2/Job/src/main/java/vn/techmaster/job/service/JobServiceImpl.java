package vn.techmaster.job.service;

import org.springframework.stereotype.Component;
import vn.techmaster.job.dto.JobRequest;
import vn.techmaster.job.exception.NotFoundException;
import vn.techmaster.job.model.Job;
import vn.techmaster.job.model.Location;

import java.util.*;
import java.util.stream.Collectors;


@Component
public class JobServiceImpl implements JobService {
    private static final List<Job> jobs = new ArrayList<>();

    static {
        jobs.add(new Job("1", "Tuyển dụng java dev", "Java,Spring FrameWork", Location.HA_NOI, 500, 2000, "Nam@gmail.com"));
        jobs.add(new Job("2", "Tuyển dụng Front end", "JavaScript, React", Location.HO_CHI_MINH, 400, 1500, "Nam@gmail.com"));
        jobs.add(new Job("3", "Tuyển dụng back end", "Node.js,Spring boot", Location.DA_NANG, 1000, 2000, "Nam123@gmail.com"));
        jobs.add(new Job("4", "Tuyển dụng auto test, BA", "Automation tester , BA", Location.HAI_PHONG, 300, 3000, "Nam112233@gmail.com"));
        jobs.add(new Job("5", "Tuyển dụng fullstack", "CSS,JS,HTML,Node.JS", Location.HAI_PHONG, 100, 1000, "Nam11222233@gmail.com"));
    }

    @Override
    public List<Job> getAllJob() {
        if (!jobs.isEmpty()) {
            return jobs;
        }
        throw new NotFoundException("No Job, lets add");
    }

    @Override
    public Job getJobById(String id) {
        for (Job job : jobs) {
            if (job.getId().equals(id)) {
                return job;
            }
        }
        throw new NotFoundException("Job not found");
    }

    @Override
    public List<Job> getAllJobSortByLocation() {
        if (!jobs.isEmpty()) {
            return jobs.stream().sorted(Comparator.comparing(Job::getLocation)).collect(Collectors.toList());
        }
        throw new NotFoundException("No Job, lets add");
    }

    @Override
    public List<Job> getJobBySalary(int salary) {
        if (!jobs.isEmpty()) {
            return jobs.stream().filter(job -> job.getMinSalary() <= salary).filter(job -> job.getMaxSalary() >= salary).collect(Collectors.toList());
        }
        throw new NotFoundException("No Job, lets add");
    }

    @Override
    public Job createNewJob(JobRequest jobRequest) {
        String uuid = UUID.randomUUID().toString();
        Job newJob = new Job();
        newJob.setId(uuid);
        newJob.setTitle(jobRequest.title());
        newJob.setDescription(jobRequest.description());
        newJob.setLocation(jobRequest.location());
        newJob.setMinSalary(jobRequest.minSalary());
        newJob.setMaxSalary(jobRequest.maxSalary());
        newJob.setEmailTo(jobRequest.emailTo());
        jobs.add(newJob);
        return newJob;
    }

    @Override
    public Job updateJob(String id, JobRequest jobRequest) {
        for (Job job : jobs) {
            if (job.getId().equals(id)) {
                job.setTitle(jobRequest.title());
                job.setDescription(jobRequest.description());
                job.setLocation(jobRequest.location());
                job.setMaxSalary(jobRequest.minSalary());
                job.setMaxSalary(jobRequest.maxSalary());
                job.setEmailTo(jobRequest.emailTo());
                return job;
            }
        }
        throw new NotFoundException("Job not found");
    }

    @Override
    public Job deleteJob(String id) {
        for (Job job : jobs) {
            if (job.getId().equals(id)) {
                jobs.remove(job);
                return job;
            }
        }
        throw new NotFoundException("Job not found");
    }

    @Override
    public List<Job> getJobByTitleAndDescription(String keyword) {
        List<Job> result = jobs.stream()
                .filter(job -> job.getTitle().toLowerCase().contains(keyword.toLowerCase()) || job.getDescription().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
        if (!result.isEmpty()) {
            return result;
        }
        throw new NotFoundException("No Job, lets add");

    }

    @Override
    public List<Job> getJobByTitleDescriptionAndLocation(Location location,String keyword) {
        List<Job> result =jobs.stream()
                .filter(job -> job.getLocation().equals(location))
                .filter(job -> job.getTitle().toLowerCase().contains(keyword.toLowerCase()) || job.getDescription().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
        if (!result.isEmpty()) {
            return result;
        }
        throw new NotFoundException("No Job, lets add");
    }
}

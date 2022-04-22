package vn.techmaster.job.service;

import org.springframework.stereotype.Service;
import vn.techmaster.job.dto.JobRequest;
import vn.techmaster.job.enums.Location;
import vn.techmaster.job.model.Job;


import java.util.List;

@Service
public interface JobService {
    List<Job> getAllJob();

    Job getJobById(String id);

    List<Job> getAllJobSortByLocation();

    List<Job> getJobBySalary(int salary);

    Job createNewJob(JobRequest jobRequest);

    Job updateJob(String id, JobRequest JobRequest);

    Job deleteJob(String id);

    List<Job> getJobByTitleAndDescription(String keyword);

    List<Job> getJobByTitleDescriptionAndLocation(Location location, String keywordDescription);
}

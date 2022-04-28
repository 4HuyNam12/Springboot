package vn.techmaster.job.service;

import org.springframework.stereotype.Service;
import vn.techmaster.job.enums.Location;
import vn.techmaster.job.model.dto.JobDto;
import vn.techmaster.job.model.request.CreateJobRequest;
import vn.techmaster.job.model.request.UpdateJobRequest;

import java.util.List;

@Service
public interface JobService {
    List<JobDto> getAllJob();

    JobDto getJobById(String id);

    List<JobDto> getAllJobSortByLocation();

    List<JobDto> getJobBySalary(int salary);

    JobDto createNewJob(CreateJobRequest createJobRequest);

    JobDto updateJob(String id, UpdateJobRequest UpdateJobRequest);

    JobDto deleteJob(String id);

    List<JobDto> getJobByTitleAndDescription(String keyword);

    List<JobDto> getJobByTitleDescriptionAndLocation(Location location, String keywordDescription);
}

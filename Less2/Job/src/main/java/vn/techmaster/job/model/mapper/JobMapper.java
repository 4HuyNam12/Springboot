package vn.techmaster.job.model.mapper;

import vn.techmaster.job.entity.Job;
import vn.techmaster.job.model.dto.JobDto;

public class JobMapper {
    public static JobDto toJobDto(Job job) {
        JobDto jobDto = new JobDto();
        jobDto.setTitle(job.getTitle());
        jobDto.setDescription(job.getDescription());
        jobDto.setLocation(job.getLocation());
        jobDto.setMinSalary(job.getMinSalary());
        jobDto.setMaxSalary(job.getMaxSalary());
        jobDto.setEmailTo(job.getEmailTo());
        return jobDto;
    }
}

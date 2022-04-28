package vn.techmaster.job.service.implement;

import org.springframework.stereotype.Component;
import vn.techmaster.job.entity.Job;
import vn.techmaster.job.enums.Location;
import vn.techmaster.job.exception.NotFoundException;
import vn.techmaster.job.model.dto.JobDto;
import vn.techmaster.job.model.mapper.JobMapper;
import vn.techmaster.job.model.request.CreateJobRequest;
import vn.techmaster.job.model.request.UpdateJobRequest;
import vn.techmaster.job.service.JobService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static vn.techmaster.job.exception.Message.listNoJob;
import static vn.techmaster.job.exception.Message.notFoundJobMessage;


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
    public List<JobDto> getAllJob() {
        if (!jobs.isEmpty()) {
            List<JobDto> result = new ArrayList<>();
            for (Job job : jobs) {
                result.add(JobMapper.toJobDto(job));
            }
            return result;
        }
        throw new NotFoundException(listNoJob);
    }

    @Override
    public JobDto getJobById(String id) {
        for (Job job : jobs) {
            if (job.getId().equals(id)) {
                return JobMapper.toJobDto(job);
            }
        }
        throw new NotFoundException(notFoundJobMessage);
    }

    @Override
    public List<JobDto> getAllJobSortByLocation() {
        if (!jobs.isEmpty()) {
            List<JobDto> result = new ArrayList<>();
            for (Job job : jobs) {
                result.add(JobMapper.toJobDto(job));
            }
            return result.stream().sorted(Comparator.comparing(JobDto::getLocation)).collect(Collectors.toList());

        }
        throw new NotFoundException(listNoJob);
    }

    @Override
    public List<JobDto> getJobBySalary(int salary) {
        if (!jobs.isEmpty()) {
            List<JobDto> result = new ArrayList<>();
            for (Job job : jobs) {
                result.add(JobMapper.toJobDto(job));
            }
            return result.stream().filter(JobDto -> JobDto.getMinSalary() <= salary).filter(JobDto -> JobDto.getMaxSalary() >= salary).collect(Collectors.toList());
        }
        throw new NotFoundException(notFoundJobMessage);
    }

    @Override
    public JobDto createNewJob(CreateJobRequest createJobRequest) {
        String uuid = UUID.randomUUID().toString();
        Job newJob = new Job();
        newJob.setId(uuid);
        newJob.setTitle(createJobRequest.getTitle());
        newJob.setDescription(createJobRequest.getDescription());
        newJob.setLocation(createJobRequest.getLocation());
        newJob.setMinSalary(createJobRequest.getMinSalary());
        newJob.setMaxSalary(createJobRequest.getMaxSalary());
        newJob.setEmailTo(createJobRequest.getEmailTo());
        jobs.add(newJob);
        return JobMapper.toJobDto(newJob);
    }

    @Override
    public JobDto updateJob(String id, UpdateJobRequest updateJobRequest) {
        for (Job job : jobs) {
            if (job.getId().equals(id)) {
                job.setTitle(updateJobRequest.getTitle());
                job.setDescription(updateJobRequest.getDescription());
                job.setLocation(updateJobRequest.getLocation());
                job.setMaxSalary(updateJobRequest.getMinSalary());
                job.setMaxSalary(updateJobRequest.getMaxSalary());
                job.setEmailTo(updateJobRequest.getEmailTo());
                return JobMapper.toJobDto(job);
            }
        }
        throw new NotFoundException(notFoundJobMessage);
    }

    @Override
    public JobDto deleteJob(String id) {
        for (Job job : jobs) {
            if (job.getId().equals(id)) {
                jobs.remove(job);
                return JobMapper.toJobDto(job);
            }
        }
        throw new NotFoundException(notFoundJobMessage);
    }

    @Override
    public List<JobDto> getJobByTitleAndDescription(String keyword) {
        List<Job> jobList = jobs.stream()
                .filter(job -> job.getTitle().toLowerCase().contains(keyword.toLowerCase()) || job.getDescription().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
        if (!jobList.isEmpty()) {
            List<JobDto> result = new ArrayList<>();
            for (Job job : jobList) {
                result.add(JobMapper.toJobDto(job));
            }
            return result;
        }
        throw new NotFoundException(listNoJob);

    }

    @Override
    public List<JobDto> getJobByTitleDescriptionAndLocation(Location location, String keyword) {
        List<Job> jobList = jobs.stream()
                .filter(job -> job.getLocation().equals(location))
                .filter(job -> job.getTitle().toLowerCase().contains(keyword.toLowerCase()) || job.getDescription().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
        if (!jobList.isEmpty()) {
            List<JobDto> result = new ArrayList<>();
            for (Job job : jobList) {
                result.add(JobMapper.toJobDto(job));
            }
            return result;
        }
        throw new NotFoundException(notFoundJobMessage);
    }
}

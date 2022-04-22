package vn.techmaster.job.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.techmaster.job.model.Location;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobRequest {
    private String title;
    private String description;
    private Location location;
    private int minSalary;
    private int maxSalary;
    private String emailTo;

}

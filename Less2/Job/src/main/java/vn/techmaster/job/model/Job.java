package vn.techmaster.job.model;

import lombok.*;
import vn.techmaster.job.enums.Location;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Job {
    private String id;
    private String title;
    private String description;
    private Location location;
    private int minSalary;
    private int maxSalary;
    private String emailTo;
}

package vn.techmaster.job.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Job {
    private String id;
    private String title;
    private String description;
    private Location location;
    private int minSalary;
    private int maxSalary;
    private String emailTo;
}

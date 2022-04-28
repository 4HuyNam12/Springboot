package vn.techmaster.job.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.techmaster.job.enums.Location;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobDto {
    private String title;

    private String description;

    private Location location;

    private int minSalary;

    private int maxSalary;

    private String emailTo;

}

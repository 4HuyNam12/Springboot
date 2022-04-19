package vn.techmaster.job.dto;

import vn.techmaster.job.model.Location;

public record JobRequest(String title, String description, Location location,int minSalary,int maxSalary,String emailTo) {

}

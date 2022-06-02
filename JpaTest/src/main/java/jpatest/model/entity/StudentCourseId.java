package jpatest.model.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class StudentCourseId implements Serializable {
    private long studentId;
    private long courseId;
}

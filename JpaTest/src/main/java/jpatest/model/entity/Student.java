package jpatest.model.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;


@Entity(name="student")
@Table(name="student")
@Data
public class Student {
    @Id
    private long id;
    private String name;
    @ManyToMany
    List<Course> likedCourses;
}
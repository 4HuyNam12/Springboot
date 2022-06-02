package jpatest.model.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;


@Entity(name="course")
@Table(name="course")
@Data
public class Course {
    @Id
    private long id;
    @ManyToMany
    List<Student> likes;
}
package jpatest.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@IdClass(StudentCourseId.class)
public class StudentCourse {
    @Id
    private long studentId;
    @Id
    private long courseId;

    private int score ;

    public void setScore(int score) {
        if (score > 10 || score < 0) {
            throw new IllegalArgumentException ("score must be between 0 and 10");
        }
        this.score = score;
    }
}

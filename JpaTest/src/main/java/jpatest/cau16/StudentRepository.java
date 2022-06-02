package jpatest.cau16;

import jpatest.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long>,StudentRepositoryCustom {
}

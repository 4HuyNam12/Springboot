package jpatest.cau16;

import jpatest.model.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

public class StudentRepositoryImpl implements StudentRepositoryCustom{
    @Autowired
    @Lazy
    StudentRepository studentRepository;
    @Override
    public void customMethod() {
    }
}

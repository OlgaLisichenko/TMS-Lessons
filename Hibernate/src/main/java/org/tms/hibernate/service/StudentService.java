package org.tms.hibernate.service;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.tms.hibernate.domain.CourseEntity;
import org.tms.hibernate.domain.StudentEntity;

@Service
public class StudentService extends SessionService{

    public StudentService(SessionFactory factory) {
        super(factory);
    }

    public void addStudent(Integer idCourse, Integer idStudent) {
        StudentEntity student = openSession().find(StudentEntity.class, idStudent);
        getSession().find(CourseEntity.class, idCourse).getStudents().add(student);
        closeSession();
    }

    public void deleteStudent(Integer idCourse, Integer idStudent) {
        StudentEntity student = openSession().find(StudentEntity.class, idStudent);
        getSession().find(CourseEntity.class, idCourse).getStudents().remove(student);
        closeSession();
    }
}
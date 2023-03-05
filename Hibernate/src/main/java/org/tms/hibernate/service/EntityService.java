package org.tms.hibernate.service;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.tms.hibernate.domain.CourseEntity;
import org.tms.hibernate.domain.TeacherEntity;

import java.util.List;

@Service
public class EntityService extends SessionService {

    public EntityService(SessionFactory factory) {
        super(factory);
    }

    public void save(TeacherEntity teacher) {
        openSession().save(teacher);

        List<CourseEntity> courses = teacher.getCourses();
        courses.forEach(course -> getSession().save(course));
        courses.forEach(course -> course.getStudents().forEach(student -> getSession().save(student)));
        courses.forEach(course -> course.setTeacher(teacher));

        closeSession();
    }

    public <T> void get(Class<T> clazz, Integer id) {
        T t = openSession().get(clazz, id);
        System.out.println("\nPRINT INFO: " + t + "\n");
        closeSession();
    }

    public <T> void delete(Class<T> clazz, Integer id) {
        T t = openSession().get(clazz, id);
        getSession().delete(t);
        closeSession();
    }
}
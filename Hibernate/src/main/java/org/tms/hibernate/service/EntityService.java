package org.tms.hibernate.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.tms.hibernate.domain.CourseEntity;
import org.tms.hibernate.domain.TeacherEntity;

@Service
public class EntityService extends SessionService {

    public EntityService(SessionFactory factory) {
        super(factory);
    }

    public void save(TeacherEntity teacher) {
        Session session = openSession();

        session.save(teacher);
        CourseEntity course = teacher.getCourse();
        course.setTeacher(teacher);
        session.save(course);

        closeSession();
    }

    public <T> T get(Class<T> clazz, Integer id) {
        T t = openSession().get(clazz, id);
        closeSession();
        return t;
    }

    public <T> void delete(Class<T> clazz, Integer id) {
        T t = openSession().get(clazz, id);
        getSession().delete(t);
        closeSession();
    }
}
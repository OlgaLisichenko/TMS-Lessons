package org.tms.hibernate;

import com.github.javafaker.Faker;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.tms.hibernate.domain.Address;
import org.tms.hibernate.domain.City;
import org.tms.hibernate.domain.CourseEntity;
import org.tms.hibernate.domain.TeacherEntity;
import org.tms.hibernate.service.EntityService;

import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("org.tms.hibernate");

        EntityService entityService = context.getBean(EntityService.class);

        entityService.save(createTeacher());
        entityService.save(createTeacher());

        CourseEntity courseEntity = entityService.get(CourseEntity.class, 1);
        System.out.println("Get course______ " + courseEntity);

        TeacherEntity teacherEntity = entityService.get(TeacherEntity.class, 2);
        System.out.println("Get teacher______ " + teacherEntity);

        entityService.delete(CourseEntity.class, 1);
        CourseEntity courseEntityDel = entityService.get(CourseEntity.class, 2);
        System.out.println("Delete course______ " + courseEntityDel);
    }

    public static TeacherEntity createTeacher() {
        TeacherEntity teacher = TeacherEntity.builder()
                .name(new Faker().name().firstName())
                .surname(new Faker().name().lastName())
                .workExperience(5.5)
                .address(Address.builder()
                        .city(City.MINSK)
                        .street("Pobedy")
                        .build())
                .course(createCourse())
                .build();
        return teacher;
    }

    public static CourseEntity createCourse() {
        CourseEntity course = CourseEntity.builder()
                .title(new Faker().educator().course())
                .isGroupFormed(true)
                .startOfClasses(new Date(122, Calendar.SEPTEMBER, 19))
                .city(City.MINSK)
                .build();
        return course;
    }
}
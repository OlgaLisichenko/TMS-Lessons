package org.tms.hibernate;

import com.github.javafaker.Faker;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.tms.hibernate.domain.Address;
import org.tms.hibernate.domain.City;
import org.tms.hibernate.domain.CourseEntity;
import org.tms.hibernate.domain.StudentEntity;
import org.tms.hibernate.domain.TeacherEntity;
import org.tms.hibernate.service.EntityService;
import org.tms.hibernate.service.StudentService;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("org.tms.hibernate");

        EntityService entityService = context.getBean(EntityService.class);
        StudentService studentService = context.getBean(StudentService.class);

        entityService.save(createTeacher());
        entityService.save(createTeacher());

        entityService.get(TeacherEntity.class, 1);

        entityService.delete(CourseEntity.class, 2);
        entityService.get(CourseEntity.class, 2);

        entityService.get(CourseEntity.class, 1);
        studentService.addStudent(1, 5);
        studentService.deleteStudent(1, 1);
        entityService.get(CourseEntity.class, 1);
    }

    private static TeacherEntity createTeacher() {
        TeacherEntity teacher = TeacherEntity.builder()
                .name(new Faker().name().firstName())
                .surname(new Faker().name().lastName())
                .workExperience(5.5)
                .address(Address.builder()
                        .city(City.MINSK)
                        .street("Pobedy")
                        .build())
                .courses(List.of(createCourse(), createCourse()))
                .build();
        return teacher;
    }

    private static CourseEntity createCourse() {
        CourseEntity course = CourseEntity.builder()
                .title(new Faker().educator().course())
                .isGroupFormed(true)
                .startOfClasses(new Date(122, Calendar.SEPTEMBER, 19))
                .city(City.MINSK)
                .students(List.of(createStudent(), createStudent()))
                .build();
        return course;
    }

    private static StudentEntity createStudent() {
        StudentEntity student = StudentEntity.builder()
                .name(new Faker().name().firstName())
                .surname(new Faker().name().lastName())
                .age(20)
                .address(Address.builder()
                        .city(City.MINSK)
                        .build())
                .build();
        return student;
    }
}
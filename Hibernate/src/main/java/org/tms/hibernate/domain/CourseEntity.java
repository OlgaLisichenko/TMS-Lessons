package org.tms.hibernate.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;

@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "courses")
public class CourseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    @Column(name = "formed_group")
    private boolean isGroupFormed;
    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date startOfClasses;
    @Enumerated(EnumType.STRING)
    private City city;
    @ManyToOne
    @ToString.Exclude
    private TeacherEntity teacher;

    @ManyToMany
    private List<StudentEntity> students;
}
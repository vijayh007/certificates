package com.liftoff.certificates.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

/**
 * Created by vijay.hathimare on 1/28/18.
 */
@Entity
@Table(name = "course_details")
@Access(AccessType.FIELD)
@JsonIgnoreProperties(ignoreUnknown=true)
@Data
public class CourseDetails extends BaseDomain{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="description")
    private String description;
    @Column(name="total_questions")
    private Integer totalQuestions;
    @Column(name="passing_marks")
    private Integer passingMarks;
    @Column(name="duration")
    private Integer duration;
}

package com.liftoff.certificates.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

/**
 * Created by vijay.hathimare on 1/28/18.
 */
@Entity
@Table(name="question_details")
@Access(AccessType.FIELD)
@JsonIgnoreProperties(ignoreUnknown=true)
@Data
public class QuestionDetails extends BaseDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="course_id")
    private Integer courseId;
    @Column(name="question")
    private String question;
    @Column(name="options")
    private String options;
}

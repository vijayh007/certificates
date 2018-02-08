package com.liftoff.certificates.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

/**
 * Created by vijay.hathimare on 1/28/18.
 */
@Entity
@Table(name="answer_details")
@Access(AccessType.FIELD)
@JsonIgnoreProperties(ignoreUnknown=true)
@Data
public class AnswerDetails extends BaseDomain{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "questoin_id")
    private Integer questionId;
    @Column(name = "correct_answer")
    private String correctAnswer;
}

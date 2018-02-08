package com.liftoff.certificates.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

/**
 * Created by vijay.hathimare on 1/27/18.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AnswerRequest {
    private String answerId;
    private Integer questionId;
    private String correctAnswer;
}

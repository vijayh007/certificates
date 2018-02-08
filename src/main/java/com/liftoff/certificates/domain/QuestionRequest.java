package com.liftoff.certificates.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * Created by vijay.hathimare on 1/27/18.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class QuestionRequest {
    private Integer courseId;
    private String question;
    private String options;
}

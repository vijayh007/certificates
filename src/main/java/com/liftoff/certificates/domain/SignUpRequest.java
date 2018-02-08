package com.liftoff.certificates.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * Created by vijay.hathimare on 1/27/18.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SignUpRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String education;
    private String country;
    private String phone;
    private String securityQuestion;
    private String securityAnswer;
}

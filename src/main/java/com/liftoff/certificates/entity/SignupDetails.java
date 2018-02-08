package com.liftoff.certificates.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

/**
 * Created by vijay.hathimare on 1/27/18.
 */
@Entity
@Table(name = "signup_details")
@Access(AccessType.FIELD)
@JsonIgnoreProperties(ignoreUnknown=true)
@Data
public class SignupDetails extends BaseDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="email")
    private String email;
    @Column(name="password")
    private String password;
    @Column(name="education")
    private String education;
    @Column(name="country")
    private String country;
    @Column(name="phone")
    private String phone;
    @Column(name="security_question")
    private String securityQuestion;
    @Column(name="security_answer")
    private String securityAnswer;

}

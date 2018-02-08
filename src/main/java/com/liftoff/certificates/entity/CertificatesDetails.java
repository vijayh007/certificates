package com.liftoff.certificates.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

/**
 * Created by vijay.hathimare on 1/28/18.
 */
@Entity
@Table(name = "certificates_details")
@Access(AccessType.FIELD)
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class CertificatesDetails extends BaseDomain{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="user_id")
    private Integer userId;
    @Column(name = "course_id")
    private Integer courseId;
    @Column(name = "marks")
    private Integer marks;
}

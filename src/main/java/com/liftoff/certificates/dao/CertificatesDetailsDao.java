package com.liftoff.certificates.dao;

import com.liftoff.certificates.entity.CertificatesDetails;
import org.joda.time.DateTime;

import java.util.Date;
import java.util.List;

/**
 * Created by vijay.hathimare on 2/8/18.
 */
public interface CertificatesDetailsDao extends BaseDao<CertificatesDetails> {
     List<CertificatesDetails> getCertificatesByUserId(String userId);
     List<CertificatesDetails> getCertificatesByCourse(String courseId);
     List<CertificatesDetails> getCertificatesBetweenDates(Date fromDate, Date toDate);
}

package com.liftoff.certificates.dao;

import com.liftoff.certificates.entity.AnswerDetails;
import com.liftoff.certificates.entity.CertificatesDetails;
import com.liftoff.certificates.utils.JPAUtil;
import org.joda.time.DateTime;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by vijay.hathimare on 2/8/18.
 */
public class CertificatesDetailsDaoImpl extends BaseDaoImpl<CertificatesDetails> implements  CertificatesDetailsDao {
    public CertificatesDetailsDaoImpl() {
        super(CertificatesDetails.class);
    }
    public List<CertificatesDetails> getCertificatesByUserId(String userId){
        EntityManager entityManager = JPAUtil.getEntityManager();
        try {
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<CertificatesDetails> query = cb.createQuery(
                    CertificatesDetails.class);
            Root<CertificatesDetails> sm = query.from(CertificatesDetails.class);
            Predicate p = cb.and(cb.equal(sm.get("userId"), Integer.parseInt(userId)));
            query.select(sm).where(p);
            TypedQuery<CertificatesDetails> typedQuery = entityManager.createQuery(query);
            return typedQuery.getResultList();
        } catch (Exception e) {
            return null;
        } finally {
            if (entityManager.isOpen()) entityManager.close();
        }
    }
    public List<CertificatesDetails> getCertificatesByCourse(String courseId){
        EntityManager entityManager = JPAUtil.getEntityManager();
        try {
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<CertificatesDetails> query = cb.createQuery(
                    CertificatesDetails.class);
            Root<CertificatesDetails> sm = query.from(CertificatesDetails.class);
            Predicate p = cb.and(cb.equal(sm.get("courseId"), Integer.parseInt(courseId)));
            query.select(sm).where(p);
            TypedQuery<CertificatesDetails> typedQuery = entityManager.createQuery(query);
            return typedQuery.getResultList();
        } catch (Exception e) {
            return null;
        } finally {
            if (entityManager.isOpen()) entityManager.close();
        }
    }
    public List<CertificatesDetails> getCertificatesBetweenDates(Date fromDate, Date toDate){

       EntityManager entityManager = JPAUtil.getEntityManager();
        try {
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<CertificatesDetails> query = cb.createQuery(
                    CertificatesDetails.class);
            Root<CertificatesDetails> sm = query.from(CertificatesDetails.class);
            Predicate p = cb.and(cb.between(sm.get("createdAt"),fromDate, toDate));
            query.select(sm).where(p);
            TypedQuery<CertificatesDetails> typedQuery = entityManager.createQuery(query);
            return typedQuery.getResultList();
        } catch (Exception e) {
            return null;
        } finally {
            if (entityManager.isOpen()) entityManager.close();
        }
        //return new ArrayList<>();
    }
}

package com.liftoff.certificates.dao;

import com.liftoff.certificates.entity.CourseDetails;
import com.liftoff.certificates.entity.SignupDetails;
import com.liftoff.certificates.utils.JPAUtil;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vijay.hathimare on 1/31/18.
 */
@Slf4j
public class CourseDetailsDaoImpl extends BaseDaoImpl<CourseDetails> implements  CourseDetailsDao{
    public CourseDetailsDaoImpl() {
        super(CourseDetails.class);
    }

    public List<CourseDetails> getAllCourseDetails(){
            List<CourseDetails> courseDetailses = new ArrayList<CourseDetails>();

            //Logic for get user details based on user id
            EntityManager entityManager = JPAUtil.getEntityManager();
            try {
                CriteriaBuilder cb = entityManager.getCriteriaBuilder();
                CriteriaQuery<CourseDetails> query = cb.createQuery(
                        CourseDetails.class);
                Root<CourseDetails> sm = query.from(CourseDetails.class);
                TypedQuery<CourseDetails> typedQuery = entityManager.createQuery(query);
                return typedQuery.getResultList();
            } catch (Exception e) {
                return null;
            } finally {
                if (entityManager.isOpen()) entityManager.close();
            }
        }

    public List<CourseDetails> getCourseDetailsById(String CourseId){
        List<CourseDetails> courseDetailses = new ArrayList<CourseDetails>();
        EntityManager entityManager = JPAUtil.getEntityManager();
        try {
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<CourseDetails> query = cb.createQuery(
                    CourseDetails.class);
            Root<CourseDetails> sm = query.from(CourseDetails.class);
            Predicate p = cb.and(cb.equal(sm.get("id"), CourseId));
            query.select(sm).where(p);
            TypedQuery<CourseDetails> typedQuery = entityManager.createQuery(query);
            return typedQuery.getResultList();
        } catch (Exception e) {
            return null;
        } finally {
            if (entityManager.isOpen()) entityManager.close();
        }
    }

}

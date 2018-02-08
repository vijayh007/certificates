package com.liftoff.certificates.dao;

import com.liftoff.certificates.entity.QuestionDetails;
import com.liftoff.certificates.utils.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vijay.hathimare on 2/1/18.
 */
public class QuestionDetailsDaoImpl  extends BaseDaoImpl<QuestionDetails> implements QuestionDetailsDao {
    public QuestionDetailsDaoImpl() {
        super(QuestionDetails.class);
    }

    public List<QuestionDetails> getQuestionDetail(String questoinId){
        List<QuestionDetails> questionDetailses = new ArrayList<QuestionDetails>();

        //Logic for get user details based on user id
        EntityManager entityManager = JPAUtil.getEntityManager();
        try {
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<QuestionDetails> query = cb.createQuery(
                    QuestionDetails.class);
            Root<QuestionDetails> sm = query.from(QuestionDetails.class);
            Predicate p = cb.and(cb.equal(sm.get("id"), questoinId));
            query.select(sm).where(p);
            //query.select(sm).where(cb.equal(sm.get("isDelete"), 0));
            TypedQuery<QuestionDetails> typedQuery = entityManager.createQuery(query);
            return typedQuery.getResultList();
        } catch (Exception e) {
            //   log.error("Failed to get all Couponsexception {}", e);
            return null;
        } finally {
            if (entityManager.isOpen()) entityManager.close();
        }
    }
    public List<QuestionDetails> getQuestionDetailByCourseId(String courseId){
        List<QuestionDetails> questionDetailses = new ArrayList<QuestionDetails>();

        //Logic for get user details based on user id
        EntityManager entityManager = JPAUtil.getEntityManager();
        try {
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<QuestionDetails> query = cb.createQuery(
                    QuestionDetails.class);
            Root<QuestionDetails> sm = query.from(QuestionDetails.class);
            Predicate p = cb.and(cb.equal(sm.get("courseId"), Integer.parseInt(courseId)));
            query.select(sm).where(p);
            TypedQuery<QuestionDetails> typedQuery = entityManager.createQuery(query);
            return typedQuery.getResultList();
        } catch (Exception e) {
            return null;
        } finally {
            if (entityManager.isOpen()) entityManager.close();
        }
    }
    public List<QuestionDetails> getAllQuestions(){
        return new ArrayList<>();

    }
}

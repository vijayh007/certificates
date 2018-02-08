package com.liftoff.certificates.dao;

import com.liftoff.certificates.entity.AnswerDetails;
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
 * Created by vijay.hathimare on 2/7/18.
 */
public class AnswerDetailsDaoImpl  extends BaseDaoImpl<AnswerDetails> implements  AnswerDetailsDao {
    public AnswerDetailsDaoImpl() {
        super(AnswerDetails.class);
    }
    public List<AnswerDetails> getAnswerByQuestionId(String questionId){
     //   List<AnswerDetails> answerDetailses = new ArrayList<AnswerDetails>();
        EntityManager entityManager = JPAUtil.getEntityManager();
        try {
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<AnswerDetails> query = cb.createQuery(
                    AnswerDetails.class);
            Root<AnswerDetails> sm = query.from(AnswerDetails.class);
            Predicate p = cb.and(cb.equal(sm.get("questionId"), Integer.parseInt(questionId)));
            query.select(sm).where(p);
            TypedQuery<AnswerDetails> typedQuery = entityManager.createQuery(query);
            return typedQuery.getResultList();
        } catch (Exception e) {
            return null;
        } finally {
            if (entityManager.isOpen()) entityManager.close();
        }
    }
}


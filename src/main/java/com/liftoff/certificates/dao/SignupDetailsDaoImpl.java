package com.liftoff.certificates.dao;

import com.liftoff.certificates.entity.SignupDetails;
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
 * Created by vijay.hathimare on 1/28/18.
 */
public class SignupDetailsDaoImpl extends BaseDaoImpl<SignupDetails> implements SignupDetailsDao {
    public SignupDetailsDaoImpl() {
        super(SignupDetails.class);
    }


    public List<SignupDetails> getUserDetails(String userId) {
        List<SignupDetails> signupDetail = new ArrayList<SignupDetails>();

        //Logic for get user details based on user id
        EntityManager entityManager = JPAUtil.getEntityManager();
        try {
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<SignupDetails> query = cb.createQuery(
                    SignupDetails.class);
            Root<SignupDetails> sm = query.from(SignupDetails.class);
            Predicate p = cb.and(cb.equal(sm.get("id"), userId));
            query.select(sm).where(p);
            //query.select(sm).where(cb.equal(sm.get("isDelete"), 0));
            TypedQuery<SignupDetails> typedQuery = entityManager.createQuery(query);
            return typedQuery.getResultList();
        } catch (Exception e) {
            //   log.error("Failed to get all Couponsexception {}", e);
            return null;
        } finally {
            if (entityManager.isOpen()) entityManager.close();
        }
    }

    public List<SignupDetails> getAllUsers(){

        //Logic for get all users details
        return new ArrayList<SignupDetails>();
    }
}



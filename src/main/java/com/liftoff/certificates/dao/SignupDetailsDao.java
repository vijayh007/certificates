package com.liftoff.certificates.dao;

import com.liftoff.certificates.entity.SignupDetails;

import java.util.List;

/**
 * Created by vijay.hathimare on 1/28/18.
 */
public interface SignupDetailsDao extends BaseDao<SignupDetails>{
    List<SignupDetails> getUserDetails(String userId);
    List<SignupDetails> getAllUsers();
}

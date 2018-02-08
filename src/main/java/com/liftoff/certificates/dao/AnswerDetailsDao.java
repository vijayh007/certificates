package com.liftoff.certificates.dao;

import com.liftoff.certificates.entity.AnswerDetails;

import java.util.List;

/**
 * Created by vijay.hathimare on 2/7/18.
 */
public interface  AnswerDetailsDao extends BaseDao<AnswerDetails>{
    public List<AnswerDetails> getAnswerByQuestionId(String questionID);
}


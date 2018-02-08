package com.liftoff.certificates.service;

import com.liftoff.certificates.dao.AnswerDetailsDaoImpl;
import com.liftoff.certificates.domain.AnswerRequest;
import com.liftoff.certificates.entity.AnswerDetails;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by vijay.hathimare on 2/7/18.
 *
 */
@Slf4j
public class AnswerService {
    AnswerDetailsDaoImpl answerDetailsDao = null;
    public AnswerService(){
        answerDetailsDao = new AnswerDetailsDaoImpl();
    }

    //mapping questions and anser in database
    public Map<String, String> createAnswer(AnswerRequest answerRequest){
        Map<String, String> response = new HashMap<>();
        Object object = null;
        AnswerDetails answerDetails = new AnswerDetails();
        answerDetails.setQuestionId(answerRequest.getQuestionId());
        answerDetails.setCorrectAnswer(answerRequest.getCorrectAnswer());
        object = answerDetailsDao.persist(answerDetails);
        if(object != null){
            response.put("status", "success");
        }else {
            response.put("status", "failure");
        }
        return response;
    }

    //get answer by question Id
    public List<AnswerDetails> getAnserByQuestionId(String questionId){
        List<AnswerDetails> answerDetails = null;
        answerDetails = answerDetailsDao.getAnswerByQuestionId(questionId);
        return answerDetails;
    }
}

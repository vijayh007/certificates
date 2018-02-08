package com.liftoff.certificates.service;

import com.liftoff.certificates.dao.QuestionDetailsDaoImpl;
import com.liftoff.certificates.domain.QuestionRequest;
import com.liftoff.certificates.entity.QuestionDetails;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by vijay.hathimare on 2/1/18.
 */
@Slf4j
public class QuestionService {
    QuestionDetailsDaoImpl questionDetailsDao = new QuestionDetailsDaoImpl();
    public QuestionService(){
    }

    public Map<String, String> createQuestion(QuestionRequest questionRequest){
        Map<String, String> response = new HashMap<>();
        Object ob = null;
        QuestionDetails questionDetails = new QuestionDetails();
        questionDetails.setCourseId(questionRequest.getCourseId());
        questionDetails.setQuestion(questionRequest.getQuestion());
        questionDetails.setOptions(questionRequest.getOptions());
        ob = questionDetailsDao.persist(questionDetails);
        if(ob != null){
            response.put("status","success");
        }else{
            response.put("status","failure");
        }
        return response;
    }

    public List<QuestionDetails> getQuestionById(String questionId){
        List<QuestionDetails> questionDetailses = questionDetailsDao.getQuestionDetail(questionId);
        return questionDetailses;
    }


    public List<QuestionDetails> getQuestionDetailByCourseId(String courseId){
        List<QuestionDetails> questionDetailses = questionDetailsDao.getQuestionDetailByCourseId(courseId);
        return questionDetailses;
    }
}

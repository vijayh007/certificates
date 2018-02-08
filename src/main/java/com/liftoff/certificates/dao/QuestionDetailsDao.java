package com.liftoff.certificates.dao;

import com.liftoff.certificates.entity.QuestionDetails;

import java.util.List;

/**
 * Created by vijay.hathimare on 2/1/18.
 */
public interface QuestionDetailsDao  extends BaseDao<QuestionDetails>{
    List<QuestionDetails> getQuestionDetail(String questoinId);
    List<QuestionDetails> getAllQuestions();
    List<QuestionDetails> getQuestionDetailByCourseId(String courseId);
}

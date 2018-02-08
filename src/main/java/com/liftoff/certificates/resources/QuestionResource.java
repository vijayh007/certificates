package com.liftoff.certificates.resources;

import com.liftoff.certificates.domain.QuestionRequest;
import com.liftoff.certificates.entity.QuestionDetails;
import com.liftoff.certificates.service.QuestionService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Map;

/**
 * Created by vijay.hathimare on 2/1/18.
 */
@Path("/question")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class QuestionResource {
    QuestionService questionService = new QuestionService();
    public QuestionResource(){
        questionService = new QuestionService();
    }

    @Path("create_question")
    @POST
    public Map<String, String> createQuestion(QuestionRequest questionRequest){
        Map<String, String> response=null;
        questionService.createQuestion(questionRequest);
        return  response;
    }

    @Path("/get_question")
    @GET
    public List<QuestionDetails> getQuestion(@QueryParam("qid") String questionId){
        List<QuestionDetails> questionDetailses = questionService.getQuestionById(questionId);
        return questionDetailses;
    }

    @Path("/get_questions_by_course")
    @GET
    public List<QuestionDetails> getQuestionDetailByCourseId(@QueryParam("course_id") String courseId){
        List<QuestionDetails> questionDetailses = questionService.getQuestionDetailByCourseId(courseId);
        return questionDetailses;
    }
}

package com.liftoff.certificates.resources;

import com.liftoff.certificates.domain.AnswerRequest;
import com.liftoff.certificates.entity.AnswerDetails;
import com.liftoff.certificates.service.AnswerService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by vijay.hathimare on 2/7/18.
 *
 */
@Path("/answers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AnswerResource {
    AnswerService answerService = null;
    public AnswerResource(){
        answerService = new AnswerService();
    }

    @Path("/create_answer")
    @POST
    public Map<String, String> getAnswers(AnswerRequest answerRequest){
        Map<String, String> response = null;
        response = answerService.createAnswer(answerRequest);
        return response;
    }

    @Path("/get_answers")
    @GET
    public List<AnswerDetails> getAnswer(@QueryParam("questionId") String answerId){
        List<AnswerDetails> answerDetails = null;
        answerDetails = answerService.getAnserByQuestionId(answerId);
        return answerDetails;
    }
}

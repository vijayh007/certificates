package com.liftoff.certificates.resources;

import com.liftoff.certificates.domain.SignUpRequest;
import com.liftoff.certificates.entity.SignupDetails;
import com.liftoff.certificates.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by vijay.hathimare on 1/26/18.
 */
@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {
    UserService userService = null;
    public UserResource(){
        userService = new UserService();
    }

/*
    @Path("/get_user_details")
    @GET
    public Map<String, String> getUserDetails( @QueryParam("userId") final String userId){
        Map<String, String> result = userService.getUserDetails(userId);
        return result;
    }
*/

    @Path("/signup_user")
    @POST
    public Map<String, String> creatUser(SignUpRequest signUpRequest){
        Map<String, String> response = new HashMap<String, String>();
        response = userService.createUser(signUpRequest);
        return response;
    }

    @Path("/get_user")
    @GET
    public  List<SignupDetails> getUser(@QueryParam("userId") final String userId){
        List<SignupDetails> signupDetailses = new ArrayList<SignupDetails>();
        signupDetailses = userService.getUser(userId);
        return signupDetailses;
    }
}

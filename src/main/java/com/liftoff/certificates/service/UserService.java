package com.liftoff.certificates.service;

import com.liftoff.certificates.commons.CertificatesErrorCodes;
import com.liftoff.certificates.commons.CertificatesException;
import com.liftoff.certificates.dao.SignupDetailsDaoImpl;
import com.liftoff.certificates.domain.SignUpRequest;
import com.liftoff.certificates.entity.SignupDetails;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by vijay.hathimare on 1/27/18.
 */
@Slf4j
public class UserService {
    SignupDetailsDaoImpl signupDetailsDao = new SignupDetailsDaoImpl();
    public UserService(){

    }
/*
    public Map<String, String> getUserDetails(final String userId){
        Map<String, String> userDetails = new HashMap<String, String>();
        if(StringUtils.isBlank(userId)){
            throw new CertificatesException(CertificatesErrorCodes.USERID_IS_INVALID);
        }
        userDetails.put("Name" ,"Vijay");
        userDetails.put("Last Name", "Hathimare");
        userDetails.put("Education" , "MCA");
        userDetails.put("University","UIT-RGPV");

        return userDetails;
    }
*/


    public List<SignupDetails> getUser(final String userId){
        List<SignupDetails>  userDetails = new ArrayList<SignupDetails>();
        userDetails= signupDetailsDao.getUserDetails(userId);
        return userDetails;
    }

    public Map<String, String> createUser(SignUpRequest signUpRequest){
        Map<String, String> response = new HashMap<String, String>();

        SignupDetails signupDetails = new SignupDetails();
        Object ob = null;
        signupDetails.setFirstName(signUpRequest.getFirstName());
        signupDetails.setLastName(signUpRequest.getLastName());
        signupDetails.setEmail(signUpRequest.getEmail());
        signupDetails.setPassword(signUpRequest.getPassword());
        signupDetails.setEducation(signUpRequest.getEducation());
        signupDetails.setPhone(signUpRequest.getPhone());
        signupDetails.setSecurityQuestion(signUpRequest.getSecurityQuestion());
        signupDetails.setCountry(signUpRequest.getCountry());
        signupDetails.setSecurityAnswer(signUpRequest.getSecurityAnswer());
        ob = signupDetailsDao.persist(signupDetails);
        if(ob != null){
            response.put("status","success");
        }else{
            response.put("status","failure");
        }
        return response;
    }
}

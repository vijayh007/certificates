package com.liftoff.certificates.service;

import com.liftoff.certificates.dao.CourseDetailsDaoImpl;
import com.liftoff.certificates.domain.CourseDetailRequest;
import com.liftoff.certificates.entity.CourseDetails;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by vijay.hathimare on 1/30/18.
 */
@Slf4j
public class CourseService {
    public CourseService(){
    }
    CourseDetailsDaoImpl courseDetailsDao = new CourseDetailsDaoImpl();
    public Map<String, String> createCourse(CourseDetailRequest courseDetailRequest){
        Map<String, String> response= new HashMap<>();
        Object ob = null;
        CourseDetails courseDetails = new CourseDetails();
        courseDetails.setDescription(courseDetailRequest.getCourseDescription());
        courseDetails.setTotalQuestions(courseDetailRequest.getTotalQuestions());
        courseDetails.setDuration(courseDetailRequest.getDuration());
        courseDetails.setPassingMarks(courseDetailRequest.getPassingMarks());
        ob = courseDetailsDao.persist(courseDetails);
        if(ob != null){
            response.put("status","success");
        }else{
            response.put("status","failure");
        }
        return response;
    }
    public List<CourseDetails> getCourseDetailsById(String courseId){
        List<CourseDetails> response = null;
        response = courseDetailsDao.getCourseDetailsById(courseId);
        return response;
    }

    public List<CourseDetails> getAllCourse(){
        List<CourseDetails> response = null;
        response = courseDetailsDao.getAllCourseDetails();
        return response;
    }
}

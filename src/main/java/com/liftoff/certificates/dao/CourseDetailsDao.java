package com.liftoff.certificates.dao;

import com.liftoff.certificates.entity.CourseDetails;
import com.liftoff.certificates.entity.SignupDetails;

import java.util.List;

/**
 * Created by vijay.hathimare on 1/31/18.
 */
public interface CourseDetailsDao extends BaseDao<CourseDetails>{
    public List<CourseDetails> getAllCourseDetails();
    public List<CourseDetails> getCourseDetailsById(String CourseId);
}

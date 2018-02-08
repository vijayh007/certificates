package com.liftoff.certificates.resources;

import com.liftoff.certificates.domain.CourseDetailRequest;
import com.liftoff.certificates.entity.CourseDetails;
import com.liftoff.certificates.service.CourseService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by vijay.hathimare on 1/30/18.
 */
@Path("/course")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CourseResource {
    CourseService courseService = new CourseService();
    public CourseResource(){
        courseService = new CourseService();
    }

    @Path("/create_course")
    @POST
    public Map<String, String> createCourse(CourseDetailRequest courseDetailRequest){
        Map<String, String> response = null;
        courseService.createCourse(courseDetailRequest);
        return response;
    }
    @Path("/get_course_by_id")
    @GET
    public List<CourseDetails> getCourseById(@QueryParam("course_id") String courseId){
        List<CourseDetails>  courseDetailses = courseService.getCourseDetailsById(courseId);
        return courseDetailses;
    }

    @Path("/get_all_courses")
    @GET
    public List<CourseDetails> getAllCourses(){
        List<CourseDetails>  courseDetailses = courseService.getAllCourse();
        return courseDetailses;
    }
}

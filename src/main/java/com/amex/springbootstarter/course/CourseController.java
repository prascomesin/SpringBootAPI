package com.amex.springbootstarter.course;


import com.amex.springbootstarter.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CourseController {

    @Autowired
	private CourseService courseService;
    


    @RequestMapping("/topics/{topicId}/courses")
    public List<Course> returnCourses(@PathVariable String topicId){
    	
        return courseService.getAllCourses(topicId);

    }

    @RequestMapping("/topics/{topicId}/courses/{id}")
    public Optional<Course> returnTopic(@PathVariable String id){
    	
        return courseService.getCoursebyId(id);

    }


    @RequestMapping(method = RequestMethod.POST, value="/topics/{topicId}/courses")
    public void addTopic(@RequestBody Course Tp, @PathVariable String topicId){

        courseService.addCourse(Tp, topicId);
    }

    @RequestMapping(method = RequestMethod.PUT, value="/topics/{topicId}/courses/{id}")
    public void updateTopic(@RequestBody Course Tp , @PathVariable String id, @PathVariable String topicId){
        
        courseService.updateCourse(Tp , id);
    }


    @RequestMapping(method = RequestMethod.DELETE, value="/topics/{topicId}/courses/{id}")
    public void deleteTopic(@PathVariable String id){
        courseService.deleteCourse(id);
    }

}

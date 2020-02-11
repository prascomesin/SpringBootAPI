package com.amex.springbootstarter.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amex.springbootstarter.topic.Topic;
import com.amex.springbootstarter.topic.TopicRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;
    
    @Autowired
    private TopicRepository topicRepository;
    
    
    
    
    public List<Course> getAllCourses(String topicId) {

        //return TopicList;
        List<Course> courseList = new ArrayList<>();

        courseRepository.findByTopicId(topicId)
                .forEach(courseList::add);

        return courseList;
    }

    public Optional<Course> getCoursebyId(String id){
        //return TopicList.stream().filter( t -> t.getId().equals(id) ).findFirst().get();
        return courseRepository.findById(id);
    }

    public void addCourse( Course Tp, String topicId) {
    	Optional<Topic> ot = topicRepository.findById(topicId);
    	Tp.setTopic(ot.orElse(new Topic(topicId , "new unknown", "new unknown")));    
    	topicRepository.save(ot.orElse(new Topic(topicId , "new unknown", "new unknown")));
    	
        courseRepository.save(Tp);


    }

    public void updateCourse(Course Tp, String id){
      
        courseRepository.save(Tp);
    }

    public void deleteCourse(String id){
        //TopicList.removeIf( t -> t.getId().equals(id));
        courseRepository.deleteById(id);
    }
}

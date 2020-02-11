package com.amex.springbootstarter.course;

import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface CourseRepository extends CrudRepository<Course, String> {

    //JPA allows you to search based on column names by using specific syntax eg: search courses by name
    public Course findByName(String name);

    public List<Course> findByTopicId (String topicId);

}

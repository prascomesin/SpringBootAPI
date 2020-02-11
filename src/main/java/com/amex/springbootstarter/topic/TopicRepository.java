package com.amex.springbootstarter.topic;

/*
 * Use methods from CrudRepository OOB
 * findAll
 * findById
 * save
 * deleteById
 */

import org.springframework.data.repository.CrudRepository;


public interface TopicRepository extends CrudRepository<Topic, String> {

}

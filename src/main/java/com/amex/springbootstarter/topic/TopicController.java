package com.amex.springbootstarter.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class TopicController {

	private TopicService topicService;
	
	public TopicService getTopicService() {
		return topicService;
	}

	@Autowired
	public void setTopicService(TopicService topicService) {
		this.topicService = topicService;
	}
	
	@RequestMapping("/topics")
    public List<Topic> returnTopics(){

        return topicService.getAllTopics();

    }

    @RequestMapping("/topics/{id}")
    public Optional<Topic> returnTopic(@PathVariable String id){
        return topicService.getTopicbyId(id);

    }


    @RequestMapping(method = RequestMethod.POST, value="/topics")
    public void addTopic(@RequestBody Topic Tp){
        topicService.addTopic(Tp);
    }

    @RequestMapping(method = RequestMethod.PUT, value="/topics/{id}")
    public void updateTopic(@RequestBody Topic Tp , @PathVariable String id){
        topicService.updateTopic(Tp , id);
    }


    @RequestMapping(method = RequestMethod.DELETE, value="/topics/{id}")
    public void deleteTopic(@PathVariable String id){
        topicService.deleteTopic(id);
    }

}

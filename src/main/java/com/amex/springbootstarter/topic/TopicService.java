package com.amex.springbootstarter.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;
    
    //Sample
    List<Topic> TopicList = new ArrayList<Topic>(Arrays.asList(
            new Topic("1", "Spring Framework" , "SpringFramework Desc" ),
            new Topic("2", "java Framework" , "Java Desc" ),
            new Topic("3", "JS Framework" , "JS Description" )
    ));

    public List<Topic> getAllTopics() {

        //return TopicList;
        List<Topic> topicList = new ArrayList<>();

        topicRepository.findAll()
                .forEach(topicList::add);

        return topicList;
    }

    public Optional<Topic> getTopicbyId(String id){
        //return TopicList.stream().filter( t -> t.getId().equals(id) ).findFirst().get();
        return topicRepository.findById(id);
    }

    public void addTopic( Topic Tp) {
        
        topicRepository.save(Tp);


    }

    public void updateTopic( Topic Tp, String id){
        
        topicRepository.save(Tp);
    }

    public void deleteTopic(String id){
        //TopicList.removeIf( t -> t.getId().equals(id));
        topicRepository.deleteById(id);
    }
}

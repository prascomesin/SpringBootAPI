package com.amex.springbootstarter.topic;

import org.hibernate.query.criteria.internal.expression.SizeOfPluralAttributeExpression;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class topicServiceTest {

    List<Topic> TopicList = new ArrayList<Topic>(Arrays.asList(
            new Topic("spring", "Spring Framework" , "SpringFramework Desc" ),
            new Topic("java", "java Framework" , "Java Desc" ),
            new Topic("javascript", "JS Framework" , "JS Description" )
    ));

    List<Topic> TopicList1 = new ArrayList<Topic>(Arrays.asList(
            new Topic("spring2", "Spring Framework" , "SpringFramework Desc" ),
            new Topic("java", "java Framework" , "Java Desc" ),
            new Topic("javascript", "JS Framework" , "JS Description" )
    ));



    @Mock
    TopicRepository myTR;

    @Autowired
    @InjectMocks
    TopicService myTs;

    @Test
    public void testTopicService(){


        //TopicRepository myTR = mock(TopicRepository.class);
        when(myTR.findAll()).thenReturn(TopicList);
        System.out.println(myTR.findAll());

        assertEquals(TopicList, myTs.getAllTopics());




    }

}

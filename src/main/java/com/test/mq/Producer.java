package com.test.mq;

import javax.jms.Queue;

import com.test.model.Model;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class Producer {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private Queue queue;

    @Autowired
    private ActiveMQTopic topic;

    int count = 0;

    @Scheduled(fixedDelay = 5000)//每5s执行1次
    public void sendTopic() {
        count++;
        Model model =new Model();
        model.setId(count);
        model.setName("topic name"+count);
        this.jmsTemplate.convertAndSend(this.topic, model);
    }

    @Scheduled(fixedDelay = 5000)//每5s执行1次
    public void sendQueue() {

        Model model =new Model();
        model.setId(count);
        model.setName("my queue..");
        this.jmsTemplate.convertAndSend(this.queue, model);
    }

}

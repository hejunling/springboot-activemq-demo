package com.test.mq;

import com.test.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    @Autowired
    private JmsTemplate jmsTemplate;

//    @JmsListener(destination = "sample.queue",containerFactory = "p2pFactory")
//    public void receiveQueue(Model model) {
//       System.out.println(model.toString());
//    }
    @JmsListener(destination = "sample.queue",containerFactory = "p2pFactory")//点对点的方式
    public void receiveQueue(Model model) {
        System.out.println("p2p-->"+model.toString());
    }

    @JmsListener(destination = "sample.topic",containerFactory = "psFactory")//订阅发布的方式
    public void receivetopic1(Model model) {
        System.out.println("topic1-->"+model.toString());
    }

    @JmsListener(destination = "sample.topic",containerFactory = "psFactory")
    public void receivetopic2(Model model) {
        System.out.println("topic2-->"+model.toString());
    }
    @JmsListener(destination = "sample.topic",containerFactory = "psFactory")
    public void receivetopic3(Model model) {
        System.out.println("topic3-->"+model.toString());
    }
}

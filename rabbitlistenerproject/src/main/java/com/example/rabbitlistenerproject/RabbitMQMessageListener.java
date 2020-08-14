package com.example.rabbitlistenerproject;

import com.rabbitmq.rabbitmqdemo.SimpleMessage;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

import java.io.ByteArrayInputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;

public class RabbitMQMessageListener implements MessageListener {
    @Override
    public void onMessage(Message message) {

        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(message.getBody());
            ObjectInput in = new ObjectInputStream(bis);
            SimpleMessage simpleMessage = (SimpleMessage) in.readObject();

            System.out.println("message = [" + simpleMessage + "]");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

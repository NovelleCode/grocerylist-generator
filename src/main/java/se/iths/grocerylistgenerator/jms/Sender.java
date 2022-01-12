package se.iths.grocerylistgenerator.jms;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import se.iths.grocerylistgenerator.config.JmsConfig;
import se.iths.grocerylistgenerator.entity.Message;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class Sender {

/*    JmsTemplate jmsTemplate;

    public Sender(JmsTemplate jmsTemplate){
        this.jmsTemplate = jmsTemplate;
    }

    @Scheduled(fixedRate = 20000)
    public void sendMessage(){

        System.out.println("Sending message testtext..");
        Message message = new Message(UUID.randomUUID(), "Message from grocerylistGenerator!", LocalDateTime.now());
        jmsTemplate.convertAndSend(JmsConfig.PROJECT_QUEUE, message);
        System.out.println("Messagetext test sent!");
    }*/

}

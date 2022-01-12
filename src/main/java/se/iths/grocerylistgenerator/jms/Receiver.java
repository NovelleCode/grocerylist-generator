//package se.iths.grocerylistgenerator.jms;
//
//import org.springframework.jms.annotation.JmsListener;
//import org.springframework.messaging.handler.annotation.Payload;
//import org.springframework.stereotype.Component;
//import se.iths.grocerylistgenerator.config.JmsConfig;
//import se.iths.grocerylistgenerator.entity.Message;
//
//@Component
//public class Receiver {
//    @JmsListener(destination = JmsConfig.PROJECT_QUEUE)
//    public void listen(@Payload Message message){
//        System.out.println("You got mail!");
//        System.out.println(message);
//    }
//}

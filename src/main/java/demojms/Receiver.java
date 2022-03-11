package demojms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import demojms.model.NotificationMessage;

@Component
public class Receiver {
  @Autowired
  JmsTemplate jmsTemplate;

    @JmsListener(destination = "x-ians", containerFactory = "myFactory")
    public void receiveMessage(NotificationMessage notif) {
      System.out.println("Received <"+ notif.getMessage() + ">");
    }    
// ===========================
//Exercise 2
    @JmsListener(destination = "ping-request", containerFactory = "myFactory")
    public void receiveMessagePong(NotificationMessage notif) {
      System.out.println("Received <"+ notif.getMessage() + ">");

      NotificationMessage notifPong = new NotificationMessage();
        notifPong.setMessage("Pong");
      jmsTemplate.convertAndSend("pong-request", notifPong);
    }
}


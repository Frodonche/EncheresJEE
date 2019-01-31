package jms;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;

@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup",
            propertyValue = "java:module/jms/myFacturationQueueRequest"),
    @ActivationConfigProperty(propertyName = "destinationType",
            propertyValue = "javax.jms.Queue")
})
public class MessageDrivenReceiver implements MessageListener {

    @Override
    public void onMessage(Message message) {
        System.out.println("J'ai reçu ça WESH : "+message.toString());
    }
 
}
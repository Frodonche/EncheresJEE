package jms;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSDestinationDefinition;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.apache.activemq.ActiveMQConnectionFactory;

@JMSDestinationDefinition(name = "java:module/jms/myFacturationQueueRequest", interfaceName = "javax.jms.Queue", resourceAdapter = "jmsra", destinationName = "myFacturationQueueRequest")
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "java:module/jms/myFacturationQueueRequest")
    ,
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class MessageDrivenReceiver implements MessageListener {
    
    @Resource(mappedName = "java:module/jms/myFacturationQueueResponse")
    private Queue myFacturationQueue;
    
    @Inject
    @JMSConnectionFactory("java:comp/DefaultJMSConnectionFactory")
    private JMSContext context;
    
    
    @Override
    public void onMessage(Message message) {
        try {
            // Reception du message
            TextMessage textMessage = (TextMessage) message;
            String msgString = textMessage.getText();
            System.out.println("J'ai reçu ça WESH : "+msgString);
            
            // Envoi de la réponse
            context.createProducer().send(myFacturationQueue, msgString + " REPONSE EN PLUS");
            



            
            //SenderBean sender = new SenderBean();
            //sender.setMessageText(msgString + " REPONSE EN PLUS");
            //sender.sendMsgToQueue();
            
        } catch (JMSException ex) {
            Logger.getLogger(MessageDrivenReceiver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
}
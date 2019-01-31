package jms;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.annotation.Resource;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;

/**
 *
 * @author guigu
 */
@Named(value = "senderBean")
@RequestScoped
public class SenderBean {

    @Resource(mappedName = "java:module/jms/myFacturationQueueRequest")
    private Queue myFacturationQueue;

    @Inject
    @JMSConnectionFactory("java:comp/DefaultJMSConnectionFactory")
    private JMSContext context;

    private String messageText;
    
    /**
     * Creates a new instance of SenderBean
     */
    public SenderBean() {
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public void sendMsgToQueue() {
        context.createProducer().send(myFacturationQueue, messageText);
    }
    
}

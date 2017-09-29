
package com.ifpb.dac.infra;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Queue;

@Stateless
public class Email {
//    sh asadmin create-jms-resource --restype javax.jms.Queue jms/dac/tigirina
    @Resource(lookup = "jms/dac/tigirina")
    private Queue queue;
    @Inject
    private JMSContext context;
    
    public void enviar(String msg){
        context.createProducer().send(queue, msg);
    }
    
    public String receber(){
        return context.createConsumer(queue).receiveBody(String.class);        
    }
    
}

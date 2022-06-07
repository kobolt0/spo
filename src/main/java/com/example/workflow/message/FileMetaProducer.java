package com.example.workflow.message;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.example.workflow.worker.FileInfoWorker;

@Service
public class FileMetaProducer {

	private final Logger LOGGER = Logger.getLogger(FileInfoWorker.class.getName());
    @Autowired
    private JmsTemplate jmsTemplate;

    
   public void sendTopicMsg(String topicStr, String email, String msg) {
        jmsTemplate.setPubSubDomain(false);
        jmsTemplate.convertAndSend(topicStr, new FileMeta(email, msg));
        LOGGER.info("email : "+email);
        LOGGER.info("message : "+msg);
        LOGGER.info("Sending an topic email message.");
        
    }
}

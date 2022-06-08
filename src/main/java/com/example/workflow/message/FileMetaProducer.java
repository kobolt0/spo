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

    
   public void sendTopicMsg(String topicStr, String size, String path) {
        jmsTemplate.setPubSubDomain(false);
        jmsTemplate.convertAndSend(topicStr, new FileMeta(size, path));
        LOGGER.info("email : "+size);
        LOGGER.info("message : "+path);
        LOGGER.info("Sending an message.");
        
    }
}

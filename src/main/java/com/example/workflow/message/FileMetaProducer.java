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

	public void sendMsg(String topicStr, String taskId, String fileId) {
		jmsTemplate.setPubSubDomain(false);
		
		TaskMsg taskMsg = new TaskMsg(taskId, fileId);
		jmsTemplate.convertAndSend(topicStr, taskMsg);
		
		LOGGER.info("Sending message." + taskMsg);
	}
}

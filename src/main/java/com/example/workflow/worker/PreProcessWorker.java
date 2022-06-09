package com.example.workflow.worker;

import java.util.Map;
import java.util.logging.Logger;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.workflow.message.FileMetaProducer;

@Service
public class PreProcessWorker implements JavaDelegate {
	private final Logger LOGGER = Logger.getLogger(PreProcessWorker.class.getName());

	@Autowired
	public FileMetaProducer fileMetaProduser;

	public void execute(DelegateExecution execution) {

		
		Map<String, Object> map = execution.getVariables();
		
		String fileId = String.valueOf(map.get("fileId"));
		String taskNm = execution.getBpmnModelElementInstance().getName();
		
		LOGGER.info("##  #################################");
		LOGGER.info("##  execution.getBpmnModelElementInstance().getName(): " + execution.getBpmnModelElementInstance().getName());
		LOGGER.info("##  fileId:" + fileId);
		LOGGER.info("##  getProcessInstanceId: " + execution.getProcessInstanceId());
		LOGGER.info("##  getActivityInstanceId: " + execution.getActivityInstanceId());
		LOGGER.info("##  getCurrentActivityId: " + execution.getCurrentActivityId());
		LOGGER.info("##  getId: " + execution.getId());
	
		// 메세지 생산
		fileMetaProduser.sendMsg("PreProcess", taskNm, fileId);

		LOGGER.info("\n\n  ####################################\n\n");

	}

}
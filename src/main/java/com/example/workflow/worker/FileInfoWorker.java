package com.example.workflow.worker;

import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.variable.value.IntegerValue;
import org.camunda.bpm.engine.variable.value.StringValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.workflow.message.FileMetaProducer;

@Service
public class FileInfoWorker implements JavaDelegate {
	private final Logger LOGGER = Logger.getLogger(FileInfoWorker.class.getName());

	@Autowired
	public FileMetaProducer fileMetaProduser;

	public void execute(DelegateExecution execution) {

		
		Set<String> valNames = execution.getVariableNames();
		
		IntegerValue val1 = execution.getVariableTyped("val1");
		IntegerValue val2 = execution.getVariableTyped("val2"); 
		

		
		LOGGER.info("\n\n##  #################################");
		LOGGER.info("##  execution.getBpmnModelElementInstance().getName(): " + execution.getBpmnModelElementInstance().getName());
		LOGGER.info("##  val1 " + val1.getValue());
		LOGGER.info("##  val2 " + val2.getValue());
		LOGGER.info("##  getProcessInstanceId: " + execution.getProcessInstanceId());
		LOGGER.info("##  getActivityInstanceId: " + execution.getActivityInstanceId());
		LOGGER.info("##  getCurrentActivityId: " + execution.getCurrentActivityId());
		LOGGER.info("##  getId: " + execution.getId());
		
		for (int i = 0; i < val1.getValue(); i++) {
			for (int j = 0; j < val2.getValue(); j++) {
				
			}
			LOGGER.info("sleep ...  " + i);
		}
		
		// 메세지 생산
		fileMetaProduser.sendTopicMsg("File", val1.getValue().toString(), new Date().toString());
		
//		try {
//			LOGGER.info("\n\n  sleep ...  " + val1.getValue() + "mil \n\n");
//			Thread.sleep(val1.getValue()); // 대기
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		LOGGER.info("\n\n  ####################################\n\n");

	}

}
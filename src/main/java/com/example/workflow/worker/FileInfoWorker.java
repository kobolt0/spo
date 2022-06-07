package com.example.workflow.worker;

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

		StringValue val1 = execution.getVariableTyped("val1");
		String str = val1.getValue();
		LOGGER.info("\n\n  ... Now val1 " + val1.getValue() + "\n\n");
		fileMetaProduser.sendTopicMsg("File", "seze", "tiem");

		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LOGGER.info("\n\n  val1 " + val1.getValue() + "\n\n");
		
	}

}
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
public class TestWorker implements JavaDelegate {
	private final Logger LOGGER = Logger.getLogger(TestWorker.class.getName());

	@Autowired
	public FileMetaProducer fileMetaProduser;

	public void execute(DelegateExecution execution) {

		StringValue val1 = execution.getVariableTyped("val1");
		LOGGER.info("\n\n test  val1 " + val1.getValue() + "\n\n");
		
	}

}
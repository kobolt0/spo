package com.example.workflow.worker;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Logger;

public class FileInfoWorker implements JavaDelegate {
  private final Logger LOGGER = Logger.getLogger(FileInfoWorker.class.getName());

  public void execute(DelegateExecution execution)  {

    LOGGER.info("\n\n  ... Now notifying creditor " + execution.getVariable("creditor") + "\n\n");
  }

}
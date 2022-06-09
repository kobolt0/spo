package com.example.workflow.message;

public class TaskMsg {

    private String taskId;
    private String fileId;
    
	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	public String getFileId() {
		return fileId;
	}
	public void setFileId(String fileId) {
		this.fileId = fileId;
	}
	
	@Override
	public String toString() {
		return "taskMsg [taskId=" + taskId + ", fileId=" + fileId + "]";
	}
	public TaskMsg(String taskId, String fileId) {
		super();
		this.taskId = taskId;
		this.fileId = fileId;
	}

    
  }

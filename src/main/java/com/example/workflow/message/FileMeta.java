package com.example.workflow.message;

public class FileMeta {

    private String size;
    private String createTime;

    public FileMeta() {
    }


	public String getSize() {
		return size;
	}


	public void setSize(String size) {
		this.size = size;
	}


	public String getCreateTime() {
		return createTime;
	}


	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}


	public FileMeta(String size, String createTime) {
		super();
		this.size = size;
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "FileMeta [size=" + size + ", createTime=" + createTime + "]";
	}



//    @Override
//    public String toString() {
//      return String.format("Email{to=%s, body=%s}", getTo(), getBody());
//    }

  }

package com.example.ojsystem.pojo;

public class Code {
	private int id;				//代码编号
	private int problemId;		//所属题目编号
	private int type;			//代码语言
	private String templateCode;//模板代码
	private String testCode;	//测试代码

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProblemId() {
		return problemId;
	}

	public void setProblemId(int problemId) {
		this.problemId = problemId;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getTemplateCode() {
		return templateCode;
	}

	public void setTemplateCode(String templateCode) {
		this.templateCode = templateCode;
	}

	public String getTestCode() {
		return testCode;
	}

	public void setTestCode(String testCode) {
		this.testCode = testCode;
	}

	@Override
	public String toString() {
		return "Code{" +
				"id=" + id +
				", problemId=" + problemId +
				", type=" + type +
				", templateCode='" + templateCode + '\'' +
				", testCode='" + testCode + '\'' +
				'}';
	}
}

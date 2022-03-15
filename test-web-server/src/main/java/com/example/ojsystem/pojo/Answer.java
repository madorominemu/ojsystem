package com.example.ojsystem.pojo;

public class Answer {
	//最终返回页面上的信息
	//运行结果是否正确
	private int errno;	//0编译运行正常 1编译出错 2运行抛出异常
						//出错原因
						//errno 1 , reason包含了编译错误的信息
						//errno 2 , reason包含了异常的调用栈信息

	private String reason;	//
	private String stdout;	//标准输出
	private String stderr;	//标准错误

	public int getErrno() {
		return errno;
	}

	public void setErrno(int errno) {
		this.errno = errno;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getStdout() {
		return stdout;
	}

	public void setStdout(String stdout) {
		this.stdout = stdout;
	}

	public String getStderr() {
		return stderr;
	}

	public void setStderr(String stderr) {
		this.stderr = stderr;
	}

	@Override
	public String toString() {
		return "Answer{" +
				"errno=" + errno +
				", reason='" + reason + '\'' +
				", stdout='" + stdout + '\'' +
				", stderr='" + stderr + '\'' +
				'}';
	}
}

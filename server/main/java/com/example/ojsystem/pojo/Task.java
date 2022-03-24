package com.example.ojsystem.pojo;

import com.example.ojsystem.utils.CommandUtil;
import com.example.ojsystem.utils.FileUtil;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class Task {
	//    所有的临时文件需要放进这个目录中
	private String WORK_DIR;
	//    要编译执行的类的名字，影响到源代码的文件名
	private String CLASS = "Solution";
	//    要编译的文件名
	private String CODE;
	//    程序标准输出放置的文件
	private String STDOUT;
	//    程序标准错误放置的文件
	private String STDERR;
	//    程序编译出错的详细信息放置的文件
	private String COMPILE_ERROR;

	public Task(){
		//先生成唯一的id，再根据这个id来拼装出目录的名字
		WORK_DIR = "./tmp/" + UUID.randomUUID().toString() + "/";
		//然后再生成后续的这些文件名
		CODE = WORK_DIR + CLASS + ".java";
		STDOUT = WORK_DIR + "stdout.txt";
		STDERR = WORK_DIR + "stderr.txt";
		COMPILE_ERROR = WORK_DIR + "compile_error.txt";
	}

	public Answer compileAndRun(Question question) throws IOException, InterruptedException {
		Answer answer = new Answer();

		File file = new File(WORK_DIR);
		if(!file.exists()){
			file.mkdirs();
		}

		FileUtil.writeFile(CODE, question.getCode());

//        2.构造编译指令（javac）,并进行执行，预期得到的结果
//        就是一个对应的.class文件，以及编译出错的文件
//        -d表示 生成的.class文件放置的位置
		String compileCmd = "javac -encoding utf-8 " + CODE + " -d " + WORK_DIR;
//        创建子进程进行编译，此处不关心javac的标准输出（标准输出没内容）
//        只关心javac的标准错误，标准错误中就包含了编译出错的信息
		CommandUtil.run(compileCmd, null, COMPILE_ERROR);
//        此处判定一下编译是否出错。看一下compile_error.txt这个文件是不是空就知道了
		String compileError = FileUtil.readFile(COMPILE_ERROR);
		if(!compileError.equals("")){
//            编译文件不为空，说明编译出错了
			answer.setErrno(1);
			answer.setReason(compileError);
			return answer;
		}
//        就是为了让java命令找到.class 文件的位置，还需要加上一个选项
//        -classpath通过这个选项来执行.class文件放到哪个目录里了
//        java Solution
		String rumCmd = String.format("java -classpath %s %s", WORK_DIR, CLASS);
		CommandUtil.run(rumCmd, STDOUT, STDERR);
//        尝试读取STDERR这个文件里面的内容，如果不为空，就认为是运行出错
//        如果程序抛出异常，异常的调用栈信息就是通过stderr来输出的
		String runError = FileUtil.readFile(STDERR);
		if(!runError.equals("")){
			answer.setErrno(2);
			answer.setReason(runError);
			return answer;
		}
		answer.setErrno(0);
		String runStdout = FileUtil.readFile(STDOUT);
		answer.setStdout(runStdout);
		return answer;
	}

	public String getWORK_DIR() {
		return WORK_DIR;
	}

	public void setWORK_DIR(String WORK_DIR) {
		this.WORK_DIR = WORK_DIR;
	}

	public String getCLASS() {
		return CLASS;
	}

	public void setCLASS(String CLASS) {
		this.CLASS = CLASS;
	}

	public String getCODE() {
		return CODE;
	}

	public void setCODE(String CODE) {
		this.CODE = CODE;
	}

	public String getSTDOUT() {
		return STDOUT;
	}

	public void setSTDOUT(String STDOUT) {
		this.STDOUT = STDOUT;
	}

	public String getSTDERR() {
		return STDERR;
	}

	public void setSTDERR(String STDERR) {
		this.STDERR = STDERR;
	}

	public String getCOMPILE_ERROR() {
		return COMPILE_ERROR;
	}

	public void setCOMPILE_ERROR(String COMPILE_ERROR) {
		this.COMPILE_ERROR = COMPILE_ERROR;
	}
}

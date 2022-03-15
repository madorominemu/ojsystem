package com.example.ojsystem.test;

import com.example.ojsystem.pojo.Answer;
import com.example.ojsystem.pojo.Question;
import com.example.ojsystem.pojo.Task;

import java.io.IOException;

public class test {
	public static void main(String[] args) throws IOException, InterruptedException, IOException {
		Question question = new Question();
		Task task = new Task();
		question.setCode("public class Solution {\n" +
				"    public static void main(String[] args) {\n" +
				"        System.out.println(\"stdout\");\n" +
				"        String s = \"abc\";\n" +
				"        System.out.println(s.length());\n" +
				"    }\n" +
				"}\n");
		Answer answer = task.compileAndRun(question);
		System.out.println(answer);
	}
}


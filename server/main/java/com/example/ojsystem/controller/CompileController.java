package com.example.ojsystem.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.ojsystem.pojo.*;
import com.example.ojsystem.service.CodeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
@RequestMapping("/compile")
public class CompileController {

	private final CodeService codeService;

	public CompileController(CodeService codeService) {
		this.codeService = codeService;
	}

	/**
	 * 执行
	 */
	@RequestMapping(value = "/execute",method = RequestMethod.POST)
	public Object addProblem(HttpServletRequest request) {
		JSONObject jsonObject = new JSONObject();
		//获取前端传来的参数
		int problemId = Integer.parseInt(request.getParameter("problemId").trim());
		int type = Integer.parseInt(request.getParameter("type").trim());
		String templateCode = request.getParameter("templateCode").trim();

		Code code = new Code();
		code = codeService.selectCodeByProblemIdAndType(problemId,type);

		String finalCode = mergeCode(templateCode, code.getTestCode());

		Task task = new Task();
		Question question = new Question();
		question.setCode(finalCode);
		Answer answer = new Answer();
		try {
			answer = task.compileAndRun(question);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		CompileResponse compileResponse = new CompileResponse();
		compileResponse.setErrno(answer.getErrno());
		compileResponse.setReason(answer.getReason());
		compileResponse.setStdout(answer.getStdout());

		return compileResponse;

//		System.out.println(answer);
//		System.out.println(compileResponse.getErrno());
//		System.out.println(compileResponse.getReason());
//		System.out.println(compileResponse.getStdout());
//
//		if(compileResponse != null){
//			jsonObject.put(Consts.CODE,1);
//			jsonObject.put(Consts.MSG,"执行成功");
//			return jsonObject;
//		}
//		jsonObject.put(Consts.CODE,0);
//		jsonObject.put(Consts.MSG,"执行失败");
//		return jsonObject;
	}

	private String mergeCode(String requestCode, String testCode) {
		int pos = requestCode.lastIndexOf("}");
		if(pos == -1){
			return null;
		}
		return requestCode.substring(0, pos) + testCode + "}";
	}
}

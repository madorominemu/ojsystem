package com.example.ojsystem.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.ojsystem.pojo.Code;
import com.example.ojsystem.service.CodeService;
import com.example.ojsystem.utils.Consts;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 代码管理controller
 */
@RestController
@RequestMapping("/code")
public class CodeController {

	private final CodeService codeService;

	public CodeController(CodeService codeService) {
		this.codeService = codeService;
	}

	/**
	 * 添加代码
	 */
	@RequestMapping(value = "add",method = RequestMethod.POST)
	public Object addCode(HttpServletRequest request) {
		JSONObject jsonObject = new JSONObject();
		int problemId = Integer.parseInt(request.getParameter("problemId").trim());
		String type = request.getParameter("type").trim();
		String templateCode = request.getParameter("templateCode").trim();
		String testCode = request.getParameter("testCode").trim();
		int typee = 0;
		switch (type) {
			case "Java":
				typee = 1;
		}
		Code code = new Code();
		code.setProblemId(problemId);
		code.setType(typee);
		code.setTemplateCode(templateCode);
		code.setTestCode(testCode);
		boolean flag = codeService.insert(code);

		if (flag) {
			jsonObject.put(Consts.CODE, 1);
			jsonObject.put(Consts.MSG, "保存成功");
			return jsonObject;
		}
		jsonObject.put(Consts.CODE, 0);
		jsonObject.put(Consts.MSG, "保存失败");
		return jsonObject;
	}

	/**
	 * 修改代码
	 */
	@RequestMapping(value = "/update",method = RequestMethod.POST)
	public Object updateCode(HttpServletRequest request) {
		JSONObject jsonObject = new JSONObject();
		int problemId = Integer.parseInt(request.getParameter("problemId").trim());
		String type = request.getParameter("type").trim();
		String templateCode = request.getParameter("templateCode").trim();
		String testCode = request.getParameter("testCode").trim();
		int typee = 0;
		switch (type) {
			case "Java":
				typee = 1;
		}
		Code code = new Code();
		code.setProblemId(problemId);
		code.setType(typee);
		code.setTemplateCode(templateCode);
		code.setTestCode(testCode);
		boolean flag = codeService.update(code);

		if (flag) {
			jsonObject.put(Consts.CODE, 1);
			jsonObject.put(Consts.MSG, "保存成功");
			return jsonObject;
		}
		jsonObject.put(Consts.CODE, 0);
		jsonObject.put(Consts.MSG, "保存失败");
		return jsonObject;
	}

	/**
	 * 删除代码
	 */
	@RequestMapping(value = "/delete",method = RequestMethod.GET)
	public Object deleteCode(HttpServletRequest request){
		int problemId = Integer.parseInt(request.getParameter("problemId").trim());
		boolean flag = codeService.deleteCodeByProblemId(problemId);
		return flag;
	}

	/**
	 * 根据题目id和代码语言类型查询代码对象
	 */
	@RequestMapping(value = "/selectByProblemIdAndType",method = RequestMethod.POST)
	public Object selectCodeByProblemIdAndType(HttpServletRequest request) {
		int problemId = Integer.parseInt(request.getParameter("problemId").trim());
		int type = Integer.parseInt(request.getParameter("type").trim());
		return codeService.selectCodeByProblemIdAndType(problemId,type);
	}

	/**
	 * 根据题目id查询代码对象列表
	 */
	@RequestMapping(value = "/selectByProblemId",method = RequestMethod.GET)
	public Object selectCodeByProblemId(HttpServletRequest request) {
		int problemId = Integer.parseInt(request.getParameter("problemId").trim());
		return codeService.selectCodeByProblemId(problemId);
	}
}

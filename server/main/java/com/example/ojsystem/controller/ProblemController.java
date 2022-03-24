package com.example.ojsystem.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.ojsystem.pojo.Code;
import com.example.ojsystem.pojo.Problem;
import com.example.ojsystem.service.CodeService;
import com.example.ojsystem.service.ProblemService;
import com.example.ojsystem.utils.Consts;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 题目管理controller
 */
@RestController
@RequestMapping("/problem")
public class ProblemController {

	private final ProblemService problemService;
	private final CodeService codeService;

	public ProblemController(ProblemService problemService, CodeService codeService) {
		this.problemService = problemService;
		this.codeService = codeService;
	}

	/**
	 * 添加题目
	 */
	@RequestMapping(value = "/add",method = RequestMethod.POST)
	public Object addProblem(HttpServletRequest request) {
		JSONObject jsonObject = new JSONObject();
		//获取前端传来的参数
		String title = request.getParameter("title").trim();
		String level = request.getParameter("level").trim();
		String description = request.getParameter("description").trim();

		Problem problem = new Problem();
		problem.setTitle(title);
		problem.setLevel(level);
		problem.setDescription(description);
		boolean flag = problemService.insert(problem);
		if(flag){
			jsonObject.put(Consts.CODE,1);
			jsonObject.put(Consts.MSG,"保存成功");
			return jsonObject;
		}
		jsonObject.put(Consts.CODE,0);
		jsonObject.put(Consts.MSG,"保存失败");
		return jsonObject;
	}

	/**
	 * 修改题目
	 */
	@RequestMapping(value = "/update",method = RequestMethod.POST)
	public Object updateProblem(HttpServletRequest request) {
		JSONObject jsonObject = new JSONObject();
		//获取前端传来的参数
		String id = request.getParameter("id").trim();
		String title = request.getParameter("title").trim();
		String level = request.getParameter("level").trim();
		String description = request.getParameter("description").trim();

		int problemId = Integer.parseInt(request.getParameter("problemId").trim());
		int type = Integer.parseInt(request.getParameter("type").trim());
		String templateCode = request.getParameter("templateCode").trim();
		String testCode = request.getParameter("testCode").trim();

		Problem problem = new Problem();
		problem.setId(Integer.parseInt(id));
		problem.setTitle(title);
		problem.setLevel(level);
		problem.setDescription(description);
		boolean flag = problemService.update(problem);

		Code code = new Code();
		code.setProblemId(problemId);
		code.setType(type);
		code.setTemplateCode(templateCode);
		code.setTestCode(testCode);

		Code codee = codeService.selectCodeByProblemIdAndType(problemId,type);
		boolean flag1 = false;

		if(codee == null) {
			flag1 = codeService.insert(code);
		}else{
			flag1 = codeService.update(code);
		}

		if(flag && flag1){
			jsonObject.put(Consts.CODE,1);
			jsonObject.put(Consts.MSG,"保存成功");
			return jsonObject;
		}
		jsonObject.put(Consts.CODE,0);
		jsonObject.put(Consts.MSG,"保存失败");
		return jsonObject;
	}

	/**
	 * 删除题目
	 */
	@RequestMapping(value = "/delete",method = RequestMethod.GET)
	public Object deleteProblem(HttpServletRequest request){
		int problemId = Integer.parseInt(request.getParameter("id").trim());
		boolean flag = problemService.delete(problemId);

		List<Code> codee = codeService.selectCodeByProblemId(problemId);
		boolean flag1 = false;
		if(codee.isEmpty()) {
			flag1 = true;
			return flag && flag1;

		}else{
			flag1 = codeService.deleteCodeByProblemId(problemId);
			return flag && flag1;
		}
	}

	/**
	 * 根据题目id查询题目对象
	 */
	@RequestMapping(value = "/selectProblemByPrimaryKey",method = RequestMethod.GET)
	public Object selectProblemByPrimaryKey(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id").trim());
		return problemService.selectProblemByPrimaryKey(id);
	}

	/**
	 * 查询所有题目
	 */
	@RequestMapping(value = "/allProblem",method = RequestMethod.GET)
	public Object selectAllProblem(HttpServletRequest request) {
		return problemService.selectAllProblem();
	}
}
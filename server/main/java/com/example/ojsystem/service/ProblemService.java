package com.example.ojsystem.service;

import com.example.ojsystem.pojo.Problem;

import java.util.List;

/**
 * 题目service接口
 */
public interface ProblemService {
	/**
	 * 增加
	 */
	public boolean insert(Problem problem);

	/**
	 * 修改
	 */
	public boolean update(Problem problem);

	/**
	 * 删除
	 */
	public boolean delete(Integer id);

	/**
	 * 根据主键查询整个题目对象
	 */
	public Problem selectProblemByPrimaryKey(Integer id);

	/**
	 * 查询所有题目
	 */
	public List<Problem> selectAllProblem();

	/**
	 * 根据题目难度查询
	 */
	public List<Problem> selectProblemByLevel(String level);

	/**
	 * 根据题目名模糊查询
	 */
	public List<Problem> selectProblemByTitleLike(String title);
}

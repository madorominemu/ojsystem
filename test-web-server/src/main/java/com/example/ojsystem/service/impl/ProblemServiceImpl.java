package com.example.ojsystem.service.impl;

import com.example.ojsystem.mapper.ProblemMapper;
import com.example.ojsystem.pojo.Problem;
import com.example.ojsystem.service.ProblemService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 题目service实现类
 */
@Service
public class ProblemServiceImpl implements ProblemService{

	private final ProblemMapper problemMapper;

	public ProblemServiceImpl(ProblemMapper problemMapper) {
		this.problemMapper = problemMapper;
	}

	/**
	 * 增加
	 *
	 * @param problem
	 */
	@Override
	public boolean insert(Problem problem) {
		return problemMapper.insert(problem)>0;
	}

	/**
	 * 修改
	 *
	 * @param problem
	 */
	@Override
	public boolean update(Problem problem) {
		return problemMapper.update(problem)>0;
	}

	/**
	 * 删除
	 *
	 * @param id
	 */
	@Override
	public boolean delete(Integer id) {
		return problemMapper.delete(id)>0;
	}

	/**
	 * 根据主键查询整个题目对象
	 *
	 * @param id
	 */
	@Override
	public Problem selectProblemByPrimaryKey(Integer id) {
		return problemMapper.selectProblemByPrimaryKey(id);
	}

	/**
	 * 查询所有题目
	 */
	@Override
	public List<Problem> selectAllProblem() {
		return problemMapper.selectAllProblem();
	}

	/**
	 * 根据题目难度查询
	 *
	 * @param level
	 */
	@Override
	public List<Problem> selectProblemByLevel(String level) {
		return problemMapper.selectProblemByLevel(level);
	}

	/**
	 * 根据题目名模糊查询
	 *
	 * @param title
	 */
	@Override
	public List<Problem> selectProblemByTitleLike(String title) {
		return problemMapper.selectProblemByTitleLike("%"+title+"%");
	}
}

package com.example.ojsystem.mapper;

import com.example.ojsystem.pojo.Problem;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 题目Dao
 */
@Repository
public interface ProblemMapper {
	/**
	 * 增加
	 */
	public int insert(Problem problem);

	/**
	 * 修改
	 */
	public int update(Problem problem);

	/**
	 * 删除
	 */
	public int delete(Integer id);

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

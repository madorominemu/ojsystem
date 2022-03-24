package com.example.ojsystem.service;

import com.example.ojsystem.pojo.Code;

import java.util.List;

/**
 * 代码service接口
 */
public interface CodeService {
	/**
	 * 增加
	 */
	public boolean insert(Code code);

	/**
	 * 修改
	 */
	public boolean update(Code code);

	/**
	 * 删除
	 */
	public boolean deleteCodeByProblemId(Integer problemId);

	/**
	 * 根据所属题目id和代码语言类型查询代码对象
	 */
	public Code selectCodeByProblemIdAndType(Integer problemId,Integer type);

	/**
	 * 根据题目id和代码语言类型查询代码对象
	 * @return
	 */
	public List<Code> selectCodeByProblemId(Integer problemId);
}

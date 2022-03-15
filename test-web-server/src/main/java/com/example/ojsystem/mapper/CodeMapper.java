package com.example.ojsystem.mapper;

import com.example.ojsystem.pojo.Code;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 代码Dao
 */
@Repository
public interface CodeMapper {
	/**
	 * 增加
	 */
	public int insert(Code code);

	/**
	 * 修改
	 */
	public int update(Code code);

	/**
	 * 删除
	 */
	public int deleteCodeByProblemId(Integer problemId);

	/**
	 * 根据所属题目id和代码语言类型查询代码对象
	 */
	public Code selectCodeByProblemIdAndType(Integer problemId,Integer type);

	/**
	 * 根据所属题目id查询代码对象
	 */
	public List<Code> selectCodeByProblemId(Integer problemId);
}

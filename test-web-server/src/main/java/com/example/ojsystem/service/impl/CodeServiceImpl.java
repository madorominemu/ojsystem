package com.example.ojsystem.service.impl;

import com.example.ojsystem.mapper.CodeMapper;
import com.example.ojsystem.pojo.Code;
import com.example.ojsystem.service.CodeService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 代码service实现类
 */
@Service
public class CodeServiceImpl implements CodeService {

	private final CodeMapper codeMapper;

	public CodeServiceImpl(CodeMapper codeMapper) {
		this.codeMapper = codeMapper;
	}

	/**
	 * 增加
	 *
	 * @param code
	 */
	@Override
	public boolean insert(Code code) {
		return codeMapper.insert(code)>0;
	}

	/**
	 * 修改
	 *
	 * @param code
	 */
	@Override
	public boolean update(Code code) {
		return codeMapper.update(code)>0;
	}

	/**
	 * 删除
	 *
	 * @param problemId
	 */
	@Override
	public boolean deleteCodeByProblemId(Integer problemId) {
		return codeMapper.deleteCodeByProblemId(problemId)>0;
	}

	/**
	 * 根据所属题目id和代码语言类型查询代码对象
	 *
	 * @param problemId
	 * @param type
	 */
	@Override
	public Code selectCodeByProblemIdAndType(Integer problemId, Integer type) {
		return codeMapper.selectCodeByProblemIdAndType(problemId,type);
	}

	/**
	 * 根据题目id和代码语言类型查询代码对象
	 *
	 * @param problemId
	 */
	@Override
	public List<Code> selectCodeByProblemId(Integer problemId) {
		return codeMapper.selectCodeByProblemId(problemId);
	}
}

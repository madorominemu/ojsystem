package com.example.ojsystem.service.impl;

import com.example.ojsystem.mapper.UserMapper;
import com.example.ojsystem.pojo.User;
import com.example.ojsystem.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户service实现类
 */
@Service
public class UserServiceImpl implements UserService {

	private final UserMapper userMapper;

	public UserServiceImpl(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	/**
	 * 增加
	 *
	 * @param user
	 */
	@Override
	public boolean insert(User user) {
		return userMapper.insert(user)>0;
	}

	/**
	 * 修改
	 *
	 * @param user
	 */
	@Override
	public boolean update(User user) {
		return userMapper.update(user)>0;
	}

	/**
	 * 删除
	 *
	 * @param id
	 */
	@Override
	public boolean delete(Integer id) {
		return userMapper.delete(id)>0;
	}

	/**
	 * 根据主键查询整个对象
	 *
	 * @param id
	 */
	@Override
	public User selectUserByPrimaryKey(Integer id) {
		return userMapper.selectUserByPrimaryKey(id);
	}

	/**
	 * 查询所有用户
	 */
	@Override
	public List<User> selectAllUser() {
		return userMapper.selectAllUser();
	}

	/**
	 * 根据账号查询
	 *
	 * @param username
	 */
	@Override
	public User selectUserByUsername(String username) {
		return userMapper.selectUserByUsername(username);
	}

	/**
	 * 登录验证密码
	 *
	 * @param username
	 * @param password
	 */
	@Override
	public boolean verifyPassword(String username, String password) {
		return userMapper.verifyPassword(username,password)>0;
	}
}

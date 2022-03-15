package com.example.ojsystem.service;

import com.example.ojsystem.pojo.User;

import java.util.List;

/**
 * 用户service接口
 */
public interface UserService {
	/**
	 *增加
	 */
	public boolean insert(User user);

	/**
	 *修改
	 */
	public boolean update(User user);

	/**
	 *删除
	 */
	public boolean delete(Integer id);

	/**
	 *根据主键查询整个对象
	 */
	public User selectUserByPrimaryKey(Integer id);

	/**
	 *查询所有用户
	 */
	public List<User> selectAllUser();

	/**
	 * 根据账号查询
	 */
	public User selectUserByUsername(String username);

	/**
	 * 登录验证密码
	 */
	public boolean verifyPassword(String username,String password);
}

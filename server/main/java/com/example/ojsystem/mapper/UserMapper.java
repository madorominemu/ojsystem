package com.example.ojsystem.mapper;

import com.example.ojsystem.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 前端用户Dao
 */
@Repository
public interface UserMapper {
	/**
	 *增加
	 */
	public int insert(User user);

	/**
	 *修改
	 */
	public int update(User user);

	/**
	 *删除
	 */
	public int delete(Integer id);

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
	public int verifyPassword(String username,String password);
}

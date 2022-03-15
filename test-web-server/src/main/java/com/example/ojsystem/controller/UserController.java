package com.example.ojsystem.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.ojsystem.pojo.User;
import com.example.ojsystem.service.UserService;
import com.example.ojsystem.utils.Consts;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * 用户管理controller
 */
@RestController
@RequestMapping("/user")
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	/**
	 * 添加前端用户
	 */
	@RequestMapping(value = "/add",method = RequestMethod.POST)
	public Object addUser(HttpServletRequest request) {
		JSONObject jsonObject = new JSONObject();
		String username = request.getParameter("username").trim();
		String password = request.getParameter("password").trim();
		String sex = request.getParameter("sex").trim();
		String birth = request.getParameter("birth").trim();
		String phoneNum = request.getParameter("phoneNum").trim();
		String location = request.getParameter("location").trim();
		String email = request.getParameter("email").trim();
		String introduction = request.getParameter("introduction").trim();
		String avatar = request.getParameter("avatar").trim();

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		java.sql.Date birthDate = null;
		try {
			birthDate = new java.sql.Date(dateFormat.parse(birth).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}

		if (username == null || "".equals(username)) {
			jsonObject.put(Consts.CODE, 0);
			jsonObject.put(Consts.MSG, "用户名不能为空");
			return jsonObject;
		}

		User userr = userService.selectUserByUsername(username);
		if (userr != null) {
			jsonObject.put(Consts.CODE, 0);
			jsonObject.put(Consts.MSG, "用户名已存在");
			return jsonObject;
		}

		if (password == null || "".equals(password)) {
			jsonObject.put(Consts.CODE, 0);
			jsonObject.put(Consts.MSG, "密码不能为空");
			return jsonObject;
		}

		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setSex(new Byte(sex));
		user.setBirth(birthDate);
		user.setPhoneNum(phoneNum);
		user.setLocation(location);
		user.setEmail(email);
		user.setIntroduction(introduction);
		user.setAvatar(avatar);

		boolean flag = userService.insert(user);
		if (flag) {
			jsonObject.put(Consts.CODE, 1);
			jsonObject.put(Consts.MSG, "添加成功");
			return jsonObject;
		}
		jsonObject.put(Consts.CODE, 0);
		jsonObject.put(Consts.MSG, "添加失败");
		return jsonObject;
	}

	/**
	 * 删除前端用户
	 */
	@RequestMapping(value = "/delete",method = RequestMethod.GET)
	public Object deleteUser(HttpServletRequest request){
		String id = request.getParameter("id").trim();
		boolean flag = userService.delete(Integer.parseInt(id));
		return flag;
	}

	/**
	 * 修改前端用户
	 */
	@RequestMapping(value = "/update",method = RequestMethod.POST)
	public Object updateUser(HttpServletRequest request){
		JSONObject jsonObject = new JSONObject();
		String id = request.getParameter("id").trim();
		String username = request.getParameter("username").trim();
		String password = request.getParameter("password").trim();
		String sex = request.getParameter("sex").trim();
		String birth = request.getParameter("birth").trim();
		String phoneNum = request.getParameter("phoneNum").trim();
		String location = request.getParameter("location").trim();
		String email = request.getParameter("email").trim();
		String introduction = request.getParameter("introduction").trim();

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		java.sql.Date birthDate = null;
		try {
			birthDate = new java.sql.Date(dateFormat.parse(birth).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}

		User user = new User();
		user.setId(Integer.parseInt(id));
		user.setUsername(username);
		user.setPassword(password);
		user.setSex(new Byte(sex));
		user.setBirth(birthDate);
		user.setPhoneNum(phoneNum);
		user.setLocation(location);
		user.setEmail(email);
		user.setIntroduction(introduction);

		boolean flag = userService.update(user);
		if (flag) {
			jsonObject.put(Consts.CODE, 1);
			jsonObject.put(Consts.MSG, "添加成功");
			return jsonObject;
		}
		jsonObject.put(Consts.CODE, 0);
		jsonObject.put(Consts.MSG, "添加失败");
		return jsonObject;
	}

	/**
	 * 查询所有前端用户
	 */
	@RequestMapping(value = "/allUser",method = RequestMethod.GET)
	public Object allUser(HttpServletRequest request){
		return userService.selectAllUser();
	}

	/**
	 * 更新前端用户头像图片
	 */
	@RequestMapping(value = "/updateUserPic",method = RequestMethod.POST)
	public Object updateUserPic(@RequestParam("file") MultipartFile avatarFile, @RequestParam("id")int id) {
		JSONObject jsonObject = new JSONObject();
		if (avatarFile.isEmpty()) {
			jsonObject.put(Consts.CODE, 0);
			jsonObject.put(Consts.MSG, "文件上传失败");
			return jsonObject;
		}
		//文件名=当前时间到毫秒+原来的文件名
		String fileName = System.currentTimeMillis() + avatarFile.getOriginalFilename();
		//文件路径
		String filePath = System.getProperty("user.dir") + System.getProperty("file.separator") + "img" + System.getProperty("file.separator") + "avatarImages";
		//如果文件路径不存在，新增该路径
		File file1 = new File(filePath);
		if (!file1.exists()) {
			file1.mkdir();
		}
		//实际的文件地址
		File dest = new File(filePath + System.getProperty("file.separator") + fileName);
		//存储到数据库里的相对文件地址
		String storeAvatarPath = "/img/avatarImages/" + fileName;
		try {
			avatarFile.transferTo(dest);
			User user = new User();
			user.setId(id);
			user.setAvatar(storeAvatarPath);
			boolean flag = userService.update(user);
			if (flag) {
				jsonObject.put(Consts.CODE, 1);
				jsonObject.put(Consts.MSG, "上传成功");
				jsonObject.put("avatar", storeAvatarPath);
				return jsonObject;
			}
			jsonObject.put(Consts.CODE, 0);
			jsonObject.put(Consts.MSG, "上传失败");
			return jsonObject;
		} catch (IOException e) {
			jsonObject.put(Consts.CODE, 0);
			jsonObject.put(Consts.MSG, "上传失败" + e.getMessage());
		} finally {
			return jsonObject;
		}
	}
}

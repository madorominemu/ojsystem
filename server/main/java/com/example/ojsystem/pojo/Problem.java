package com.example.ojsystem.pojo;

public class Problem {
	private int id;				//题目编号
	private String title;		//题目标题
	private String level;		//题目难度
	private String description;	//题目详细信息

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Problem{" +
				"id=" + id +
				", title='" + title + '\'' +
				", level='" + level + '\'' +
				", description='" + description + '\'' +
				'}';
	}
}

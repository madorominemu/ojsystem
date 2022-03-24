//package com.example.ojsystem.test;
//
//import com.example.ojsystem.pojo.Problem;
//import com.example.ojsystem.service.impl.ProblemServiceImpl;
//
//import java.util.List;
//
//public class problemDaoTest {
//	private static void testSelectOne(){
//		ProblemServiceImpl problemDAO = new ProblemServiceImpl();
//		Problem problem = problemDAO.selectProblemByPrimaryKey(1);
//		System.out.println(problem);
//	}
//
//	private static void testSelectAll(){
//		ProblemServiceImpl problemDAO = new ProblemServiceImpl();
//		List<Problem> problems = problemDAO.selectAllProblem();
//		System.out.println(problems);
//	}
//
//	private static void testDelete(){
//		ProblemServiceImpl problemDAO = new ProblemServiceImpl();
//		problemDAO.delete(1);
//	}
//
//	private static void testInsert(){
//		Problem problem = new Problem();
//		problem.setTitle("两数之和");
//		problem.setLevel("简单");
//		problem.setDescription("给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。\\n\" +\n" +
//				"                \"\\n\" +\n" +
//				"                \"你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。\\n\" +\n" +
//				"                \"\\n\" +\n" +
//				"                \"你可以按任意顺序返回答案。\\n\" +\n" +
//				"                \"\\n\" +\n" +
//				"                \" \\n\" +\n" +
//				"                \"\\n\" +\n" +
//				"                \"示例 1：\\n\" +\n" +
//				"                \"\\n\" +\n" +
//				"                \"输入：nums = [2,7,11,15], target = 9\\n\" +\n" +
//				"                \"输出：[0,1]\\n\" +\n" +
//				"                \"解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。\\n\" +\n" +
//				"                \"示例 2：\\n\" +\n" +
//				"                \"\\n\" +\n" +
//				"                \"输入：nums = [3,2,4], target = 6\\n\" +\n" +
//				"                \"输出：[1,2]\\n\" +\n" +
//				"                \"示例 3：\\n\" +\n" +
//				"                \"\\n\" +\n" +
//				"                \"输入：nums = [3,3], target = 6\\n\" +\n" +
//				"                \"输出：[0,1]\\n\" +\n" +
//				"                \" \\n\" +\n" +
//				"                \"\\n\" +\n" +
//				"                \"提示：\\n\" +\n" +
//				"                \"\\n\" +\n" +
//				"                \"2 <= nums.length <= 103\\n\" +\n" +
//				"                \"-109 <= nums[i] <= 109\\n\" +\n" +
//				"                \"-109 <= target <= 109\\n\" +\n" +
//				"                \"只会存在一个有效答案\\n\" +\n" +
//				"                \"\\n\" +\n" +
//				"                \"来源：力扣（LeetCode）\\n\" +\n" +
//				"                \"链接：https://leetcode-cn.com/problems/two-sum\\n\" +\n");
//
//		ProblemServiceImpl problemDao = new ProblemServiceImpl();
//		problemDao.insert(problem);
//	}
//
//	public static void main(String[] args) {
////		1.测试插入逻辑
//		testInsert();
////      2.测试删除逻辑
////      testDelete();
////      3.测试查找所有记录
////      testSelectAll();
////      4.测试验证一条记录
////      testSelectOne();
//	}
//}

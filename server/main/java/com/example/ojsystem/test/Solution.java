package com.example.ojsystem.test;

class Solution {
	public int[] twoSum(int[] nums, int target) {
		int[] indexs = new int[2];
		for(int i=0; i<nums.length; i++){
			for(int j=nums.length-1; j>i; j--){
				if(nums[i]+nums[j]==target){
					indexs[0] = i;
					indexs[1] = j;
				}
			}
		}
		return indexs;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();

		int[] arr = {2,7,11,15};
		int target1 = 9;
		int[] result = solution.twoSum(arr, target1);
		if (result.length == 2 && result[0] == 0 && result[1] == 1) {
            System.out.println("TestCase OK!");
        } else {
            System.out.println("TestCase Failed! arr: {2, 7, 11, 15}, target: 9");
        }

		int[] arr2 = {3,2,4};
		int target2 = 6;
		int[] result2 = solution.twoSum(arr2, target2);
		if (result2.length == 2 && result2[0] == 1 && result2[1] == 2) {
			System.out.println("TestCase OK!");
		} else {
			System.out.println("TestCase Failed! arr: {3,2,4}, target: 6");
		}

		int[] arr3 = {3,3};
		int target3 = 6;
		int[] result3 = solution.twoSum(arr3, target3);
		if (result3.length == 2 && result2[0] == 0 && result2[1] == 1) {
			System.out.println("TestCase OK!");
		} else {
			System.out.println("TestCase Failed! arr: {3,3}, target: 6");
		}
    }
}
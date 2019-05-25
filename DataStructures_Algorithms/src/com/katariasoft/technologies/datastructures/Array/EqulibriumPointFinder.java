package com.katariasoft.technologies.datastructures.Array;

import java.util.stream.IntStream;

//https://leetcode.com/problems/find-pivot-index/solution/ 
//Submitted successfully.

public class EqulibriumPointFinder {

	public int pivotIndex(int[] nums) {
		int totalSum = IntStream.of(nums).sum();
		int leftSum = 0;
		int length = nums.length - 1;
		for (int i = 0; i <= length; i++) {
			if (leftSum == totalSum - leftSum - nums[i])
				return i;
			leftSum += nums[i];
		}
		return -1;
	}

}

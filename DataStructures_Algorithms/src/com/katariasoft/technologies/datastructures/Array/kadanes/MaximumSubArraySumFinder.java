package com.katariasoft.technologies.datastructures.Array.kadanes;

import static com.katariasoft.technologies.datastructures.helper.CommonHelper.*;

public class MaximumSubArraySumFinder {

	public static int find(int[] inputArr) {
		int maxSum = Integer.MIN_VALUE;
		int currentSum = 0;
		for (int i = 0; i <= inputArr.length - 1; i++) {
			currentSum += inputArr[i];
			if (currentSum > maxSum)
				maxSum = currentSum;
			if (currentSum < 0)
				currentSum = 0;
		}
		return maxSum;
	}

	public static void main(String args[]) {
		print((MaximumSubArraySumFinder.find(new int[] { -1, -2, -3, -4, -5 })));
		print((MaximumSubArraySumFinder.find(new int[] { -1, -2, -3, -4, 0 })));
		print((MaximumSubArraySumFinder.find(new int[] { -1, -2, -3, -4, -5 })));
		print((MaximumSubArraySumFinder.find(new int[] { 0, 0, 0, 0, 0 })));
		print((MaximumSubArraySumFinder.find(new int[] { -1, 16 })));
		print((MaximumSubArraySumFinder.find(new int[] { 0, 16 })));
		print((MaximumSubArraySumFinder.find(new int[] { 1, 2, -5, 10, 16 })));

	}

}

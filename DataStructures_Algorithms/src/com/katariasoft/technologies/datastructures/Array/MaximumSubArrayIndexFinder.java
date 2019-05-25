package com.katariasoft.technologies.datastructures.Array;

import static com.katariasoft.technologies.datastructures.helper.CommonHelper.*;

import java.util.stream.IntStream;

public class MaximumSubArrayIndexFinder {

	public static Integer[] find(int[] inputArr) {
		int maxSum = Integer.MIN_VALUE;
		int currentSum = 0;
		int startIndex = -1;
		int endIndex = -1;
		for (int i = 0; i <= inputArr.length - 1; i++) {
			boolean wasCurrSumZero = currentSum == 0;
			currentSum += inputArr[i];
			if (currentSum > maxSum) {
				maxSum = currentSum;
				if (wasCurrSumZero)
					startIndex = endIndex = i;
				else
					endIndex = i;
			}
			if (currentSum < 0)
				currentSum = 0;
		}
		return IntStream.of(startIndex, endIndex).boxed().toArray(Integer[]::new);
	}

	public static void main(String args[]) {
		printArray((MaximumSubArrayIndexFinder.find(new int[] { -1, -2, -3, -4, -5 })));
		printArray((MaximumSubArrayIndexFinder.find(new int[] { -1, -2, -3, -4, 0 })));
		printArray((MaximumSubArrayIndexFinder.find(new int[] { -1, -2, -3, -4, -5 })));
		printArray((MaximumSubArrayIndexFinder.find(new int[] { 0, 0, 0, 0, 0 })));
		printArray((MaximumSubArrayIndexFinder.find(new int[] { -1, 16 })));
		printArray((MaximumSubArrayIndexFinder.find(new int[] { 0, 16 })));
		printArray((MaximumSubArrayIndexFinder.find(new int[] { 1, 2, -5, 10, 16 })));
		printArray((MaximumSubArrayIndexFinder.find(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 })));

	}

}

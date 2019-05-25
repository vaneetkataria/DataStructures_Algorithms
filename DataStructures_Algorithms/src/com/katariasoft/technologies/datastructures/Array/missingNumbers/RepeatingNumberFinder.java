package com.katariasoft.technologies.datastructures.Array.missingNumbers;

import java.util.ArrayList;
import java.util.List;

import com.katariasoft.technologies.datastructures.helper.CommonHelper;

/*
 * Given an array of n elements which contains elements from 0 to n-1, 
 * with any of these numbers appearing any number of times. 
 * Find these repeating numbers in O(n) and using only constant memory space.
   For example, let n be 7 and array be {1, 2, 3, 1, 3, 6, 6}, the answer should be 1, 3 and 6.
 */

public class RepeatingNumberFinder {

	public static Integer[] find(int[] arr) {
		List<Integer> repeatingNos = new ArrayList<>();
		for (int i = 0; i <= arr.length - 1; i++) {
			int currentVal = Math.abs(arr[i]);
			if (arr[currentVal] < 0)
				repeatingNos.add(currentVal);
			else
				arr[currentVal] = -arr[currentVal];

		}
		return repeatingNos.stream().toArray(Integer[]::new);
	}

	public static void main(String[] args) {
		CommonHelper.printArray(RepeatingNumberFinder.find(new int[] { 1, 2, 3, 3, 3 }));
		CommonHelper.printArray(RepeatingNumberFinder.find(new int[] { 1, 1 }));
		CommonHelper.printArray(RepeatingNumberFinder.find(new int[] { 0 }));
		CommonHelper.printArray(RepeatingNumberFinder.find(new int[] { 1, 1, 3, 3, 5, 6, 7, 8, 8 }));
		CommonHelper.printArray(RepeatingNumberFinder.find(new int[] { 1, 5, 5, 5, 5, 5 }));

	}

}

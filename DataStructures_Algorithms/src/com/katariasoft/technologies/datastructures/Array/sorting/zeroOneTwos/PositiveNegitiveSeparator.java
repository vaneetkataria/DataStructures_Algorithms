package com.katariasoft.technologies.datastructures.Array.sorting.zeroOneTwos;

import java.util.Arrays;

import com.katariasoft.technologies.datastructures.helper.CommonHelper;

public final class PositiveNegitiveSeparator {

	public static Integer[] sort(int[] arr) {

		int l = 0;
		int r = arr.length - 1;
		while (l < r) {
			while (arr[l] < 0 && l < arr.length - 1)
				l++;
			if (l >= r)
				break;

			while (arr[r] >= 0 && r > 0)
				r--;
			if (r <= l)
				break;

			swap(arr, l, r);
			l++;
			r--;
		}

		return Arrays.stream(arr).boxed().toArray(Integer[]::new);

	}

	private static void swap(int[] arr, int l, int h) {
		int temp = arr[l];
		arr[l] = arr[h];
		arr[h] = temp;
	}

	public static void main(String args[]) {

		CommonHelper.printArray(PositiveNegitiveSeparator.sort(new int[] { -1 }));
		CommonHelper.printArray(PositiveNegitiveSeparator.sort(new int[] { -1 , -1 }));
		CommonHelper.printArray(PositiveNegitiveSeparator.sort(new int[] { 0, -1 }));
		CommonHelper.printArray(PositiveNegitiveSeparator.sort(new int[] { 0, 0 }));
		CommonHelper.printArray(PositiveNegitiveSeparator.sort(new int[] { 1, -1 }));
		CommonHelper.printArray(PositiveNegitiveSeparator.sort(new int[] { 1, -1, 1, -1 }));
		CommonHelper.printArray(PositiveNegitiveSeparator.sort(new int[] { 1, -1, 0, 0 }));
		CommonHelper.printArray(PositiveNegitiveSeparator.sort(new int[] { 1, -1, 0, 0, 1, -1, 0, 0, 1, 1, 0, 0 }));
		CommonHelper.printArray(PositiveNegitiveSeparator.sort(new int[] { 1, 1, 0, 0, 1, -1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0,
				0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1,
				0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1,
				1, 0, 0, 1, 1, 0, 0 }));

	}

}

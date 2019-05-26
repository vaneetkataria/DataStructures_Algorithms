package com.katariasoft.technologies.datastructures.Array.sorting.zeroOneTwos;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public final class ZeroOneTwoSorter {

	public static int[] sort(int[] arr) {

		int low = 0;
		int high = arr.length - 1;
		int pivot = 0;

		while (pivot <= high) {
			switch (arr[pivot]) {
			case 0:
				swap(arr, low, pivot);
				low++;
				pivot++;
				break;
			case 1:
				pivot++;
				break;
			case 2:
				swap(arr, pivot, high);
				high--;
				break;
			}
		}
		return arr;
	}

	private static void swap(int[] arr, int l, int h) {
		int temp = arr[l];
		arr[l] = arr[h];
		arr[h] = temp;
	}

	public static void main(String args[]) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("");
		try {
			int numTestCases = Integer.parseInt(br.readLine());
			while (numTestCases > 0) {
				int arraySize = Integer.parseInt(br.readLine());
				int[] arr = new int[arraySize];
				String[] strArray = br.readLine().split(" ");
				for (int i = 0; i <= strArray.length - 1; i++)
					arr[i] = Integer.parseInt(strArray[i]);
				int[] output = sort(arr);
				for (int i = 0; i < output.length; i++)
					sb.append(output[i]).append(" ");
				sb.append("\n");
				numTestCases--;
			}
			System.out.println(sb.toString());
		} catch (Exception e) {
		}

	}

}

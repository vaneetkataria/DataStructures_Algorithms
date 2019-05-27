package com.katariasoft.technologies.datastructures.Array.reverse;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GroupWiseSubArrayReverser {

	public static int[] reverse(int[] arr, int groupSize) {

		int low = 0;
		int high = groupSize - 1;

		while (low < arr.length - 1) {
			if (high > arr.length - 1)
				high = arr.length - 1;
			reverseSubArray(arr, low, high);
			low += groupSize;
			high += groupSize;
		}

		return arr;

	}

	private static void reverseSubArray(int[] arr, int low, int high) {
		while (low < high) {
			swap(arr, low, high);
			low++;
			high--;
		}
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
				String[] arraySizeGroupSizeArr = br.readLine().split(" ");
				int arraySize = Integer.parseInt(arraySizeGroupSizeArr[0]);
				int groupSize = Integer.parseInt(arraySizeGroupSizeArr[1]);
				int[] arr = new int[arraySize];
				String[] strArray = br.readLine().split(" ");
				for (int i = 0; i <= strArray.length - 1; i++)
					arr[i] = Integer.parseInt(strArray[i]);
				int[] revrsedArray = reverse(arr, groupSize);
				for (int i = 0; i <= revrsedArray.length - 1; i++)
					sb.append(revrsedArray[i] + " ");
				sb.append("\n");
				numTestCases--;
			}
			System.out.println(sb.toString());
		} catch (Exception e) {
		}

	}

}

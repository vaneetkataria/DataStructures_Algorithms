package com.katariasoft.technologies.datastructures.Array.misc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ArrayZigZagFasionArranger {

	public static int[] arrange(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			boolean isEvenIndex = i % 2 == 0;
			if (isEvenIndex && arr[i] > arr[i + 1])
				swap(arr, i, i + 1);
			else if (!isEvenIndex && arr[i] < arr[i + 1])
				swap(arr, i, i + 1);
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
				int[] output = arrange(arr);
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

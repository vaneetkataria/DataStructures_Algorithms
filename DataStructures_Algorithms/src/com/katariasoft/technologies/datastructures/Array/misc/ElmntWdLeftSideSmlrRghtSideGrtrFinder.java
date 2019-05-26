package com.katariasoft.technologies.datastructures.Array.misc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ElmntWdLeftSideSmlrRghtSideGrtrFinder {

	public static int find(int arr[]) {

		int leftMax = Integer.MIN_VALUE;
		int[] leftMaxArr = new int[arr.length];
		for (int i = 1; i <= arr.length - 1; i++) {
			leftMax = Math.max(arr[i - 1], leftMax);
			leftMaxArr[i] = leftMax;
		}

		int finalIndex = -1;
		int rightMin = Integer.MAX_VALUE;
		for (int j = arr.length - 2; j > 0; j--) {
			rightMin = Math.min(rightMin, arr[j + 1]);
			if (arr[j] > leftMaxArr[j] && arr[j] < rightMin)
				finalIndex = j;
		}

		return arr[finalIndex];

	}

	public static void main(String args[]) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int numTestCases = Integer.parseInt(br.readLine());
			while (numTestCases > 0) {
				int arraySize = Integer.parseInt(br.readLine());
				int[] arr = new int[arraySize];
				String[] strArray = br.readLine().split(" ");
				for (int i = 0; i <= strArray.length - 1; i++)
					arr[i] = Integer.parseInt(strArray[i].trim());
				int output = find(arr);
				System.out.println(output);
				System.out.println("\n");
				numTestCases--;

			}
		} catch (Exception e) {
		}
	}
}

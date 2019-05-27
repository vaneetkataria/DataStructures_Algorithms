package com.katariasoft.technologies.datastructures.Array.reallife;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TrappingRainWaterMeasurer {

	private static int measure(int[] arr) {

		int volume = 0;
		int leftMax = Integer.MIN_VALUE;
		int[] leftMaxArr = new int[arr.length];

		for (int i = 0; i <= arr.length - 1; i++) {
			leftMax = Math.max(leftMax, arr[i]);
			leftMaxArr[i] = leftMax;
		}

		int rightMax = Integer.MIN_VALUE;
		for (int j = arr.length - 1; j >= 0; j--) {
			rightMax = Integer.max(rightMax, arr[j]);
			volume += Math.min(leftMaxArr[j], rightMax) - arr[j];
		}

		return volume;

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
				sb.append(measure(arr) + "\n");
				numTestCases--;
			}
			System.out.println(sb.toString());
		} catch (Exception e) {
		}

	}

}

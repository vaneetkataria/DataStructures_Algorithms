package com.katariasoft.technologies.datastructures.Array.missingRepeating;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MissingAndRepeatingNumberFinder {

	public static int[] find(int[] arr) {

		int minRepeatingVal = Integer.MAX_VALUE;
		int minMissingValue = Integer.MAX_VALUE;

		for (int i = 0; i <= arr.length - 1; i++) {
			int currentVal = arr[i];
			int indexTobeMarked = Math.abs(currentVal) - 1;
			if (arr[indexTobeMarked] < 0)
				minRepeatingVal = Math.min(minRepeatingVal, Math.abs(currentVal));
			else
				arr[indexTobeMarked] = -arr[indexTobeMarked];
		}

		for (int i = 0; i <= arr.length - 1; i++)
			if (arr[i] > 0)
				minMissingValue = Math.min(minMissingValue, i + 1);

		return new int[] { minRepeatingVal, minMissingValue };

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
					arr[i] = Integer.parseInt(strArray[i]);
				int[] output = find(arr);
				for (int i = 0; i < output.length; i++)
					System.out.print(output[i] + " ");
				System.out.println();
				numTestCases--;
			}
		} catch (Exception e) {
		}

	}

}

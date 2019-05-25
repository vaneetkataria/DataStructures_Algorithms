package com.katariasoft.technologies.datastructures.Array.missingNumbers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MissingNumberFinder {

	public static int find(int[] arr) {
		int expectedLength = arr.length + 1;
		return ((expectedLength * (expectedLength + 1)) / 2) - Arrays.stream(arr).sum();
	}

	public static int findByXOR(int[] arr) {
		int actualXOR = 0;
		for (int i = 0; i <= arr.length - 1; i++)
			actualXOR ^= arr[i];
		int expectedXOR = 0;
		for (int i = 1; i <= arr.length + 1; i++)
			expectedXOR ^= i;

		return actualXOR ^ expectedXOR;

	}

	public static void main(String args[]) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int numTestCases = Integer.parseInt(br.readLine());
			while (numTestCases > 0) {
				int arraySize = Integer.parseInt(br.readLine()) - 1;
				int[] arr = new int[arraySize];
				String[] array = br.readLine().split(" ");
				for (int i = 0; i <= arraySize - 1; i++)
					arr[i] = Integer.parseInt(array[i]);
				System.out.println(findByXOR(arr));
				numTestCases--;
			}
		} catch (Exception e) {
		}

	}

}

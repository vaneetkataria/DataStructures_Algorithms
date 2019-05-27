package com.katariasoft.technologies.datastructures.Array.reallife;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ChocolatesDisrtibutor {

	public static int distrubute(int[] arr, int numStudents) {

		if (numStudents == 1)
			return 0;

		Arrays.sort(arr);

		int minDiff = Integer.MAX_VALUE;
		int low = 0;
		int high = numStudents - 1;

		while (high <= arr.length - 1) {
			int diff = arr[high] - arr[low];
			minDiff = Math.min(minDiff, diff);
			low++;
			high++;
		}

		return minDiff;

	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int numTestCases = Integer.parseInt(br.readLine());
			while (numTestCases > 0) {
				int arraySize = Integer.parseInt(br.readLine());

				int[] arrivalArr = new int[arraySize];
				String[] arrivals = br.readLine().split(" ");
				for (int i = 0; i <= arrivals.length - 1; i++)
					arrivalArr[i] = Integer.parseInt(arrivals[i]);

				int numStudents = Integer.parseInt(br.readLine());

				System.out.println(distrubute(arrivalArr, numStudents) + "\n");
				numTestCases--;
			}
		} catch (Exception e) {
		}
	}

}

package com.katariasoft.technologies.datastructures.Array.triplets;

import java.util.Arrays;
import java.util.Scanner;

/*
 * This class can find triplet iff numbers are positive .
 * 
 * 
 */
public class SumClosetsToZeroDoubletFinder {

	public static int count(int[] arr) {
		// sort Array First.
		Arrays.sort(arr);
		int minSum = Integer.MAX_VALUE;

		int minA = -1;
		int minB = -1;

		int aIndex = 0;
		int bIndex = arr.length - 1;
		while (true) {
			if (aIndex >= bIndex)
				break;
			int sum = arr[aIndex] + arr[bIndex];
			if (sum == 0)
				return 0;
			int absSum = Math.abs(sum);
			if (absSum < minSum) {
				minSum = absSum;
				minA = aIndex;
				minB = bIndex;
			}
			if (sum > 0)
				bIndex--;
			else
				aIndex++;
		}

		return arr[minA] + arr[minB];

	}

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		int numTestCases = sc.nextInt();
		while (numTestCases > 0) {
			int arraySize = sc.nextInt();
			int[] arr = new int[arraySize];
			for (int i = 0; i <= arraySize - 1; i++)
				arr[i] = sc.nextInt();
			System.out.println(count(arr));
			numTestCases--;
		}

	}

}

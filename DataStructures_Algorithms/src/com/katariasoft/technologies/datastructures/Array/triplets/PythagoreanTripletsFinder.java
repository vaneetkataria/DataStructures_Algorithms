package com.katariasoft.technologies.datastructures.Array.triplets;

import java.util.Arrays;
import java.util.Scanner;

/*
 * This class can find triplet iff numbers are positive .
 * 
 * 
 */
public class PythagoreanTripletsFinder {

	public static boolean count(int[] arr) {
		// sort Array First.
		for (int i = 0; i <= arr.length - 1; i++)
			arr[i] = arr[i] * arr[i];
		Arrays.sort(arr);
		// a*a+b*b =c*c
		int cIndex = arr.length - 1;
		while (cIndex >= 2) {
			int aIndex = 0;
			int bIndex = cIndex - 1;
			while (true) {
				if (aIndex >= bIndex)
					break;
				int sum = arr[aIndex] + arr[bIndex];
				int cSquare = arr[cIndex];
				if (sum == cSquare) {
					return true;
				} else if (sum > arr[cIndex])
					bIndex--;
				else
					aIndex++;
			}
			cIndex--;
		}
		return false;

	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int numTestCases = sc.nextInt();
		while (numTestCases > 0) {
			int arraySize = sc.nextInt();
			int[] arr = new int[arraySize];
			for (int i = 0; i <= arraySize - 1; i++)
				arr[i] = sc.nextInt();
			System.out.println(count(arr) ? "Yes" : "No");
			numTestCases--;
		}

	}

}

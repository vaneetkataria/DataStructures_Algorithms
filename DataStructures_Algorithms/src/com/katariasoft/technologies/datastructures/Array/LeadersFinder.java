package com.katariasoft.technologies.datastructures.Array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LeadersFinder {

	public static void find(int[] arr) {
		int currLeader = arr[arr.length - 1];
		System.out.print(currLeader + " ");
		for (int i = arr.length - 2; i >= 0; i--) {
			if (arr[i] >= currLeader) {
				currLeader = arr[i];
				System.out.print(currLeader + " ");
			}
		}
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
				find(arr);
				System.out.println();
				numTestCases--;
			}
		} catch (Exception e) {
		}

	}

}

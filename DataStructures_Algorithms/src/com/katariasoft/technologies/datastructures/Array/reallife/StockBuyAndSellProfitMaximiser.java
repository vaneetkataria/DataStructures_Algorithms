package com.katariasoft.technologies.datastructures.Array.reallife;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/submissions/

public class StockBuyAndSellProfitMaximiser {

	public static int maximiseAndGet(int[] arr) {

		int profit = 0;
		int localMinima = 0;
		int localMaxima = 0;

		while (localMinima < arr.length - 1) {

			while (localMinima < arr.length - 1 && arr[localMinima + 1] <= arr[localMinima])
				localMinima++;

			if (localMinima == arr.length - 1)
				break;

			localMaxima = localMinima + 1;

			if (localMaxima == arr.length - 1) {
				profit += arr[localMaxima] - arr[localMinima];
				break;
			}

			while (localMaxima < arr.length - 1 && arr[localMaxima + 1] >= arr[localMaxima])
				localMaxima++;

			profit += arr[localMaxima] - arr[localMinima];
			localMinima = localMaxima = localMaxima + 1;
		}

		return profit;
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
				sb.append(maximiseAndGet(arr) + "\n");
				numTestCases--;
			}
			System.out.println(sb.toString());
		} catch (Exception e) {
		}

	}

}

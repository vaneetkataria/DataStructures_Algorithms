package com.katariasoft.technologies.datastructures.Array.reallife;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//https://practice.geeksforgeeks.org/problems/stock-buy-and-sell/0

public class StockBuyAndSellMaxProfitDaysChoser {

	public static String choose(int[] arr) {

		StringBuilder sb = new StringBuilder("");
		int localMinima = 0;
		int localMaxima = 0;

		while (localMinima < arr.length - 1) {

			while (localMinima < arr.length - 1 && arr[localMinima + 1] <= arr[localMinima])
				localMinima++;

			if (localMinima == arr.length - 1)
				break;

			localMaxima = localMinima + 1;

			if (localMaxima == arr.length - 1) {
				sb.append("(").append(localMinima + " ").append(localMaxima).append(") ");
				break;
			}

			while (localMaxima < arr.length - 1 && arr[localMaxima + 1] >= arr[localMaxima])
				localMaxima++;

			sb.append("(").append(localMinima + " ").append(localMaxima).append(") ");
			localMinima = localMaxima = localMaxima + 1;
		}

		String profitDays = sb.toString();
		return profitDays.isEmpty() ? "No Profit" : profitDays;
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
				sb.append(choose(arr) + "\n");
				numTestCases--;
			}
			System.out.println(sb.toString());
		} catch (Exception e) {
		}

	}

}

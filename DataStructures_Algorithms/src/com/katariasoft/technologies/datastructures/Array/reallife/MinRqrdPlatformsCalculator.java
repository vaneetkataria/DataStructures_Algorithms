package com.katariasoft.technologies.datastructures.Array.reallife;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MinRqrdPlatformsCalculator {

	public static int calculate(int[] arrivals, int[] departures) {
		Arrays.sort(arrivals);
		Arrays.sort(departures);

		int minPlatforms = 0;
		int numPlatforms = 0;
		int aLow = 0;
		int dLow = 0;

		while (aLow <= arrivals.length - 1) {
			if (arrivals[aLow] < departures[dLow]) {
				numPlatforms++;
				minPlatforms = Math.max(minPlatforms, numPlatforms);
				aLow++;
			} else if (arrivals[aLow] > departures[dLow]) {
				numPlatforms--;
				dLow++;
			} else {
				aLow++;
				dLow++;
			}

		}

		return minPlatforms;

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

				int[] departureArr = new int[arraySize];
				String[] departures = br.readLine().split(" ");
				for (int i = 0; i <= departures.length - 1; i++)
					departureArr[i] = Integer.parseInt(departures[i]);

				System.out.println(calculate(arrivalArr, departureArr) + "\n");
				numTestCases--;
			}
		} catch (Exception e) {
		}
	}
}

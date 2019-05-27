package com.katariasoft.technologies.datastructures.Array.merge;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TwoSortedArraysMerger {
	
	public static int[] merge(int[] first, int[] second) {

		int[] mergedArray = new int[first.length + second.length];

		int aLow = 0;
		int bLow = 0;
		int mergeIndex = 0;

		while (aLow <= first.length - 1 && bLow <= second.length - 1) {

			if (first[aLow] < second[bLow]) {
				mergedArray[mergeIndex] = first[aLow];
				aLow++;
				mergeIndex++;
			}

			else if (second[bLow] < first[aLow]) {
				mergedArray[mergeIndex] = second[bLow];
				bLow++;
				mergeIndex++;
			}

			else {
				mergedArray[mergeIndex] = first[aLow];
				mergeIndex++;
				aLow++;
				mergedArray[mergeIndex] = second[bLow];
				mergeIndex++;
				bLow++;
			}

		}

		if (aLow <= first.length - 1) {
			while (aLow <= first.length - 1) {
				mergedArray[mergeIndex] = first[aLow];
				mergeIndex++;
				aLow++;
			}
		}

		if (bLow <= second.length - 1) {
			while (bLow <= second.length - 1) {
				mergedArray[mergeIndex] = second[bLow];
				mergeIndex++;
				bLow++;
			}
		}

		return mergedArray;

	}

	public static void main(String args[]) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("");
		try {
			int numTestCases = Integer.parseInt(br.readLine());
			while (numTestCases > 0) {

				String[] arraysSizeArr = br.readLine().split(" ");
				int firstArraySize = Integer.parseInt(arraysSizeArr[0]);
				int secondArraySize = Integer.parseInt(arraysSizeArr[1]);

				int[] firsrArr = new int[firstArraySize];
				String[] strArray = br.readLine().split(" ");
				for (int i = 0; i <= strArray.length - 1; i++)
					firsrArr[i] = Integer.parseInt(strArray[i]);

				int[] secondArr = new int[secondArraySize];
				String[] secondStrArray = br.readLine().split(" ");
				for (int i = 0; i <= secondStrArray.length - 1; i++)
					secondArr[i] = Integer.parseInt(secondStrArray[i]);

				int[] mergedArray = merge(firsrArr, secondArr);
				for (int i = 0; i <= mergedArray.length - 1; i++)
					sb.append(mergedArray[i] + " ");
				sb.append("\n");
				numTestCases--;
			}
			System.out.println(sb.toString());
		} catch (Exception e) {
		}

	}


}

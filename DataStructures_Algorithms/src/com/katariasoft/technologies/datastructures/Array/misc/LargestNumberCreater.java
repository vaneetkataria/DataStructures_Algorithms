package com.katariasoft.technologies.datastructures.Array.misc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LargestNumberCreater {

	public static String create(int[] arr) {
		String[] nums = Arrays.stream(arr).mapToObj(i -> i + "").toArray(String[]::new);
		Arrays.sort(nums, Comparator.comparing(Function.identity(), (s1, s2) -> (s2 + s1).compareTo(s1 + s2)));
		String number = Arrays.stream(nums).collect(Collectors.joining());
		return number.startsWith("0") ? "0" : number;
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
				System.out.println(create(arr) + "\n");
				numTestCases--;

			}
		} catch (Exception e) {
		}
	}

}

package com.katariasoft.technologies.datastructures.Array.sorting.heap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

//https://www.hackerrank.com/contests/hw1/challenges/heap-sort/submissions/code/1314405812

public class MaxHeap extends Heap {

	public static MaxHeap of(int... arr) {
		return new MaxHeap(arr);
	}

	protected MaxHeap(int[] arr) {
		super(arr);
	}

	@Override
	public boolean shouldSwap(int[] arr, int parent, int child) {
		return arr[parent] < arr[child];
	}

	public int chooseSwappable(int[] arr, int left, int right) {
		return arr[left] >= arr[right] ? left : right;
	}

	public static void main(String args[]) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("[");
		try {
			int arraySize = Integer.parseInt(br.readLine());
			int[] arr = new int[arraySize];
			for (int i = 0; i <= arraySize - 1; i++)
				arr[i] = Integer.parseInt(br.readLine());
			int[] sortedArr = MaxHeap.of(arr).extractAll();
			String output = Arrays.stream(sortedArr).boxed().map(String::valueOf).collect(Collectors.joining(","));
			System.out.println("[" + output + "]");

		} catch (Exception e) {
			System.err.println(e);
		}

	}

}

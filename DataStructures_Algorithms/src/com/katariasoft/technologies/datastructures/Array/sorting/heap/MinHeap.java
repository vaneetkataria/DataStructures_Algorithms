package com.katariasoft.technologies.datastructures.Array.sorting.heap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

//https://www.hackerrank.com/contests/hw1/challenges/heap-sort/submissions/code/1314405812

public class MinHeap {

	private int size = 0;
	private int[] data;

	public static MinHeap of(int... arr) {
		return new MinHeap(arr);
	}

	private MinHeap(int[] arr) {
		if (Objects.isNull(arr) || arr.length == 0)
			throw new IllegalArgumentException("Input Array should be of size greater than zero.");
		init(arr);
	}

	private void init(int[] arr) {
		data = new int[arr.length];
		for (int i : arr)
			place(i);
	}

	private void place(int i) {
		data[size] = i;
		size++;
		heapifyUp(i);
	}

	private void heapifyUp(int i) {
		int current = size - 1;
		while (current > 0) {
			int parent = (current - 1) / 2;
			if (data[parent] > data[current]) {
				swap(data, parent, current);
				current = parent;
			} else
				break;
		}

	}

	private void swap(int[] arr, int l, int h) {
		int temp = arr[l];
		arr[l] = arr[h];
		arr[h] = temp;
	}

	public int extract() {
		if (size == 0)
			throw new RuntimeException("Empty Heap.");
		int Value = data[0];
		swap(data, 0, size - 1);
		data[size - 1] = 0;
		size--;
		heapifyDown();
		return Value;
	}

	private void heapifyDown() {
		if (size == 0)
			return;

		int current = 0;

		while (true) {
			int left = 2 * current + 1;
			int right = 2 * current + 2;
			int comparing = 0;

			if (left <= size - 1 && right <= size - 1) {
				comparing = data[left] <= data[right] ? left : right;
			} else if (left <= size - 1)
				comparing = left;
			else
				break;

			if (data[current] > data[comparing])
				swap(data, current, comparing);

			current = comparing;
		}
	}

	public int[] extractAll() {
		if (size == 0)
			throw new RuntimeException("Nothing to output.");
		int[] output = new int[size];
		int i = 0;
		while (size != 0) {
			output[i] = extract();
			i++;
		}
		return output;
	}

	public static void main(String args[]) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("[");
		try {
			int arraySize = Integer.parseInt(br.readLine());
			int[] arr = new int[arraySize];
			for (int i = 0; i <= arraySize - 1; i++)
				arr[i] = Integer.parseInt(br.readLine());
			int[] sortedArr = MinHeap.of(arr).extractAll();
			String output = Arrays.stream(sortedArr).boxed().map(String::valueOf).collect(Collectors.joining(","));
			System.out.println("[" + output + "]");

		} catch (Exception e) {
			System.err.println(e);
		}

	}

}

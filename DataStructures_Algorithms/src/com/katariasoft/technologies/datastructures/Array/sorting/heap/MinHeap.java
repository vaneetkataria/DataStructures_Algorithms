package com.katariasoft.technologies.datastructures.Array.sorting.heap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

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
		if (size == 0) {
			data[0] = i;
			size++;
			return;
		}

		data[size] = i;
		size++;
		heapifyUp(i);
	}

	private void heapifyUp(int i) {
		int currentIndex = size - 1;
		while (currentIndex > 0) {
			int parentIndex = (currentIndex - 1) / 2;
			if (data[parentIndex] > data[currentIndex]) {
				swap(data, parentIndex, currentIndex);
				currentIndex = parentIndex;
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
		data[0] = 0;
		swap(data, 0, size - 1);
		size--;
		if (size == 0)
			return Value;
		heapifyDown();
		return Value;
	}

	private void heapifyDown() {
		int currentIndex = 0;
		while (true) {
			int leftChildIndex = 2 * currentIndex + 1;
			int rightChildIndex = 2 * currentIndex + 2;
			int comparisonIndex = 0;

			if (leftChildIndex <= size - 1 && rightChildIndex <= size - 1) {
				comparisonIndex = data[leftChildIndex] <= data[rightChildIndex] ? leftChildIndex : rightChildIndex;
			} else if (leftChildIndex <= size - 1)
				comparisonIndex = leftChildIndex;
			else
				break;

			if (data[currentIndex] > data[comparisonIndex])
				swap(data, currentIndex, comparisonIndex);

			currentIndex = comparisonIndex;
		}
	}

	public int[] extractAll() {
		if (size == 0)
			throw new RuntimeException("Nothing to output.");
		int[] outputData = new int[size];
		int i = 0;
		while (size != 0) {
			outputData[i] = extract();
			i++;
		}
		return outputData;
	}

	public static void main(String args[]) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("[");
		try {
			int arraySize = Integer.parseInt(br.readLine());
			int[] arr = new int[arraySize];
			String[] strArray = br.readLine().split(" ");
			for (int i = 0; i <= strArray.length - 1; i++)
				arr[i] = Integer.parseInt(strArray[i]);
			int[] sortedArr = MinHeap.of(arr).extractAll();
			String output = Arrays.stream(sortedArr).boxed().map(String::valueOf).collect(Collectors.joining(","));
			System.out.println("[" + output + "]");

		} catch (Exception e) {
			System.err.println(e);
		}

	}

}

package com.katariasoft.technologies.datastructures.Array.sorting.heap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;

class GFG {

	private static abstract class Heap {

		protected Heap(int[] arr) {
			if (Objects.isNull(arr) || arr.length == 0)
				throw new IllegalArgumentException("Input Array should be of size greater than zero.");
			init(arr);
		}

		private int size = 0;
		private int[] data;

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
				int parent = getParent(current);
				if (shouldSwap(data, parent, current)) {
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
				int left = getLeft(current);
				int right = getRight(current);
				int comparing = 0;

				if (hasLeft(current) && hasRight(current)) {
					comparing = data[left] <= data[right] ? left : right;
				} else if (hasLeft(current))
					comparing = left;
				else
					break;

				if (shouldSwap(data, current, comparing))
					swap(data, current, comparing);

				current = comparing;
			}
		}

		private int getParent(int child) {
			return (child - 1) / 2;
		}

		private int getLeft(int parent) {
			return 2 * parent + 1;
		}

		private int getRight(int parent) {
			return 2 * parent + 2;
		}

		private boolean hasLeft(int parent) {
			return getLeft(parent) <= size - 1;
		}

		private boolean hasRight(int parent) {
			return getRight(parent) <= size - 1;
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

		public abstract boolean shouldSwap(int[] arr, int parent, int child);

	}

	private static class MinHeap extends Heap {

		public static MinHeap of(int... arr) {
			return new MinHeap(arr);
		}

		protected MinHeap(int[] arr) {
			super(arr);
		}

		@Override
		public boolean shouldSwap(int[] arr, int parent, int child) {
			return arr[parent] > arr[child];
		}

	}

	private static class KthSmallestElementFinder extends MinHeap {

		private int k = 0;

		public static KthSmallestElementFinder of(int k, int... arr) {
			return new KthSmallestElementFinder(k, arr);
		}

		public KthSmallestElementFinder(int k, int... arr) {
			super(arr);
			this.k = k;
		}

		public int find() {
			int kthLargest = 0;
			while (k > 0) {
				kthLargest = extract();
				k--;
			}
			return kthLargest;
		}
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
				int k = Integer.parseInt(br.readLine());
				System.out.println(KthSmallestElementFinder.of(k, arr).find());
				numTestCases--;
			}
			System.out.println(sb.toString());
		} catch (Exception e) {
		}

	}

}

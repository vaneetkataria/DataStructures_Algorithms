package com.katariasoft.technologies.datastructures.Array.sorting.heap;

import java.util.Objects;

class Solution {

	private abstract class Heap {

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
					comparing = chooseSwappable(data, left, right);
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

		public abstract int chooseSwappable(int[] arr, int left, int right);

	}

	private class MaxHeap extends Heap {

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

	}

	private class KthLargestElementFinder extends MaxHeap {

		private int k = 0;

		public KthLargestElementFinder(int k, int... arr) {
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

	public int findKthLargest(int[] nums, int k) {
		return new KthLargestElementFinder(k, nums).find();
	}
}
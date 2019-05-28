package com.katariasoft.technologies.datastructures.Array.matrix;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MatrixSpiralTraverser {

	public static int[] traverse(int[][] matrix, int numRows, int numColumns) {

		int firstRow = 0;
		int lastRow = numRows - 1;
		int firstColumn = 0;
		int lastColumn = numColumns - 1;
		int[] traversed = new int[numRows * numColumns];
		int cursor = 0;

		while (true) {

			if (firstColumn > lastColumn || firstRow > lastRow)
				break;

			for (int i = firstColumn; i <= lastColumn; i++) {
				traversed[cursor] = matrix[firstRow][i];
				cursor++;
			}
			firstRow++;

			if (firstRow > lastRow)
				break;

			for (int i = firstRow; i <= lastRow; i++) {
				traversed[cursor] = matrix[i][lastColumn];
				cursor++;
			}
			lastColumn--;

			if (lastColumn < firstColumn)
				break;

			for (int i = lastColumn; i >= firstColumn; i--) {
				traversed[cursor] = matrix[lastRow][i];
				cursor++;
			}
			lastRow--;

			if (lastRow < firstRow)
				break;

			for (int i = lastRow; i >= firstRow; i--) {
				traversed[cursor] = matrix[i][firstColumn];
				cursor++;
			}
			firstColumn++;

			if (firstColumn > lastColumn)
				break;

		}

		return traversed;

	}

	public static void main(String args[]) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("");
		try {
			int numTestCases = Integer.parseInt(br.readLine());
			while (numTestCases > 0) {
				String[] arraySize = br.readLine().split(" ");
				int numRows = Integer.parseInt(arraySize[0]);
				int numColumns = Integer.parseInt(arraySize[1]);
				int[][] matrix = new int[numRows][numColumns];
				String[] strArray = br.readLine().split(" ");

				int current = 0;
				for (int i = 0; i <= numRows - 1; i++) {
					for (int j = 0; j <= numColumns - 1; j++) {
						matrix[i][j] = Integer.parseInt(strArray[current]);
						current++;
					}
				}
				int[] traversed = traverse(matrix, numRows, numColumns);
				for (int i = 0; i <= traversed.length - 1; i++)
					sb.append(traversed[i] + " ");
				sb.append("\n");
				numTestCases--;
			}
			System.out.println(sb.toString());
		} catch (Exception e) {
		}

	}

}

package dsa;

import java.util.stream.IntStream;

public class MergeSort {

	public static void main(String[] args) {

		int input[] = { 5, 1, 4, 3 };
		IntStream.of(input).forEach(System.out::print);
		mergeSort(input);
		System.out.println();
		IntStream.of(input).forEach(System.out::print);

	}

	private static void mergeSort(int[] input) {
		if (input == null || input.length == 1) {
			return;
		}
		int fin = 0;
		int lin = input.length - 1;
		int mid = fin + (lin - fin) / 2;
		int[] left = new int[mid + 1];
		int[] right = new int[(lin - mid)];
		System.arraycopy(input, fin, left, 0, left.length);
		System.arraycopy(input, mid + 1, right, 0, right.length);
		mergeSort(left);
		mergeSort(right);
		merge(input, left, right);
	}

	private static void merge(int[] input, int[] left, int[] right) {
		int i = 0;
		int j = 0;
		int k = 0;

		while (i < left.length && j < right.length) {
			if (left[i] <= right[j]) {
				input[k] = left[i];
				i++;
			} else {
				input[k] = right[j];
				j++;
			}
			k++;
		}

		while (i < left.length) {
			input[k] = left[i];
			i++;
			k++;
		}

		while (j < right.length) {
			input[j] = right[j];
			j++;
			k++;
		}

	}

}

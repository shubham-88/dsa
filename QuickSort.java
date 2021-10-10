package programs;

import java.util.stream.IntStream;

public class QuickSort {

	public static void main(String[] args) {
		int[] input = { 4, 1, 2, 3, 5, 0, 2 };
		int fin = 0;
		int lin = input.length - 1;
		IntStream.of(input).forEach(System.out::print);
		quickSort(input, fin, lin);
		System.out.println();
		IntStream.of(input).forEach(System.out::print);
	}

	private static void quickSort(int[] input, int fin, int lin) {
		if (fin < lin) {
			int partIndex = partIndex(input, fin, lin);
			quickSort(input, fin, partIndex - 1);
			quickSort(input, partIndex + 1, lin);
		}
	}

	private static int partIndex(int[] input, int fin, int lin) {
		int pivot = lin;
		int i = fin - 1;
		for (int j = fin; j < lin; j++) {
			if (input[j] <= input[pivot]) {
				i++;
				swap(input, i, j);
			}
		}
		swap(input, i + 1, pivot);
		return i + 1;
	}

	private static void swap(int[] input, int i, int j) {
		int temp = input[i];
		input[i] = input[j];
		input[j] = temp;

	}

}

package dsa;

import java.util.Arrays;

public class PrintDigElementOfMatrix {

	public static void main(String[] args) {
		int[][] mtrics = { { 1, 2, 3, 4 }, { 5,6,7,8 }, { 1, 2, 3, 4 }, { 5,6,7,8 } };
		new PrintDigElementOfMatrix().printDig(mtrics);

	}

	private void printDig(int[][] mtrics) {
		int lenght = mtrics.length;
		int[] resD1 = new int[lenght];
		int[] resD2 = new int[lenght];

		for (int i = 0; i < lenght; i++) {
			resD1[i] = mtrics[i][lenght - i - 1];
			resD2[i] = mtrics[i][i];
		}

		 Arrays.stream(resD1).forEach(System.out::print);
		 System.out.println();
		 Arrays.stream(resD2).forEach(System.out::print);

	}

}

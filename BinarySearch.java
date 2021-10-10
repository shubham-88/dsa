package dsa;

public class BinarySearch {

	public static void main(String[] args) {
		int[] input = { 1, 2, 3, 4, 5 };

		int index = binarySearch(input, 4, 0, input.length - 1);
		System.out.println(index);
	}

	private static int binarySearch(int[] data, int x, int fin, int lin) {
		if (fin <= lin) {
			int mid = fin + (lin - fin) / 2;
			if (data[mid] == x) {
				return mid;
			}
			if (data[mid] > x) {
				return binarySearch(data, x, fin, mid - 1);
			} else {
				return binarySearch(data, x, mid + 1, lin);
			}
		}
		return -1;
	}

}

package dsa;

public class BinarySearch {

	public static void main(String[] args) {
		int[] input = { 1, 2, 3, 4, 5 };
		int[] input2 = { 1,3,5,6};

		int index = binarySearch(input2, 2, 0, input2.length - 1);
		System.out.println(index);
		System.out.println(binarySearch(input2, 2));

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
		return fin;
	}

	private static int binarySearch(int[] nums, int target) {
		int fin = 0;
		int lin = nums.length - 1;
		while (fin <= lin) {
			int mid = fin + (lin - fin) / 2;

			if (nums[mid] == target) {
				return mid;
			}

			if (nums[mid] > target) {
				lin = mid - 1;
			} else {
				fin = mid + 1;
			}

		}
		return lin+1;
	}

}

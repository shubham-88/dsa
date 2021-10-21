package dsa;

public class Jump {

	public static void main(String[] args) {

		int arr[] = { 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 };

		// count minum jump to reach the end of the array
		int res = minJump(arr, 0, arr.length - 1);
		System.out.println(res);

	}

	static int minJump(int[] arr, int fin, int lin) {
		if (fin == lin) {
			return 0;
		}
		if (arr[fin] == 0) {
			return Integer.MAX_VALUE;
		}
		Integer min = Integer.MAX_VALUE;

		for (int i = fin + 1; i <= lin && i <= fin + arr[fin]; i++) {
			int jump = minJump(arr, i, lin);
			if (jump != Integer.MAX_VALUE && jump + 1 < min) {
				min = jump + 1;
			}
		}
		return min;
	}

}

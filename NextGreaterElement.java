package dsa;

import java.util.Stack;

public class NextGreaterElement {

	public static void main(String[] args) {

		int input[] = { 10, 8, 12, 17, 9, 7 };

		printNextGreater(input);

	}

	private static void printNextGreater(int[] input) {

		Stack<Integer> s = new Stack<Integer>();
		for (int i = 0; i < input.length; i++) {
			while (!s.isEmpty() && s.peek() < input[i]) {
				System.out.println(s.pop() + " ->" + input[i]);

			}
			s.push(input[i]);
		}

		while (!s.isEmpty()) {
			System.out.println(s.pop() + " -> -1");
		}

	}

}

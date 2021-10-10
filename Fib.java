package programs;

public class Fib {

	public static void main(String[] args) {

		int n = 5;

		int init = 0;
		int first = 0;
		int second = 1;
		System.out.print(first + second);
		while (init <= n) {
			int _new = first + second;

			System.out.print(_new);

			first = second;
			second = _new;

			init++;
		}

	}

}

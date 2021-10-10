package programs;

public class PrintExcelIndex {

	public static void main(String[] args) {

		new PrintExcelIndex().printColumnNum(100000);
	}

	public void printColumnNum(int num) {
		StringBuilder sb = new StringBuilder();
		if (num <= 0) {
			System.err.println("Invalid index.");
		} else {
			while (num / 26 > 0) {
				sb.append(Alphabet.getByIndex(num % 26));
				num = num / 26;
			}
			sb.append(Alphabet.getByIndex(num));
		}
		System.out.println(sb.reverse());

	}

}

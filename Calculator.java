package dsa;

import java.util.Stack;

public class Calculator {

	public static void main(String arr[]) {
		System.out.println(new Calculator().calculate("2*3+4"));
	}

	public int calculate(String st) {
		Calculator s = new Calculator();
		String oprString = st.trim();
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		char lastopr = '+';
		for (int i = 0; i < oprString.length(); i++) {
			char c = oprString.charAt(i);
			if (s.isOpr(c)) {
				int thisNumber = Integer.parseInt(sb.toString().trim());
				if (stack.size() > 0 && (lastopr == '*' || lastopr == '/')) {
					int result = s.calculate(thisNumber, lastopr, stack.pop());
					stack.push(result);
				} else if (lastopr == '-') {
					stack.push(-thisNumber);
				} else {
					stack.push(thisNumber);
				}
				lastopr = c;
				sb.setLength(0);
			} else {
				sb.append(c);
			}

		}

		if (stack.size() > 0) {
			int thisNumber = Integer.parseInt(sb.toString().trim());
			if ((lastopr == '*' || lastopr == '/')) {
				int result = s.calculate(thisNumber, lastopr, stack.pop());
				stack.push(result);
			} else if (lastopr == '-') {
				stack.push(-thisNumber);
			} else {
				stack.push(thisNumber);
			}
			int final_res = 0;
			while (!stack.isEmpty()) {
				final_res += stack.pop();
			}
			return final_res;
		} else {
			return Integer.parseInt(st.toString().trim());
		}

	}

	public boolean isOpr(char c) {
		if (c == '+' || c == '-' || c == '*' || c == '/') {
			return true;
		}
		return false;
	}

	public int calculate(int curr, char c, int last) {
		if (c == '*') {
			return curr * last;
		} else {
			return last / curr;
		}

	}
	
	
	//Find last bad version
	public int firstBadVersion(int n) {
        int fin = 1;
        int lin = n;
        
        while(fin<lin){
            int mid  = fin + (lin-fin)/2;
            if(isBadVersion(mid)){
                lin = mid;
            }else{
                fin = mid+1;
            }
        }
        return fin;
        
    }

	private boolean isBadVersion(int mid) {
		return false;
	}

}

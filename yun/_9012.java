
import java.util.Scanner;
import java.util.Stack;

/*
 * BOJ 9012 - 괄호  
 * 올바른 괄호인지 확인 
 */

public class _9012 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());

		for (int i = 0; i < n; i++) {
			if(isValid(sc.nextLine())) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
	
	static boolean isValid(String s) {
		
		Stack<Character> stack = new Stack<>();
		
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			
			switch(c) {
			case '(':
				stack.push(c);
				break;
			case ')':
				if(stack.isEmpty()) return false;
				if(stack.pop() != '(') return false;
				break;
			}
		}
		
		if(stack.isEmpty()) {
			return true;
		}
		return false;
	}

}

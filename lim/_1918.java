import java.io.FileInputStream;
import java.util.Scanner;
import java.util.Stack;

public class Boj1918 {
// 후위 표기식
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		char[] crr = s.toCharArray();
		Stack<Character> stk = new Stack<>();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < crr.length; i++) {
			if('A' <= crr[i]) {
				sb.append(crr[i]);
				continue;
			}
			switch (crr[i]) {
			case '(':
				stk.push('(');
				break;
			case ')':
				while(!stk.empty() && stk.peek() != '(') {
					sb.append(stk.pop());
				}
				stk.pop(); // '(' 빼주기
				break;
			case '*':
			case '/':
				while(!stk.empty() && stk.peek() != '(' && (stk.peek() == '*' || stk.peek() == '/')) {
					sb.append(stk.pop());
				}
				stk.push(crr[i]);
				break;
			case '+':
			case '-':
				while(!stk.empty() && stk.peek() != '(' ) {
					sb.append(stk.pop());
				}
				stk.push(crr[i]);
				break;
			}
		}
		while(!stk.empty()) {
			sb.append(stk.pop());
		}
		System.out.println(sb);
	}
}

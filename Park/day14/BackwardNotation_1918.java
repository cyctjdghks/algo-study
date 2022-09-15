import java.util.Scanner;
import java.util.Stack;

public class BackwardNotation_1918 {

	public static void main(String[] args) {
		// 후위 표기법 - 연산자가 피연산자 뒤에 위치하는 방법
		// a+b*c => abc*+
		// 순서
		// 중위 표기식을 연산자의 우선순위에 따라 괄호로 묶어준다.
		// 괄호 안의 연산자를 괄호의 오른쪽으로 옮겨주면 된다.
		// 연산자는 스텍에 저장, 피연산자는 바로 출력
		// ) 일 경우 (가 나올때까지 스텍에 쌓인 연산자를 출력
		// ( 일 경우 무조건 스텍에 집어넣는다
		// ( 를 제외한 연산자를 스텍에 집어넣을때
		// 맨 위에 있는 연산자보다 우선순위가 높을 경우에는 스텍에 바로 집어넣고
		// 아닐 경우 우선순위가 더 높은 연산자를 먼저 출력한다

		String s;
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		char str;
		int p;

		Scanner sc = new Scanner(System.in);
		s = sc.next();

		for (int i = 0; i < s.length(); i++) {
			str = s.charAt(i);
			p = priority(str);

			switch (str) {
			case '+':
			case '-':
			case '*':
			case '/':
				while(!stack.isEmpty() && priority(stack.peek())>=p) {
					sb.append(stack.pop());
				}
				stack.push(str);
				break;
			case '(':
				stack.push(str);
				break;
			case ')':
				while(!stack.isEmpty() && stack.peek() != '(') {
					sb.append(stack.pop());
				}
				stack.pop();
				break;
			default:
				sb.append(str);
				break;
			}
		}
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		System.out.println(sb);

	}

	public static int priority(char c) {
		switch (c) {
		case '*':
		case '/':
			return 2;
		case '+':
		case '-':
			return 1;
		default:
			return 0;
		}
	}
}
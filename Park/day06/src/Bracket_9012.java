import java.util.Scanner;
import java.util.Stack;

public class Bracket_9012 {

	public static void main(String[] args) {
		int T;
		String input;
		Stack<String> stack = new Stack<>();
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		
		loop :
		for(int tc = 0; tc < T; tc++) {
			input = sc.next();
			
			stack.clear();
			
			for(int i = 0; i < input.length();i++) {
				if(input.charAt(i) == '(') {
					stack.add(String.valueOf(input.charAt(i)));
				} else {
					if(stack.size() != 0) {
						stack.pop();
					} else {
						System.out.println("NO");
						continue loop;
					}
				}
			}
			
			if(stack.size() == 0) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
			
		}
	}

}

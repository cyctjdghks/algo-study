import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Stack_10828 {

	public static void main(String[] args) {
		// split() 메소드와 바로 print 하게되면 시간초과
		// => StringBuilder 와 StringTokenizer 사용
		int N;
		Stack<String> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		sc.nextLine();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(sc.nextLine());
			String S = st.nextToken();
			switch (S) {
			case "push":
//				System.out.println("push");
				stack.push(st.nextToken());
				break;
			case "pop":
//				System.out.println("pop");
				if(stack.isEmpty()) {
					sb.append("-1").append("\n");
				} else {
					sb.append(stack.pop()).append("\n");
				}
				break;
			case "size":
//				System.out.println("size");
				sb.append(stack.size()).append("\n");
				break;
			case "empty":
//				System.out.println("empty");
				if(stack.isEmpty()) {
					sb.append("1").append("\n");
				} else {
					sb.append("0").append("\n");
				}
				break;
			case "top":
//				System.out.println("top");
				if(stack.isEmpty()) {
					sb.append("-1").append("\n");
				} else {
					sb.append(stack.peek()).append("\n");
				}
				break;
			default:
				break;
			}
		}
		
		System.out.println(sb);
	}

}

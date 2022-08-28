import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj10828 {
// 스택
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stk = new Stack<>();
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			switch(st.nextToken()) {
			case "push":
				stk.push(Integer.parseInt(st.nextToken()));
				break;
			case "pop":
				if(stk.isEmpty()) sb.append("-1\n");
				else sb.append(stk.pop()+"\n");
				break;
			case "size":
				sb.append(stk.size()+"\n");
				break;
			case "empty":
				if(stk.isEmpty()) sb.append("1\n");
				else sb.append("0\n");
				break;
			case "top":
				if(stk.isEmpty()) sb.append("-1\n");
				else sb.append(stk.peek()+"\n");
				break;
			}
		}
		System.out.println(sb);
	}

}

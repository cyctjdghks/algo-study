import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < tc; t++) {
			String[] inp = br.readLine().split("");
			int size = inp.length;
			Stack<String> stk = new Stack<>();
			boolean good = true;
			for(int i = 0; i < size; i++) {
				if(inp[i].equals("(")){
					stk.push(inp[i]);
				} else {
					if(stk.empty() || stk.pop().equals(")")) {
						good = false;
						break;
					}
				}
			}
			if(good) {
				if(!stk.empty()) {
					System.out.println("NO");
				} else {
					System.out.println("YES");
				}
			} else {
				System.out.println("NO");
			}

		}
	}

}

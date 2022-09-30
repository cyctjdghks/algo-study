import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2263 {
// 트리의 순회
	static int n;
	static int[] pre;
	static int[] in;
	static int[] post;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		in = new int[n];
		post = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) in[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) post[i] = Integer.parseInt(st.nextToken());
		
		preOrder(0, n-1, 0, n-1);
		System.out.println(sb);
	}
	static void preOrder(int inS, int inE, int postS, int postE) {
		if(inE < inS || postE < postS) return;
		sb.append(post[postE] + " ");		
		
		int pos = inS;
		for(int i = inS; i <= inE ; i++) {
			if(in[i] == post[postE]) {
				pos = i;
				break;
			}
		}
		
		preOrder(inS, pos-1, postS, postS + pos - inS - 1);
		preOrder(pos+1, inE, postS + pos - inS, postE - 1);

	}
}

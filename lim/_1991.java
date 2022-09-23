import java.io.FileInputStream;
import java.util.Scanner;

public class _1991 {
// 트리 순회
	
	static char[][] tree;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		tree = new char[n][2];
		for(int i = 0; i < n; i++) {
			char[] tmp = sc.nextLine().toCharArray();
			tree[tmp[0]-'A'][0] = tmp[2];
			tree[tmp[0]-'A'][1] = tmp[4];
		}
		pre(0);
		System.out.println();
		in(0);
		System.out.println();
		post(0);
	}

	static void pre(int num) {
		System.out.print((char)(num + 'A'));
		if(tree[num][0] != '.') {
			pre(tree[num][0] - 'A');
		}
		if(tree[num][1] != '.') {
			pre(tree[num][1] - 'A');
		}
	}
	static void in(int num) {
		if(tree[num][0] != '.') {
			in(tree[num][0] - 'A');
		}
		System.out.print((char)(num + 'A'));
		if(tree[num][1] != '.') {
			in(tree[num][1] - 'A');
		}
	}
	static void post(int num) {
		if(tree[num][0] != '.') {
			post(tree[num][0] - 'A');
		}
		if(tree[num][1] != '.') {
			post(tree[num][1] - 'A');
		}
		System.out.print((char)(num + 'A'));
	}
}

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_9019_DSLR {

	static String A, B;
	static StringBuilder sb;

	public static void main(String[] args) {
		// D : n을 두배로, % 10000
		// S : n-1, n == 0 => 9999
		// L : d1 d2 d3 d4 => d2 d3 d4 d1
		// R : d1 d2 d3 d4 => d4 d1 d2 d3

		int T;

		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			A = sc.next();
			B = sc.next();
			sb = new StringBuilder();

//			System.out.println(A);
//			System.out.println(B);

			bfs();

			System.out.println(sb);
		}
	}

	private static void bfs() {
		Queue<Data> q = new LinkedList<Data>();
		String str = "";
		int n = 0;

		q.offer(new Data("", A));

		loop :
		while (!q.isEmpty()) {
			Data data = q.poll();

			for (int i = 0; i < 4; i++) {
				str = data.dslr;
				n = Integer.parseInt(data.res);
				
				switch (i) {
				case 0: // D
					n = n*2 % 10000;
					str += "D";
					break;
				case 1: // S
					if(n == 0) n = 9999;
					else n -= 1;
					str += "S";
					break;
				case 2: // L
					n = (n % 1000) * 10 + n/1000;
					str += "L";
					break;
				case 3: // R
					n = (n % 10) * 1000 + n/10;
					str += "R";
					break;
				default:
					break;
				}
				
				if(Integer.toString(n).equals(B)) {
					sb.append(str);
					break loop;
				}
//				System.out.println(str);
				q.offer(new Data(str, Integer.toString(n)));
			}
			
		}
	}

	static class Data {
		String dslr; // 연산값 - 출력
		String res; // 결과값 - B랑 비교

		public Data(String dslr, String res) {
			this.dslr = dslr;
			this.res = res;
		}
	}

}

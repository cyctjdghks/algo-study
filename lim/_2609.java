package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 최대공약수와 최소공배수
public class _2609 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int temp = n;
		int min = 1;
		int temp2 = n * m;
		while(true) {
			if(n%temp == 0 && m%temp == 0) {
				min *= temp;
				n /= temp;
				m /= temp;
				temp = n;
			} else {
				temp--;
			}
			if(temp == 1) {
				break;
			}
		}
		System.out.println(min);
		System.out.println(temp2/min);
	}
}

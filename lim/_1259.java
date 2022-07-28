package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
// 팰린드롬수
public class _1259 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean palin = true;
		while(true) {
			String s = br.readLine();
			if(Integer.parseInt(s) == 0) { // 0 입력시 종료
				break;
			}
			for(int i=0; i<(s.length()+1)/2; i++) { // 문자열의 길이 절반 만큼 반복문 수행
				if(s.charAt(i) != s.charAt(s.length()-i-1)) { // 문자열의 왼쪽 끝과 오른쪽 끝을 한칸 씩 전진시키면서 같은지 검사
					palin = false;
				}
			}
			if(palin) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
			palin = true;
		}
	}
}

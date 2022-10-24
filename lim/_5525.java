import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class _5525 {
	// IOIOI
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		String s = br.readLine();
		// 입력
		n = 2*n+1; // IOIOI... 의 실제 길이
		int res = 0; // 결과값
		int cnt = 0; // 지금까지 일치한 문자열의 길이
		boolean turnI = true; // 지금이 I의 차례인지

		for(int i = 0; i < m; i++) {
			int tmp = cnt; // tmp변수에 현재까지 일치한 문자열의 길이를 임시 저장
			if(s.charAt(i) == 'I') { // I의 경우
				if(turnI) { // I가 올 차례가 마따
					cnt++; // 현재까지 일치한 문자열의 길이를 1 늘려줌
				} else { // I 차례가 아니ㅁ
					cnt = 1; // 잘못 들어섰으니 일치한 길이 1로 리셋
				}
				turnI = false; // 다음은 O의 차례이니까 뒤집어줌
			} else if(s.charAt(i) == 'O') { // O의 경우
				if(!turnI) { // O의 차례가 맞다
					cnt++; // 현재까지 일치한 문자열의 길이를 1 늘려줌
				} else { // O 차례가 아님
					cnt = 0; // 잘못 들어섰으니 일치한 길이 0으로 리셋
				}
				turnI = true; // 다음은 I의 차례니까 뒤집어줌
			} 
			if(tmp != cnt && cnt == n) { 
				// 아까 저장해둔 TMP를 보니 길이 변화가 생겼고
				// 현재까지 일치한 문자열의 길이도 요구한 n이랑 같다
				cnt -= 2; // 다음 문자열을 검사해야하므로 2 깎아줌
				res++; // 결과값 + 1
			}
		}
		System.out.println(res);
	}

}

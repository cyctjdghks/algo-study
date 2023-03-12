package algorithm.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_9935 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		String P = br.readLine();
		Stack<Character> stack = new Stack<Character>();
		int pSize = P.length();
		for(int i=0; i<S.length(); i++) {
			stack.push(S.charAt(i));
			if(stack.size() >= pSize) {
				// 스택 안에 든것 갯수가 폭발 문자열의 크기 이상이면 탐색
				boolean isSame = true;
				for(int j=0; j<pSize; j++) {
					// 폭발 문자열의 맨 뒤랑, 스택의 맨 뒤부터 비교
					if(stack.get(stack.size()-j-1) != P.charAt(pSize-j-1)) {
						isSame = false;
						break;
					}
				}
				if(isSame) {
					// 폭발 문자열 있으면 폭발 문자열 크기만큼 pop 반복
					int cnt = pSize;
					while(cnt>0) {
						stack.pop();
						cnt--;
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(Character c : stack) {
			sb.append(c);
		}
		System.out.println(sb.length()==0 ? "FRULA" : sb.toString());
	}
}

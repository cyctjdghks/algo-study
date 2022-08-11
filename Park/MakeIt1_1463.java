import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MakeIt1_1463 {

	static int min;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 정수 X에 사용할 수 있는 연산 3가지
		// X가 3으로 나누어 떨어지면, 3으로 나눈다.
		// X가 2로 나누어 떨어지면, 2로 나눈다.
		// 1을 뺀다
		// 3가지 연산을 사용해 1을 만든다.
		// 모든 경우의 수를 다 탐색?? => 시간초과 예상
		// 10의 경우
		
		int X;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		X = Integer.parseInt(br.readLine());
		min = X; // 전부 -1로 1을 만들 경우 X-1번
		
		makeit(X, 0);
		
		System.out.println(min);
	}

	public static void makeit(int X, int count) {
		// 재귀 함수를 사용한 모든 경우의 수 탐색 => 시간초과
		// 조건 붙이니 통과
		
		if(X == 1) {
			min = Math.min(count, min);
			return;
		}
		
		if(count >= min) { // 이미 구해진 최소값보다 커지면 해당 루트는 더이상 작업할 필요 X 
			return;
		}
		
		if(X % 3 == 0) {
			makeit(X/3, count+1);
		}
		
		if(X % 2 == 0) {
			makeit(X/2, count+1);
		}
		
		makeit(X-1, count+1);
		
	}
}

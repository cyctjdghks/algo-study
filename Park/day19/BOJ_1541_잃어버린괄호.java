import java.util.Scanner;

// BOJ 1521. 잃어버린 괄호
public class BOJ_1541_잃어버린괄호 {

	public static void main(String[] args) {
		// +, -, 괄호만으로 식 구성
		// 최소로 만드는 프로그램
		// => - 를 기준으로 오른쪽에 최대한 큰 값
		// 덧셈부터 계산 후 뺄셈 계산
		// 뺄셈 왼쪽 부분에 덧셈만 있다면 먼저하든 나중에하든 결과는 같음
		// ex, 10 + 20 + 30 + 20 + 10 - 30
		// => 왼쪽 다 더한 후 뺄셈 : 90 - 30 = 60
		// => 뺄셈 부터 계산 후 덧셈  10 + 20 + 30 + 20 - 20 = 60
		
		Scanner sc = new Scanner(System.in);
		 
		int sum = Integer.MAX_VALUE;	// 초기 상태 여부 확인을 위한 값으로 설정 
		String[] subtraction = sc.nextLine().split("-");
		
 
		for(int i = 0; i < subtraction.length; i++) {
			int temp = 0;
 
			// 뺄셈으로 나뉜 토큰을 덧셈으로 분리하여 해당 토큰들을 더한다.
			String[] addition = subtraction[i].split("\\+");
			
			// 덧셈으로 나뉜 토큰들을 모두 더한다. 
			for(int j = 0; j < addition.length; j++) {
				temp += Integer.parseInt(addition[j]);
			}
			
			// 첫 번째토큰인 경우 temp값이 첫 번째 수가 됨
			if (sum == Integer.MAX_VALUE) {
				sum = temp;
			} else {
				sum -= temp;
			}
		}
		System.out.println(sum);
	}

}

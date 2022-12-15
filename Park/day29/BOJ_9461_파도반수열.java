import java.util.Arrays;
import java.util.Scanner;

public class BOJ_9461_파도반수열 {

	public static void main(String[] args) {
		// 1 1 1 2 2 3 4 5 7 9 12 16 21 28 37 49
		// ^ v ^ v ^ v ^ v ^ v ^  v  ^  v  ^  v
		// i = (i-1) + (i-5)
		// int형이 아닌 Long 형
		
		int T;
		
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			
			Long[] arr = new Long[N+1];
			arr[1] = 1L;
			for(int i = 2; i <= N; i++) {
				if(i == 2 || i == 3) {
					arr[i] = 1L;
					continue;
				}
				if(i == 4 || i == 5) {
					arr[i] = 2L;
					continue;
				}
				arr[i] = arr[i-1] + arr[i-5];
			}
			
//			System.out.println(Arrays.toString(arr));
			System.out.println(arr[N]);
		}
	}

}

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class SortCoordinates_11650 {

	public static void main(String[] args) {
		// N 개의 줄
		// x 부터 정렬 후 y 정렬
		// Arrays.sort 재정의 연습문제
		
		int N;
		int[][] arr;
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		arr = new int[N][2];
		
		for(int i = 0; i < N; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		
		Arrays.sort(arr, new Comparator<int[]>() {		
			@Override
			public int compare(int[] e1, int[] e2) {
				if(e1[0] == e2[0]) {		// 첫번째 원소가 같다면 두 번째 원소끼리 비교
					return e1[1] - e2[1];
				}
				else {
					return e1[0] - e2[0];
				}
			}
		});
		
//		Arrays.sort(arr, (e1, e2) -> {
//			if(e1[0] == e2[0]) {
//				return e1[1] - e2[1];
//			} else {
//				return e1[0] - e2[0];
//			}
//		});
		
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < 2; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

}

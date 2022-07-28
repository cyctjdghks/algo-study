
import java.util.Scanner;

public class PrimeNumber {
/*

4
1 3 5 7

*/
	public static void main(String[] args) {
		// 주어진 N개의 수 중에서 소수의 갯수 구하기
		
		Scanner sc = new Scanner(System.in);
		int N = 0;
		int[] arr;
		int leng = 0;
		int count = 0;
		
		N = sc.nextInt();
		
		arr = new int[N];
		leng = arr.length;
		
		for(int i = 0; i < leng; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i = 0; i < leng; i++) {
			if(arr[i] == 1) {
				continue;
			}
			if(arr[i] == 2) {
				count++;
				continue;
			}
			for(int j = 2; j < arr[i]; j++) {
				if(arr[i] % j == 0) {
					break;
				}
				if((arr[i]-1) == j && arr[i] % j != 0) {
					count++;
				}
			}
		}
		System.out.println(count);
		
		sc.close();
	}

}

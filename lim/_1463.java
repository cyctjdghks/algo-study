import java.io.FileInputStream;
import java.util.Scanner;

public class Main{

	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] arr = new int[4*n];
		for(int i = 0; i < 4*n; i++	) {
			arr[i] = Integer.MAX_VALUE;
		}
		arr[1] = 0;
		for(int i = 1; i <= n+1; i++) {
			if(i == n) {
				System.out.println(arr[i]);
				break;
			}
			if(arr[i] + 1 < arr[i+1]) {
				arr[i+1] = arr[i]+1;
			}
			if(arr[i] + 1 < arr[i*2]) {
				arr[i*2] = arr[i]+1;
			}
			if(arr[i] + 1 < arr[i*3]) {
				arr[i*3] = arr[i]+1;
			}
		}
	}

}

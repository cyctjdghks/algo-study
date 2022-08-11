import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class SortByAge_10814 {

	public static void main(String[] args) {
		// 회원 수 N
		// 나이와 이름
		
		int N;
		String age;
		String name;
		String[][] member;
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		member = new String[N][2];
		
		for(int i = 0; i < N; i++) {
			age = sc.next();
			name = sc.next();
			
			member[i][0] = age;
			member[i][1] = name;
		}
		
		Arrays.sort(member, new Comparator<String[]>() {
			@Override
			public int compare(String[]o1, String[]o2) {
				return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
			}
		});
		
		for(int i = 0; i < N; i++) {
			System.out.println(member[i][0] + " " + member[i][1]);
		}
	}

	
}

import java.util.HashMap;
import java.util.Scanner;

public class BOJ_9375_패션왕신해빈 {
	
	static int n;
	static int res;
	static HashMap<String, Integer> map;
	
	public static void main(String[] args) {
		// value - key input
		// 순서가 상관 없는 조합 
		
		int T;
		
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			n = sc.nextInt();
			res = 1;
			map = new HashMap<>();
			
			for(int i = 0; i < n; i++) {
				sc.next();
				
				String clothes = sc.next();
				
				if(map.containsKey(clothes)) {
					map.put(clothes, map.get(clothes) + 1);
				} else {
					map.put(clothes, 1);
				}
			}
			
			for (int val : map.values()) {
				res *= (val + 1);
			}
			
			System.out.println(res-1);
		}
	}

}

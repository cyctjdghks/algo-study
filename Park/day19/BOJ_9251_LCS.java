import java.util.ArrayList;
import java.util.Scanner;

// BOJ 9251. LCS
public class BOJ_9251_LCS {

	public static void main(String[] args) {
		
		ArrayList<Character> list1 = new ArrayList<Character>();
		ArrayList<Character> list2 = new ArrayList<Character>();
		
		String str1;
		String str2;
		
		int res = 0;
		
		Scanner sc = new Scanner(System.in);
		
		str1 = sc.next();
		str2 = sc.next();
		
		for(int i = 0; i < str1.length();i++) {
			list1.add(str1.charAt(i));
		}
		for(int i = 0; i < str2.length();i++) {
			list2.add(str2.charAt(i));
		}
		
//		for(int i = 0; i < str1.length();i++) {
//			System.out.print(list1.get(i) + " ");
//		}
//		System.out.println();
//		for(int i = 0; i < str2.length();i++) {
//			System.out.print(list2.get(i) + " ");
//		}
//		System.out.println();
		
		while(true) {
			if(list1.isEmpty() || list2.isEmpty()) break;
			
			if(list2.contains(list1.get(0))) {
				int index = list2.indexOf(list1.get(0));
				for(int j = 0; j < index; j++) {
					list2.remove(j);
				}
				res++;
			}
			list1.remove(0);
		}
		
		System.out.println(res);
		
	}

}

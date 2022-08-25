import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Hearsay_1764 {

	public static void main(String[] args) {
		int n, m;
		String str;
		HashSet<String> set = new HashSet<>();
		ArrayList<String> list = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		for(int i = 0; i < n; i++) {
			str = sc.next();
			set.add(str);
		}
		
		for(int i = 0; i < m; i++) {
			str = sc.next();
			if(set.contains(str)) {
				list.add(str);
			}
		}
		
		Collections.sort(list);
		
		sb.append(list.size() + "\n");
        for (String s : list) {
            sb.append(s + "\n");
        }
        
        System.out.print(sb);
	}

}

package boj;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class _1181 {
// 1181 - 단어 정렬
	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new FileReader("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] arr = new String[n];
		for(int i=0; i<n; i++) {
			arr[i] = br.readLine();
		}
		
		Arrays.sort(arr, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if(o1.length() < o2.length()) {
					return -1;
				} else if(o1.length() > o2.length()) {
					return 1;
				} else {
					return o1.compareTo(o2);
				}
			}
		});
		
		String temp = "";
		for(int i=0; i<n; i++) {
			if(temp.equals(arr[i])) {
				continue;
			}
			System.out.println(arr[i]);
			temp = arr[i];
		}
	}
}

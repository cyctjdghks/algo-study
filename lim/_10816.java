import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Boj10816 {
// 숫자 카드 2
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		HashMap<Integer, Integer> map = new HashMap<>();

		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			int temp = Integer.parseInt(st.nextToken());
			if(map.get(temp) == null) map.put(temp, 1);
			else map.replace(temp, map.get(temp)+1);
		}
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < m; i++) {
			int temp = Integer.parseInt(st.nextToken());
			if(map.get(temp) == null) sb.append("0 ");
			else sb.append(map.get(temp)+" ");
		}
		System.out.println(sb);

	}

}

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Boj1620 {
// 나는야 포켓몬 마스터
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		HashMap<String, String> hMap1 = new HashMap<>();
		HashMap<String, String> hMap2 = new HashMap<>();
		
		for(int i = 1; i <= n; i++) {
			String s = br.readLine();
			hMap1.put(Integer.toString(i), s);
			hMap1.put(s, Integer.toString(i));
		}
		for(int i = 0; i < m; i++) {
			String s = br.readLine();
			if(hMap1.get(s) != null) sb.append(hMap1.get(s));
			else sb.append(hMap2.get(s));
			sb.append("\n");
		}
		System.out.println(sb);
	}
}

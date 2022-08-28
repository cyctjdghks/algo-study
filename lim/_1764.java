import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Boj1764 {
// 듣보잡
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		HashMap<String, String> d = new HashMap<>();
		HashMap<String, String> b = new HashMap<>();
		for(int i = 0; i < n; i++) {
			d.put(br.readLine(), "good");
		}
		ArrayList<String> res = new ArrayList<>();
		for(int i = 0; i < m; i++) {
			String s = br.readLine();
			String r = d.get(s);
			if(r != null) res.add(s);
		}
		Collections.sort(res);
		System.out.println(res.size());
		for(String s : res) {
			System.out.println(s);
		}

	}
}

package class3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*
 * 나는야 포켓몬 마스터 
 */

public class _1620 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		Map<Integer, String> IndexList = new HashMap<>();
		Map<String, Integer> NameList = new HashMap<>();
		
		for(int i=1; i<=n; i++) {
			String input = br.readLine();
			IndexList.put(i, input);
			NameList.put(input, i);
		}
		
		for(int i=0; i<m; i++) {
			String input = br.readLine();
			// 숫자라면
			if('0' <= input.charAt(0) && input.charAt(0) <= '9') {
				bw.write(IndexList.get(Integer.parseInt(input)) + "\n");
			} else {
				bw.write(NameList.get(input) + "\n");
			}
		}
		
		bw.flush();
		
		
	}

}

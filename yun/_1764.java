package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

/*
 * Hashset
 * addAll() 합집합 
 * retainAll() 교집합 
 * removeAll() 차집합 
 */

public class _1764 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		HashSet<String> set1 = new HashSet<>();
		HashSet<String> set2 = new HashSet<>();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			set1.add(br.readLine());
		}
		for (int i = 0; i < M; i++) {
			set2.add(br.readLine());
		}

		// 교집합 
		set1.retainAll(set2);
		
		// 정렬 위해 리스트로 변환 
		List<String> list = new ArrayList<>(set1);
		Collections.sort(list);

		// 결과 출력 
		System.out.println(list.size());
		for (String e : list) {
			System.out.println(e);
		}

	}

}

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _7662 {
// 이중 우선순위 큐
	static class Data implements Comparable<Data>{
		int num;
		int order;
		public Data(int num, int order) {
			this.num = num;
			this.order = order;
		}
		@Override
		public int compareTo(Data o) {
			if(num < o.num) return -1;
			if(num == o.num) return 0;
			return 1;
		}
	}
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t = 1; t <= tc; t++) {
			PriorityQueue<Data> minPQ = new PriorityQueue<>();
			PriorityQueue<Data> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
			int n = Integer.parseInt(br.readLine());
			boolean[] record = new boolean[1000001]; 
			StringTokenizer st; 
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int tmp = 0;
				switch(st.nextToken()) {
				// 요소 삽입
				case "I":
					tmp = Integer.parseInt(st.nextToken());
					minPQ.add(new Data(tmp, i));
					maxPQ.add(new Data(tmp, i));
					break;
				case "D":
					tmp = Integer.parseInt(st.nextToken());
					// 힙이 비면 연산 중단
					if(minPQ.isEmpty() | maxPQ.isEmpty()) break;
					if(tmp == 1) { //최대힙에서 삭제연산
						// 이미 최소힙에서 삭제된 요소는 건너뛰기
						while(!maxPQ.isEmpty() && record[maxPQ.peek().order]) {
							maxPQ.poll();
						}
						if(!maxPQ.isEmpty()) {
							// 최대힙에서 요소를 뽑고 삭제되었음을 record에 기록한다
							record[maxPQ.poll().order] = true;
						}
					} else { // 최소힙에서 삭제연산
						// 이미 최대힙에서 삭제된 요소는 건너뛰기
						while(!minPQ.isEmpty() && record[minPQ.peek().order]) {
							minPQ.poll();
						}
						if(!minPQ.isEmpty()) {
							// 최소힙에서 요소를 뽑고 삭제되었음을 record에 기록한다
							record[minPQ.poll().order] = true;
						}
					}
					break;
				}
			}
			// 삭제되었는데 안꺼내진 요소 마저 비워내기
			while(!minPQ.isEmpty() && record[minPQ.peek().order]) {
				minPQ.poll();
			}
			while(!maxPQ.isEmpty() && record[maxPQ.peek().order]) {
				maxPQ.poll();
			}
			if(minPQ.isEmpty() | maxPQ.isEmpty()) {
				System.out.println("EMPTY");
			} else {
				System.out.print(maxPQ.peek().num + " " + minPQ.peek().num + "\n");
			}
		}
	}
}

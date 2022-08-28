import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FishingHole {

	static int N; // 낚시꾼 수
	static int[] map; // 낚시터
	static int[][] gate; // 출입구 저장
	static int[] output; // 숫자 3의 순열
	static boolean[] out_v; // 순열 방문체크
	static int res;

	public static void main(String[] args) {
		// 낚시터 자리가 1 ~ N
		// 3개의 출입구
		// 한 사람당 하나의 낚시터
		// 하나의 출입구에서 입장이 끝난 후 다른 출입구에서 입장
		// 1번 출구 2번 출구 3번 출구의 낚시꾼들의 입장 순서에 따라서
		// 서로에 영향을 주는 범위라면
		// 1 > 2 혹은 2 > 1 순서대로 바꿔서 수행
		// 거리가 같을 때 왼쪽부터 넣거나 오른쪽부터 넣거나
		// 낚시꾼 수가 짝수 일때는 왼쪽에 넣고 오른쪽에 넣고 2번 수행
		// 테스트 케이스 T
		// 낚시터 자리의 개수 N
		// 3 줄에 걸쳐 츨입구 위치, 대기하고있는 낚시꾼들 수
		// 각 낚시꾼들의 이동거리의 합이 최소가 되는 값

		int T;

		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			map = new int[N + 1]; // 1 ~ N 까지
			gate = new int[3 + 1][2]; // 3개의 출입구, 낚시꾼 수 (1번 ~ 3번)
			output = new int[3];
			out_v = new boolean[3];
			res = 9999_9999;

			// 게이트 입력
			for (int i = 1; i <= 3; i++) {
				gate[i][0] = sc.nextInt();
				gate[i][1] = sc.nextInt();
			}

			// 배열 오름차순으로 정렬 - arrys.sort 재정의(gate 배열 첫번째 값만 비교하면됨)
			Arrays.sort(gate, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[0] > o2[0] ? 1 : -1;
				}
			});

//			// 배열 확인
//			for(int i = 1; i < gate.length; i++) {
//				System.out.println(gate[i][0] + " " + gate[i][1]);
//			}

			// 3의 순열 만들기
			perm(3, 0);

			System.out.println("#" + tc + " " + res);
		}
	}

	public static void perm(int n, int r) {
		if (r == 3) {
//			// 순열 확인
//			System.out.println(Arrays.toString(output));

			// 순열에 적힌 순서대로 gate 입장
			entry();
			// 수행하고 map 배열 다시 초기화
			
			return;
		}

		for (int i = 0; i < n; i++) {
			if (out_v[i] == false) {
				out_v[i] = true;
				output[r] = i + 1;
				perm(n, r + 1);
				out_v[i] = false;
			}
		}
	}

	public static void entry() {
		int count; // 이동거리

		// 이동 거리 = | (gate 위치) - (값을 넣은 index) | + 1
		// 홀수면 그냥 넣으면 되지만, 짝수라면 왼쪽에 넣을지 오른쪽에 넣을지 달라짐
		// output 순서대로 게이트 번호 넣기
		// 3개 모두 짝수 일 경우 8가지의 경우의 수
		// l l l
		// l l r
		// l r l
		// r l l
		// l r r
		// r l r
		// r r l
		// r r r
		// 이걸 못해서 단순 노가다로 8가지 모두 비교
		Arrays.fill(map, 0);
		count = 0;
		count += position_l(output[0]);
		count += position_l(output[1]);
		count += position_l(output[2]);
		res = Math.min(res, count);
		
		Arrays.fill(map, 0);
		count = 0;
		count += position_l(output[0]);
		count += position_l(output[1]);
		count += position_r(output[2]);
		res = Math.min(res, count);

		Arrays.fill(map, 0);
		count = 0;
		count += position_l(output[0]);
		count += position_r(output[1]);
		count += position_l(output[2]);
		res = Math.min(res, count);
		
		Arrays.fill(map, 0);
		count = 0;
		count += position_r(output[0]);
		count += position_l(output[1]);
		count += position_l(output[2]);
		res = Math.min(res, count);
		
		Arrays.fill(map, 0);
		count = 0;
		count += position_l(output[0]);
		count += position_r(output[1]);
		count += position_r(output[2]);
		res = Math.min(res, count);
		
		Arrays.fill(map, 0);
		count = 0;
		count += position_r(output[0]);
		count += position_l(output[1]);
		count += position_r(output[2]);
		res = Math.min(res, count);
		
		Arrays.fill(map, 0);
		count = 0;
		count += position_r(output[0]);
		count += position_r(output[1]);
		count += position_l(output[2]);
		res = Math.min(res, count);
		
		Arrays.fill(map, 0);
		count = 0;
		count += position_r(output[0]);
		count += position_r(output[1]);
		count += position_r(output[2]);
		res = Math.min(res, count);
	
	}

	public static int position_r(int num) { // 오른쪽부터 채우기
		int count = 0; // 이동 거리
		int gate_location = gate[num][0]; // 게이트 위치
		int people = gate[num][1]; // 낚시꾼들 수

//		System.out.println(gate_location + "에서 수행");
//		// 각 게이트의 gate 위치와 낚시꾼 갯수 확인
//		System.out.print("gate["+num+"][0]" + " : " + gate[num][0] + " ");
//		System.out.print("gate["+num+"][1]" + " : " + gate[num][1] + " ");		

		// 만약 게이트 위치에 낚시꾼이 없다면 그 위치에 낚시꾼 넣고 다음으로
		if (map[gate_location] == 0) {
//			System.out.println(gate_location + "위치에 낚시꾼 위치시킴");
			map[gate_location] = 1;
			count += 1;
			people--;
			if (people == 0) {
				return count;
			}
		}
		
		// 게이트 위치에 낚시꾼이 있다면 우좌로 넘어가면서 낚시꾼 위치 시키기
		int cur = gate_location;
		int idx = 0;
		while (true) {
			idx++;
			for (int i = 0; i < 2; i++) {
				int nx;
				if (i == 0) {
					nx = cur + idx;
				} else {
					nx = cur - idx;
				}

				if (isInBound(nx)) {
					if (map[nx] == 0) {
//						System.out.println(nx + "위치에 낚시꾼 위치시킴");
						map[nx] = 1;
						count += Math.abs(gate_location - nx) + 1;
						people--;
						if (people == 0) {
							return count;
						}
					}
				}
				
				
			}
		}
		
		
	}
	
	public static int position_l(int num) { // 왼쪽부터 채우기
		int count = 0; // 이동 거리
		int gate_location = gate[num][0]; // 게이트 위치
		int people = gate[num][1]; // 낚시꾼들 수

//		System.out.println(gate_location + "에서 수행");
//		// 각 게이트의 gate 위치와 낚시꾼 갯수 확인
//		System.out.print("gate["+num+"][0]" + " : " + gate[num][0] + " ");
//		System.out.print("gate["+num+"][1]" + " : " + gate[num][1] + " ");		

		// 만약 게이트 위치에 낚시꾼이 없다면 그 위치에 낚시꾼 넣고 다음으로
		if (map[gate_location] == 0) {
//			System.out.println(gate_location + "위치에 낚시꾼 위치시킴");
			map[gate_location] = 1;
			count += 1;
			people--;
			if (people == 0) {
				return count;
			}
		}
		
		// 게이트 위치에 낚시꾼이 있다면 우좌로 넘어가면서 낚시꾼 위치 시키기
		int cur = gate_location;
		int idx = 0;
		while (true) {
			idx++;
			for (int i = 0; i < 2; i++) {
				int nx;
				if (i == 0) {
					nx = cur - idx;
				} else {
					nx = cur + idx;
				}

				if (isInBound(nx)) {
					if (map[nx] == 0) {
//						System.out.println(nx + "위치에 낚시꾼 위치시킴");
						map[nx] = 1;
						count += Math.abs(gate_location - nx) + 1;
						people--;
						if (people == 0) {
							return count;
						}
					}
				}
				
				
			}
		}
		
		
	}

	public static boolean isInBound(int r) {
		return r > 0 && r <= N;
	}
}

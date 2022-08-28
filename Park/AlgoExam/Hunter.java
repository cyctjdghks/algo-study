import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Hunter {

	static int N;
	static int[][] mon_cl; // 몬스터 좌표, 고객 좌표
	static int res;
	static int[] output;
	static boolean[] out_v;

	public static void main(String[] args) {
		// 테스트 케이스 T
		// 맵의 길이 N
		// 몬스터는 양수, 고객은 음수
		// 사냥꾼은 1, 1에서 시작 => 0, 0 에서 시작
		// 몬스터의 좌표와 고객의 좌표를 모두 아는데 Greedy 하게 접근할 수 있지 않을까?
		// Greedy 하게는 안되고 순열(순서 상관O)로 풀어서 접근
		// 총 가짓수는 8!
		// 그 중에 moster[i] 를 지나야 client[i]에 접근할 수 있음
		// 각 좌표별 거리 구하기
		// |x1 - x2| + |y1 - y2|

		int T;
		int val;
		int mc; // 몬스터와 고객의 숫자

		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			mon_cl = new int[8][2]; // 몬스터는 최대 4마리, 고객도 최대 4마리
			res = 9999_9999;
			mc = 0;

			for (int i = 0; i < 8; i++) { // -1로 전부 초기화 => 만약 해당 값이 -1이라면 해당 번호 몬스터는 존재X
				for (int j = 0; j < 2; j++) {
					mon_cl[i][j] = -1;
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					val = sc.nextInt();
					switch (val) { // 몬스터는 양수, 고객은 음수
					case 1: // 0
						mon_cl[0][0] = i;
						mon_cl[0][1] = j;
						mc++;
						break;
					case 2: // 2
						mon_cl[2][0] = i;
						mon_cl[2][1] = j;
						mc++;
						break;
					case 3: // 4
						mon_cl[4][0] = i;
						mon_cl[4][1] = j;
						mc++;
						break;
					case 4: // 6
						mon_cl[6][0] = i;
						mon_cl[6][1] = j;
						mc++;
						break;
					case -1: // 1
						mon_cl[1][0] = i;
						mon_cl[1][1] = j;
						mc++;
						break;
					case -2: // 3
						mon_cl[3][0] = i;
						mon_cl[3][1] = j;
						mc++;
						break;
					case -3: // 5
						mon_cl[5][0] = i;
						mon_cl[5][1] = j;
						mc++;
						break;
					case -4: // 7
						mon_cl[7][0] = i;
						mon_cl[7][1] = j;
						mc++;
						break;
					default:
						break;
					}
				}
			}
			
			output = new int[mc];
			out_v = new boolean[mc];
			perm(mc, 0); // 몬스터, 고객 수만큼 순열 뽑기
			
			System.out.println("#" + tc + " " + res);
		}
	}
	
	public static void perm(int n, int r) {
		if(r == n) {
//			System.out.println(Arrays.toString(output));
			
			boolean bool = true;
			ArrayList<Integer> list = new ArrayList<>();
			for(int i = 0; i < output.length; i++) {
				list.add(output[i]);
			}
			
//			System.out.println(list.indexOf(0));
			
			// 0 < 1, 2 < 3, 4 < 5, 6 < 7
			for(int i = 0; i < list.size(); i += 2) {
				if(list.indexOf(i) >= list.indexOf(i+1)) {
					bool = false;
				}
			}
			
			if(bool) {
				len();
			}
			
			return;
		}
		
		for(int i = 0; i < n; i++) {
			if(out_v[i] == false) {
				out_v[i] = true;
				output[r] = i;
				perm(n, r + 1);
				out_v[i] = false;
			}
		}
	}
	
	public static void len() {
		int count = 0;
//		System.out.println(Arrays.toString(output));
		count += Math.abs(0 - mon_cl[output[0]][0]) + Math.abs(0 - mon_cl[output[0]][1]);
		for(int i = 0; i < output.length - 1; i++) {
			count += Math.abs(mon_cl[output[i]][0] - mon_cl[output[i+1]][0])
					+ Math.abs(mon_cl[output[i]][1] - mon_cl[output[i+1]][1]);
		}
		
		
		res = Math.min(res, count);
	}
}

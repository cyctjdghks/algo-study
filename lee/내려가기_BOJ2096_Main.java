package solved.category_DP_SlidingWindow.gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//궁금증1: 메소드 반복이 많아지면 그냥 static으로 선언하는 것이 오히려 더 빠를까/메모리를 덜 쓸까?
//2: 현재는 for문을 쓰는 것이 더 메모리를 많이 쓰는 것으로 보임 -> 아래의 for(int i = 1; i < N; i++) 이걸 그냥 풀어쓰면 공간과 시간복잡도는 어케 될까?
public class 내려가기_BOJ2096_Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] in = new int[3];
		int[][] minDp = new int[2][3];
		int[][] maxDp = new int[2][3];
		int N = Integer.parseInt(br.readLine());
		String line = br.readLine();
		in[0] = line.charAt(0) - '0';
		minDp[1][0] = in[0];
		maxDp[1][0] = in[0];
		in[1] = line.charAt(2) - '0';
		minDp[1][1] = in[1];
		maxDp[1][1] = in[1];
		in[2] = line.charAt(4) - '0';
		minDp[1][2] = in[2];
		maxDp[1][2] = in[2];

		if (N > 1) {
			for (int i = 1; i < N; i++) {
				line = br.readLine();
				in[0] = line.charAt(0) - '0';
				in[1] = line.charAt(2) - '0';
				in[2] = line.charAt(4) - '0';
				minDp[0][0] = minDp[1][0];
				maxDp[0][0] = maxDp[1][0];
				minDp[0][1] = minDp[1][1];
				maxDp[0][1] = maxDp[1][1];
				minDp[0][2] = minDp[1][2];
				maxDp[0][2] = maxDp[1][2];
				minDp[1][0] = in[0] + Math.min(minDp[0][0], minDp[0][1]);
				minDp[1][1] = in[1] + Math.min(Math.min(minDp[0][0], minDp[0][1]), minDp[0][2]);
				maxDp[1][1] = in[1] + Math.max(Math.max(maxDp[0][0], maxDp[0][1]), maxDp[0][2]);
				minDp[1][2] = in[2] + Math.min(minDp[0][1], minDp[0][2]);
				maxDp[1][0] = in[0] + Math.max(maxDp[0][0], maxDp[0][1]);
				maxDp[1][2] = in[2] + Math.max(maxDp[0][1], maxDp[0][2]);
			}
		}
		int ansMin = Math.min(Math.min(minDp[1][0], minDp[1][1]), minDp[1][2]);
		int ansMax = Math.max(Math.max(maxDp[1][0], maxDp[1][1]), maxDp[1][2]);
		System.out.println(ansMax + " " + ansMin);
	}

}

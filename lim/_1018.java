package boj;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1018 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
	
		char[][] map = new char[n][m];
		String tempStr = "";
		for(int i=0; i<n; i++) {
			tempStr = br.readLine();
			for(int j=0; j<m; j++) {
				map[i][j] = tempStr.charAt(j);
			}
		}
		//입력
		
		char firstChar;
		int diff;
		int res;
		boolean mustBeSame;
		int minDiff = Integer.MAX_VALUE;
		for(int i=0; i<n-7; i++) {
			for(int j=0; j<m-7; j++) {
				firstChar = map[i][j];
				diff = 0;
				mustBeSame = true;
				for(int x=0; x<8; x++) {
					for(int y=0; y<8; y++) {
						if(mustBeSame) {
							if(firstChar != map[i+x][j+y]) {
								diff++;
							}
						} else {
							if(firstChar == map[i+x][j+y]) {
								diff++;
							}
						}
						mustBeSame = !mustBeSame;
					}
					mustBeSame = !mustBeSame;
				}
				res = Math.min(diff, 64-diff);
				if(res < minDiff) {
					minDiff = res;
				}
			}
		}
		System.out.println(minDiff);
	}
}

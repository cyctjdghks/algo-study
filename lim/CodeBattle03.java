import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CodeBattle03 {
// 코드배틀 No.3 셔플 머시기
	static int n;
	static int minShuffle;
	static int[] cards;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t = 1; t <= tc; t++) {
			n = Integer.parseInt(br.readLine());
			minShuffle = Integer.MAX_VALUE;
			cards = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++) {
				cards[i] = Integer.parseInt(st.nextToken());
			}
			shuffle(cards, 0, 0);
			if(minShuffle == Integer.MAX_VALUE) {
				System.out.println("#" + t + " " + "-1");
				continue;
			}
			System.out.println("#" + t + " " + minShuffle);
		}
	}
	
	public static void shuffle(int[] arr, int x, int num) {
		// 0 ~ N/2 => 카드 뭉치를 그대로 두고 정렬한다.
		if(x < n/2) {
			for(int i = 0; i <= x; i++) {
				int start = n/2 - i;
				for(int j = 0; j < i; j++) {
					swap(arr, start, start+1);
					start += 2;
				}	
			}
		// N/2 ~ N-1 => 두 카드 뭉치의 위치를 교환한다.
		} else {
			for(int i = 0; i < n/2; i++) {// 좌우 절반 바꾸기
				swap(arr, i, i+n/2);
			}
			x = Math.abs(x-(n-1));
			for(int i = 0; i <= x; i++) {
				int start = n/2 - i;
				for(int j = 0; j < i; j++) {
					swap(arr, start, start+1);
					start += 2;
				}	
			}
		}
		// 셔플링한 카드뭉치가 정렬되었는지 검사
		if(isSorted(arr)) {
			minShuffle = Math.min(minShuffle, num);
			return;
		}
		// 5회 초과 검사
		if(5 < num) return;
		// 정렬 안되었으니 0~n-1 순서대로 한번 더 섞자
		for(int i = 0; i < n; i++) {
			shuffle(Arrays.copyOf(arr, arr.length), i, num+1);
		}
	}
	
	//카드 스왑
	public static void swap(int[] arr, int x, int y) {
		int tmp = arr[x];
		arr[x] = arr[y];
		arr[y] = tmp;
	}
	
	// 정렬되었는지 검사
	public static boolean isSorted(int[] arr) {
		// 처음엔 다 정렬되어있다고 가정
		boolean ascending = true;
		boolean descending = true;
		for(int i = 0; i < n-1; i++) {
			// 카드를 탐색하며 오름이나 내림차순이 깨지는 순간 false로 변경
			if(arr[i] < arr[i+1]) {
				descending = false;
			} else {
				ascending = false;
			}
		}
		// 정렬여부 리턴
		if(ascending | descending) {
			return true;
		}
		return false;
	}
}

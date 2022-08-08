import java.io.FileInputStream;
import java.util.Scanner;

public class Main {
	static int r, c;
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();
		int size = (int)Math.pow(2, n);
		
		zzz(0, 0, size, 0);
	}
	
	public static void zzz(int x, int y, int size, int cnt) {
		int newSize = size/2;
		if(size == 1) {
			System.out.println(cnt);
			return;
		}
		int upDown = r/(newSize+x); //현재 구역에서 목표지점이 절반상단인지 절반하단인지 찾기
		int leftRight = c/(newSize+y); // 현재 구역에서 목표지점이 좌측절반인지 우측절반인지 찾기
		cnt = cnt + upDown*(newSize*newSize)*2 + leftRight*(newSize*newSize);
        //구해진 상하좌우 구역에 따라 cnt값을 갱신해준다.
		
		zzz(x+upDown*newSize, y+leftRight*newSize, newSize, cnt);
        //현재구역에서 탐색구역을 1/4로 잘라내어 새로이 탐색
	}
	
// 시 간 초 과 시 간 초 과시 간 초 과 시 간 초 과 시 간 초 과 시 간 초 과 시 간 초 과 시 간 초 과 시 간 초 과 시 간 초 과   
//	public static void zzz(int x, int y, int r, int c, int size, int cnt) {
//		if(size == 1) {
//			if(x == r && y == c) {
//				System.out.println(cnt);
//			}
//			return;
//		}
//		int gap = size/2;
//		zzz(x, y, r, c, gap, cnt);
//		zzz(x, y+gap, r, c, gap, cnt+gap*gap);
//		zzz(x+gap, y, r, c, gap, cnt+gap*gap*2);
//		zzz(x+gap, y+gap, r, c, gap, cnt+gap*gap*3);
//	}

}

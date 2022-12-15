import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Swea2105 {
// 디저트 카페
    static int n;
    static int maxSum;
    static int[][] map;
    static int[] dx = {1, 1, -1, -1};
    static int[] dy = {1, -1, -1, 1};
 
    public static void main(String[] args) throws Exception{
//      System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for(int t = 1; t <= tc; t++) {
            maxSum = 0;
            n = Integer.parseInt(br.readLine());
            map = new int[n][n];
            for(int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            // 입력
            for(int i = 0; i < n-2; i++) {
                for(int j = 1; j < n-1; j++) {
                    dfs(i, j, i, j, 0, 0, new boolean[101]);
                }
            }
            if(maxSum == 0) 
                System.out.println("#" + t + " " + -1);
            else
                System.out.println("#" + t + " " + maxSum);
        }
    }
 
    private static void dfs(int sx, int sy, int x, int y, int sum, int turn, boolean vst[]) {
        // turn: 꺾을 때 마다 1씩 더함
        if(sum != 0) {
            if(sx == x && sy == y) { // 제자리로 돌아옴
                maxSum = Math.max(sum, maxSum);
                return;
            }
        }
        int nx = x + dx[turn];
        int ny = y + dy[turn];
        if(0 <= nx && nx < n && 0 <= ny && ny < n) {
            if(!vst[map[nx][ny]]) {
                boolean[] nVst = new boolean[101];
                for(int i = 0; i < 101; i++) nVst[i] = vst[i];
                nVst[map[nx][ny]] = true;
                dfs(sx, sy, nx, ny, sum+1, turn, nVst);
            }
        }
        if(3 < turn+1) return;
        nx = x + dx[turn+1];
        ny = y + dy[turn+1];
        if(0 <= nx && nx < n && 0 <= ny && ny < n) {
            if(!vst[map[nx][ny]]) {
                boolean[] nVst = new boolean[101];
                for(int i = 0; i < 101; i++) nVst[i] = vst[i];
                nVst[map[nx][ny]] = true;
                dfs(sx, sy, nx, ny, sum+1, turn+1, nVst);
            }
        }
    }
 
}
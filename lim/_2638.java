import java.io.*;
import java.util.StringTokenizer;

public class Boj2638 {
    static int n, m;
    static int[][] map;
    static boolean[][] vst;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        vst = new boolean[n][m];
        int cnt = 0;

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        while(!isEnd()) {
            vst = new boolean[n][m];
            dfs(0, 0);
            goodbyeCheese();
            cnt++;
        }
        System.out.println(cnt);
    }

//    static private void pr() {
//        for(int i = 0; i < n; i++){
//            for(int j = 0; j < m; j++) {
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println("===================");
//    }

    static private boolean isEnd() {
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++) {
                if(map[i][j] != 0) return false;
            }
        }
        return true;
    }

    static private void dfs(int x, int y) {
        vst[x][y] = true;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || n <= nx || ny < 0 || m <= ny) continue;
            if(vst[nx][ny]) continue;
            if(map[nx][ny] == 0) {
                dfs(nx, ny);
            } else if (1 <= map[nx][ny]) {
                map[nx][ny]++;
            }
        }
    }

    static private void goodbyeCheese() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 2) map[i][j] = 1;
                if(2 < map[i][j]) map[i][j] = 0;
            }
        }
    }

}

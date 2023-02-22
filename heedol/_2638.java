import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2638 {

    static class Point {
        int r, c;

        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int n, m; // 모눈 종이 크기
    static char[][] map; // 치즈 위치
    static int[][] punchCntMap; // 해당 회차에서의 외부 공기 노출 횟수 기록
    static boolean[][] visited; // 방문 체크 배열
    static Queue<Point> meltingPoints; // 해당 회차에서의 녹을 치즈 위치

    // 상, 우, 하, 좌
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = st.nextToken().charAt(0);
            }
        }

        meltingPoints = new LinkedList<>();

        int time = 0; // 치즈가 모두 녹아 없어지는데 걸리는 시간

        while (true) {
            visited = new boolean[n][m];
            punchCntMap = new int[n][m];

            // 녹일 치즈 위치 찾으러 다니기
            searchMeltingPoint(0, 0);

            // 녹일 곳 없으면 끝내기
            if (meltingPoints.isEmpty()) {
                break;
            }

            // 치즈 녹이기
            while (!meltingPoints.isEmpty()) {
                Point meltingPoint = meltingPoints.poll();
                map[meltingPoint.r][meltingPoint.c] = '0';
            }

            time++; // 시간 1 증가
        }

        System.out.println(time);
    }

    private static void searchMeltingPoint(int r, int c) {

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            // 범위를 벗어났다면 다음 탐색
            if (!(nr >= 0 && nr < n && nc >= 0 && nc < m)) {
                continue;
            }

            // 이미 방문한 위치면 다음 탐색
            if (visited[nr][nc]) {
                continue;
            }

            // 치즈라면
            if (map[nr][nc] == '1') {
                punchCntMap[nr][nc]++; // 외부 공기 접촉 +1
                if (punchCntMap[nr][nc] >= 2) { // 외부 공기 접촉이 2곳 이상에서 일어났다면
                    meltingPoints.offer(new Point(nr, nc)); // 녹일 치즈 위치에 추가
                    visited[nr][nc] = true; // 방문 처리
                }
            } else { // 치즈가 아니라면
                visited[nr][nc] = true; // 방문 처리
                searchMeltingPoint(nr, nc); // 해당 위치로 가서 탐색하기
            }
        }
    }

}
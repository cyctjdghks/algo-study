import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10830 {

    static final int MOD = 1000;
    static int n;
    static int[][] origin;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        origin = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                origin[i][j] = Integer.parseInt(st.nextToken()) % MOD;
            }
        }

        int[][] result = pow(origin, b); // 행렬 제곱 연산

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    private static int[][] pow(int[][] map, long exp) {
        // 지수가 1이면 바로 반환
        if (exp == 1L) {
            return map;
        }

        // 지수 절반으로 분할
        int[][] result = pow(map, exp / 2);

        result = multiply(result, result); // 행렬 곱하기

        // 지수가 홀수였다면 origin을 한번 더 곱함
        if (exp % 2 == 1L) {
            result = multiply(result, origin);
        }

        return result;
    }

    private static int[][] multiply(int[][] mapA, int[][] mapB) {
        int[][] result = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    result[i][j] += (mapA[i][k] * mapB[k][j]);
                }
                result[i][j] %= MOD;
            }
        }

        return result;
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2448 {

    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        map = new char[n][2 * n - 1];

        marking(n, 0, 0);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2 * n - 1; j++) {
                sb.append(map[i][j] == '*' ? '*' : ' ');
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    private static void marking(int n, int r, int c) {
        // 이번에 분할된 부분의 높이가 3보다 큰 경우, 크게 3부분으로 나누어서 재귀
        if (n / 2 >= 3) {
            // 위
            marking(n / 2, r, c + n / 2);
            // 아래 왼쪽
            marking(n / 2, r + n / 2, c);
            // 아래 오른쪽
            marking(n / 2, r + n / 2, c + n);
            return;
        }

        // 1줄:   *
        map[r][c + 2] = '*';

        // 2줄: * *
        map[r + 1][c + 1] = '*';
        map[r + 1][c + 3] = '*';

        // 3줄: *****
        for (int i = 0; i < 5; i++) {
            map[r + 2][c + i] = '*';
        }
    }
}

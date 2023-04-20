import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _15657 {
    static int n, m;
    static int[] map;
    static int[] selected;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n];
        selected = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(map);
        dfs(0, 0);
        System.out.print(sb);
    }

    private static void dfs(int start, int cnt) {
        if (cnt == m) {
            for (int num : selected) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < n; i++) {
            selected[cnt] = map[i];
            dfs(i, cnt + 1);
        }
    }
}

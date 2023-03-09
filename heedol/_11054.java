import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11054 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] ascDp = new int[n];
        int[] descDp = new int[n];

        // LIS
        for (int i = 0; i < n; i++) {
            ascDp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    ascDp[i] = Math.max(ascDp[i], ascDp[j] + 1);
                }
            }
        }

        // LDS
        for (int i = n - 1; i >= 0; i--) {
            descDp[i] = 1;
            for (int j = n - 1; j > i; j--) {
                if (arr[i] > arr[j]) {
                    descDp[i] = Math.max(descDp[i], descDp[j] + 1);
                }
            }
        }

        // LIS 길이와 LDS 길이를 더한 값 -1 이 가장 긴 바이토닉 부분 수열
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, ascDp[i] + descDp[i] - 1); // 최댓값 찾기
        }

        System.out.println(max);
    }
}

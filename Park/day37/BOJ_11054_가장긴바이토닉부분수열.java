import java.util.Arrays;
import java.util.Scanner;

public class BOJ_11054_가장긴바이토닉부분수열 {
    static int N;
    static int[] arr;
    static int[] dp1;
    static int[] dp2;
    static int res;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        arr = new int[N];
        dp1 = new int[N];
        dp2 = new int[N];
        res = 0;

        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.fill(dp1, 1);
        Arrays.fill(dp2, 1);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && dp1[i] < dp1[j] + 1) {
                    dp1[i] = dp1[j] + 1;
                }
            }
        }

        for (int i = N - 1; i >= 0; i--) {
            for (int j = N - 1; j > i; j--) {
                if (arr[j] < arr[i] && dp2[i] < dp2[j] + 1) {
                    dp2[i] = dp2[j] + 1;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            res = Math.max(res, dp1[i] + dp2[i] - 1);
        }

        System.out.println(res);
    }
}

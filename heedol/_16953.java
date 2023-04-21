import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _16953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int answer = 0;
        int time = 0;
        while (true) {
            if (a == b) {
                answer = time;
                break;
            }

            if (b % 2 == 0) {
                b /= 2;
            } else if (b > 10 && b % 10 == 1) {
                b /= 10;
            } else {
                break;
            }

            time++;
        }

        System.out.println(answer != 0 ? answer + 1 : -1);
    }
}

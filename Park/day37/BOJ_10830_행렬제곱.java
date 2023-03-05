import java.util.Scanner;

public class BOJ_10830_행렬제곱 {
    static int N;
    static long B;
    static int[][] map;
    static int[][] res;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        B = sc.nextLong();

        map = new int[N][N];
        res = new int[N][N];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
                res[i][j] = map[i][j];
            }
        }

//        print(map);

        res = divide(map, B);


        print(res);
    }

    public static int[][] divide(int[][] A, long len) {

        if(len == 1L) {
            return A;
        }

        int[][] arr = divide(A, len / 2);

        arr = conquer(arr, arr);

        if(len % 2 == 1L) {
            arr = conquer(arr, map);
        }

        return arr;
    }


    public static int[][] conquer(int[][] arr1, int[][] arr2) {

        int[][] arr = new int[N][N];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                for(int k = 0; k < N; k++) {

                    arr[i][j] += arr1[i][k] * arr2[k][j];
                    arr[i][j] %= 1000;
                }
            }
        }
        return arr;
    }


    private static void print(int[][] arr) {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                System.out.print(arr[i][j] % 1000 + " ");
            }
            System.out.println();
        }
    }
}

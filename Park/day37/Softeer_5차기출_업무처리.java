import java.util.*;
import java.io.*;


public class Softeer_5차기출_업무처리
{
    // 조직도 트리의 높이는 H
    // 업무는 R일 동안 진행
    // 말단 직원들만 각각 K개의 순서가 정해진 업무
    // 말단 직원들의 수 => N으로 하자
    // 단, 홀수 번째 날짜에는 왼쪽 부하 직원이 올린 업무를, 짝수 번째 날짜에는 오른쪽 부하 직원이 올린 업무를 처리한다.
    // 부서장이 처리한 일은 완료된 것이다. 업무를 올리는 것은 모두 동시에 진행한다. 따라서 그날 올린 업무를 상사가 처리하는 것은 그 다음날에야 가능하다.
    // => 첫쨰날은 그냥 올림
    // => 둘째날 부터 자기꺼 처리 하고 올림

    static int H, K, R; // 높이, 업무, 진행 날짜
    static int N; // 2^H
    static Queue<Integer>[] Queue_tail; // 말단 직원들
    static Queue<Integer>[][] Queue; // 중간 직원들
    static int res;

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        // 입력 파트
        H = sc.nextInt();
        K = sc.nextInt();
        R = sc.nextInt();
        N = (int) Math.pow(2, H);

        Queue_tail = new LinkedList[N + 1];
        Queue = new LinkedList[N + 1][2];
        for(int i = 0; i < N; i++) {
        	Queue_tail[i] = new LinkedList<Integer>();
        }
        for(int i = 1; i <= N; i++) {
        	Queue[i][0] = new LinkedList<Integer>();
        	Queue[i][1] = new LinkedList<Integer>();
        }
        res = 0;
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < K; j++) {
            	Queue_tail[i].add(sc.nextInt());
            }
        }
        
        // 큐 값 확인
        // for(int i = 0; i < N; i++) {
        // 	int size = Queue_tail[i].size();
        // 	for(int j = 0; j < size; j++) {
        // 		System.out.print(Queue_tail[i].poll() + " ");
        // 	}
        // 	System.out.println();
        // }

        // R 일 만큼 업무 수행
        for(int i = 1; i <= R; i++) {
            int check = (i + 1) % 2;// 날짜 확인 ( 홀수면 0, 짝수면 1)

            // 부서장의 업무 처리
            if(!Queue[1][check].isEmpty()) {
                res += Queue[1][check].poll();
            }

            // 중간 급 직원들 업무
            for(int index = 2; index <= N; index++) {
                // 처리할 업무가 있는 경우
                if(!Queue[index][check].isEmpty()) {
                    // 왼쪽, 오른쪽 직원 고려
                    if(index % 2 == 0) { // 짝수면 왼쪽 직원
                        Queue[index/2][0].add(Queue[index][check].poll());
                    } else {// 홀수면 오른쪽 직원
                        Queue[index/2][1].add(Queue[index][check].poll());
                    }
                }
            }

            // 말단 급 직원들 업무
            for(int index = 0; index < N; index++) {
                // 처리해야 되는 업무가 남아 있을 경우
                if(!Queue_tail[index].isEmpty()) {
                    // 업무를 하나 꺼내 부모 노드에 추가
                    // 왼쪽, 오른쪽 직원 고려
                    int idx = N + index;
                    if(idx % 2 == 0) { // 짝수면 왼쪽 직원
                        Queue[idx/2][0].add(Queue_tail[index].poll());
                    } else {// 홀수면 오른쪽 직원
                        Queue[idx/2][1].add(Queue_tail[index].poll());
                    }
                }
            }
        }

        // 결과 출력
        System.out.println(res);
    }
}
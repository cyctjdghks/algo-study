import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _9935 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] inputArr = br.readLine().toCharArray(); // 입력 문자열 배열

        char[] boomWordArr = br.readLine().toCharArray(); // 폭발 문자열 배열
        int boomWordLength = boomWordArr.length; // 폭발 문자열 길이

        Stack<Integer> stack = new Stack<>(); // 폭발 문자열 후보들의 현재 길이 값을 저장할 Stack

        StringBuilder sb = new StringBuilder();

        for (char ch : inputArr) {
            // 폭발 문자열의 첫번째 문자와 같은 경우
            if (ch == boomWordArr[0]) {
                if(boomWordLength != 1) { // 폭발 문자열의 길이가 1이 아니라면
                    stack.push(1); // 폭발 문자열 후보에 등록
                }
                continue; // 다음 문자 확인하러 바로 이동
            }

            // 확인 중인 폭발문자열이 존재한다면
            if (!stack.isEmpty()) {
                // 제일 최근에 확인하고 있던 폭발 문자열 후보의 다음에 올 문자와 같다면
                if (ch == boomWordArr[stack.peek()]) {
                    int nPos = stack.pop() + 1; // 새로운 폭발 문자열 길이
                    if (nPos != boomWordLength) { // 폭발 문자열이 완성되지 못했다면
                        stack.push(nPos); // 다시 스택에 넣기
                    }
                    continue; // 다음 문자 확인하러 바로 이동

                } else { // 폭발 문자열이 만들어지지 않는다면

                    // 폭발 문자열 후보들 첫번째 스택부터 모두 결과값에 찍어주기
                    for (int length : stack) {
                        for (int i = 0; i < length; i++) {
                            sb.append(boomWordArr[i]);
                        }
                    }
                    stack.clear(); // 스택 깔꼼하게 비우기
                }
            }

            // 여기까지 왔을 경우엔 폭발문자열과 상관없는 경우이므로 바로 문자 찍기
            sb.append(ch);
        }

        // 남은 폭발 문자열 후보들 첫번째 스택부터 모두 결과값에 찍어주기
        for (int length : stack) {
            for (int i = 0; i < length; i++) {
                sb.append(boomWordArr[i]);
            }
        }

        System.out.print(sb.length() != 0 ? sb : "FRULA");
    }
}
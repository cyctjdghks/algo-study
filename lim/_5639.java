import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Boj5639 {
    // 이진검색트리
    static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            try {
                int input = Integer.parseInt(br.readLine());
                list.add(input);
            } catch (Exception e) {
                break;
            }
        }
        rec(0, list.size()-1);
    }
    static private void rec(int start, int end) {
        if(end <= start) {
            System.out.println(list.get(start));
            return;
        }
        int cur = list.get(start);
        int newBoundary = end;
        boolean presentBigger = false;
        for(int i = start; i <= end; i++) {
            if(cur < list.get(i)) {
                newBoundary = i-1;
                presentBigger = true;
                break;
            }
        }
        if(start < newBoundary){
            rec(start+1, newBoundary);
        }
        if(presentBigger && newBoundary < end) {
            rec(newBoundary+1, end);
        }
        System.out.println(cur);
    }

}

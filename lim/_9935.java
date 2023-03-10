import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
// 문자열 폭발
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String bomb = br.readLine();
		StringBuilder sb = new StringBuilder();
		
		int strLen = str.length();
		int bombLen = bomb.length();
		
		for(int i = 0; i < strLen; i++) {
			sb.append(str.charAt(i));
			if(bombLen <= sb.length()) {
				boolean boom = true;
				for(int j = 0; j < bombLen; j++) {
					if(bomb.charAt(j) != sb.charAt(sb.length() - bombLen + j)) {
						boom = false;
						break;
					}
				}
				if(boom) {
					sb.delete(sb.length()-bombLen, sb.length());
				}
			}

		}
		
		if(sb.length() == 0 ) {
			System.out.println("FRULA");
		} else {
			System.out.println(sb);
		}


	}
}

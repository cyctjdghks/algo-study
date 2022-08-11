import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
// 나이순 정렬
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<User> users = new ArrayList<>();
		StringTokenizer st;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			users.add(new User(Integer.parseInt(st.nextToken()), st.nextToken()));
		}
		users.sort(new Comparator<User>() {
			@Override
			public int compare(User o1, User o2) {
				return o1.age - o2.age;
			}
		});
		for(User u : users) {
			System.out.println(u.age + " " + u.name);
		}
	}
}
	class User {
		int age;
		String name;

		public User(int age, String name) {
			this.age = age;
			this.name = name;
		}
}
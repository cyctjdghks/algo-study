
public class sam {

	public static void main(String[] args) {
		int a = 1234;
//		a = (a % 1000) * 10 + a/1000;
		a = (a % 10) * 1000 + a/10;
		System.out.println(a);
	}

}

package algorithm.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_13172 {
	static int X = 1000000007; // 모듈러
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		long sum = 0;
		String strArr[] = null;
		for(int i=0; i<M; i++) {
			strArr = br.readLine().split(" ");
			int Ni = Integer.parseInt(strArr[0]);
			int Si = Integer.parseInt(strArr[1]);
			// Ni와 Si의 최대 공약수 구해 나눠줌 => Si/Ni를 기약분수로 만듦.
			int gcdNum = gcd(Si, Ni);
			Ni /= gcdNum;
			Si /= gcdNum;
			// 모듈러 연산에 대한 b^-1 구함.
			// 페르마의 소정리
			// b^(X-1) = 1 (mod X)
			// b * b^(X-2) = 1 (mod X)
			// b^(X-2) = 1 (mod X)
			long bn = power(Ni, X-2);
			sum += ((long)Si)* bn % X;
			// "모든 주사위를 한 번씩 던졌을 때 나온 숫자들의 합의 기댓값"을 모듈러 상에 두기 위해
			// 합산한 값에 계속 모듈러 연산 함.
			sum %= X;
		}
		System.out.println(sum);
	}
    // 최대공약수 구하는 함수
	public static int gcd(int p, int q) {
		if (q==0) return p;
		return gcd(q, p%q);
	}
	// 페르마의 소정리 위해 제곱 구하는 함수
	public static long power(long l, int i) {
		if(i == 0) return 1;
		long half = power(l, i/2);
		long whole = half * half % X;
		return i % 2 == 0 ? whole : whole * l % X; // 지수가 홀수면 한 번 더 곱함.
	}
}

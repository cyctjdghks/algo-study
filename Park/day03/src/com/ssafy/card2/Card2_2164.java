package com.ssafy.card2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Card2_2164 {
/*
 
 6
 
 */
	public static void main(String[] args) {
		// N장의 카드
		// 각각의 카드는 1~N까지 붙어있음
		// 1번이 제일 위에 N번이 제일 아래
		// 제일 위에 카드를 버림
		// 그 다음, 제일 위의 카드를 제일 아래로
		// 카드가 1장 남을때까지 반복
		
		Scanner sc = new Scanner(System.in);
		int N = 0;
		List<Integer> card = new ArrayList<Integer>();
//		int num_get = 0;
		
		N = sc.nextInt();
		for(int i = 1; i <= N ; i++) {
			card.add(i);
		}
		// 리스트 확인
//		for(int i = 0; i < card.size(); i++) {
//			System.out.print(card.get(i));
//		}
		
		// 제일 위에 카드를 버림
		// 그 다음, 제일 위의 카드를 제일 아래로
		// 카드가 1장 남을때까지 반복
		while(true) {
//			card.remove(0);
//			num_get = card.get(0);
//			card.remove(0);
//			card.add(num_get);
			card.remove(0);
			card.add(card.remove(0));
			
			if(card.size() == 1) {
				break;
			}
		}
		
		System.out.println(card.get(0));
		sc.close();
	}

}

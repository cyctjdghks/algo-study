package com.ssafy.card2;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Card2_2_2164 {
	
	public static void main(String[] args) {
		// N장의 카드
		// 각각의 카드는 1~N까지 붙어있음
		// 1번이 제일 위에 N번이 제일 아래
		// 제일 위에 카드를 버림
		// 그 다음, 제일 위의 카드를 제일 아래로
		// 카드가 1장 남을때까지 반복
		
		Scanner sc = new Scanner(System.in);
		int N = 0;
		// LinkedList 사용
		// 배열에서 자주 삽입, 삭제가 이루어지는 경우 용이하여 ArrayList보다 선호됨
		List<Integer> card = new LinkedList<Integer>();
		
		N = sc.nextInt();
		for(int i = 1; i <= N ; i++) {
			card.add(i);
		}
		
		// Queue 자료구조
		// FIFO
		while(card.size() > 1) {
			card.remove(0);
			card.add(card.remove(0));
		}
		
		System.out.println(card.get(0));
		sc.close();
	}
	
}

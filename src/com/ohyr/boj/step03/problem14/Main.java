package com.ohyr.boj.step03.problem14;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		
		int answer = 0;
		int cur = n;
		do {
			int a = cur/10;
			int b = cur%10;
			cur = b*10 + (a+b)%10;
			answer++;
		}while(cur != n);
		System.out.println(answer);
	}

}

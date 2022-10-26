package com.ohyr.boj.step07.problem02;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		String ns = sc.next();
		sc.close();
		
		int sum = 0;
		for(int i=0;i<n;i++) {
			sum += ns.charAt(i)-'0';
		}
		System.out.println(sum);
	}

}

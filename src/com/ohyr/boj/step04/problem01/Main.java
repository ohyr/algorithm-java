package com.ohyr.boj.step04.problem01;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int min = 1000000;
		int max = -1000000;
		
		for(int i=0;i<n;i++) {
			int k = sc.nextInt();
			max = Math.max(max, k);
			min = Math.min(min, k);
		}
		
		System.out.println(min + " " + max);
		sc.close();
	}

}

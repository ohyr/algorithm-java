package com.ohyr.boj.step4.problem02;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = 1;
		int max = 1;
		for(int i=1;i<=9;i++) {
			int k = sc.nextInt();
			if(max < k) {
				num = i;
				max = k;
			}
		}
		System.out.println(max);
		System.out.println(num);
		
		sc.close();
	}

}

package com.ohyr.boj.step4.problem03;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		sc.close();
		
		int n = a*b*c;
		
		int[] used = new int[10];
		
		while(n > 0) {
			used[n%10]++;
			n /= 10;
		}
		
		for(int i=0;i<10;i++) {
			System.out.println(used[i]);
		}
	}

}

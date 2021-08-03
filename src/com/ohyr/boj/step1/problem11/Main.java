package com.ohyr.boj.step1.problem11;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		int x = a*(b/100);
		int y = a*(b/10%10);
		int z = a*(b%10);
		System.out.println(z);
		System.out.println(y);
		System.out.println(x);
		System.out.println(x*100 + y*10 + z);
		
		sc.close();
	}

}

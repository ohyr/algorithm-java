package com.ohyr.boj.step7.problem07;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String A = sc.next();
		String B = sc.next();
		sc.close();
		
		StringBuffer sbA = new StringBuffer(A);
		StringBuffer sbB = new StringBuffer(B);
		
		int a = Integer.parseInt(sbA.reverse().toString());
		int b = Integer.parseInt(sbB.reverse().toString());
		
		if(a < b) {
			a = b;
		}
		System.out.println(a);
		
	}

}

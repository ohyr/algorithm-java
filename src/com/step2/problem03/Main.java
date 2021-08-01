package com.step2.problem03;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int year = sc.nextInt();
		sc.close();

		if(year%4 == 0) {
			if(year%100 != 0 || year%400 == 0) {
				System.out.println(1);
				return;
			}
		}
		System.out.println(0);
	}

}

package com.step2.problem05;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt();
		int m = sc.nextInt();
		sc.close();
		
		if((m - 45) < 0) {
			h = (h+23)%24;
			m += 15;
		}else {
			m -= 45;
		}
		System.out.println(h + " " + m);
	}

}

package com.ohyr.boj.step2.problem04;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		sc.close();
		
		int answer = 0;
		if(x>0 && y>0) {
			answer = 1;
		}else if(x<0 && y>0) {
			answer = 2;
		}else if(x<0 && y<0) {
			answer = 3;
		}else if(x>0 && y<0) {
			answer = 4;
		}
		System.out.println(answer);
	}

}

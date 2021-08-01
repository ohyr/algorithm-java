package com.step6.problem03;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		sc.close();
		
		int answer = 0;
		
		for(int i=1;i<=n;i++) {
			if(i < 100) {
				answer++;
			}else {
				int a = i/100;
				int b = i/10%10;
				int c = i%10;
				if((a-b) == (b-c)) {
					answer++;
				}
			}
		}
		System.out.println(answer);
	}

}

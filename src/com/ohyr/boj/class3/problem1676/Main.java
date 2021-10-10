package com.ohyr.boj.class3.problem1676;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		sc.close();
		
		int answer = 0;
		for(int i=5;i<=n;i += 5) {
			int k = i/5;
			answer++;

			while(k > 0) {
				if(k%5 == 0) {
					answer++;
				}else {
					break;
				}
				k /= 5;
			}
		}
		System.out.println(answer);
	}

}

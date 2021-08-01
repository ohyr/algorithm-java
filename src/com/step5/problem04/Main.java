package com.step5.problem04;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] used = new int[42];
		
		for(int i=0;i<10;i++) {
			int k = sc.nextInt();
			used[k%42] = 1;
		}
		
		int answer = 0;
		for(int i=0;i<42;i++) {
			if(used[i] == 1) {
				answer++;
			}
		}
		
		System.out.println(answer);
		sc.close();
	}

}

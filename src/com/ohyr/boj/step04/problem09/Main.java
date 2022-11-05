package com.ohyr.boj.step04.problem09;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=0;tc<T;tc++) {
			int n = sc.nextInt();
			
			int[] scores = new int[n];
			int sum = 0;
			for(int i=0;i<n;i++) {
				int k = sc.nextInt();
				scores[i] = k;
				sum += scores[i];
			}
			
			double avg = (double)sum/n;
			int stu = 0;
			for(int i=0;i<n;i++) {
				if(avg < scores[i]) {
					stu++;
				}
			}
			System.out.printf("%.3f%%%n", (double)stu*100/n);
		}
		sc.close();
	}

}

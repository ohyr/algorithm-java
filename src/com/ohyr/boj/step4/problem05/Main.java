package com.ohyr.boj.step4.problem05;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		double[] scores = new double[n];
		
		int max = 0;
		for(int i=0;i<n;i++) {
			int k = sc.nextInt();
			scores[i] = k;
			max = Math.max(max, k);
		}
		
		double sum = 0;
		for(int i=0;i<n;i++) {
			scores[i] = scores[i]/max*100;
			sum += scores[i];
		}
		
		System.out.println(sum/n);
		sc.close();
	}

}

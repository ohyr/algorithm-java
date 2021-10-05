package com.ohyr.boj.class3.problem1389;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[][] friend = new int[n+1][n+1];
		for(int i=0;i<n+1;i++) {
			for(int j=0;j<n+1;j++) {
				if(i == j) friend[i][j] = 0;
				else friend[i][j] = 100;
			}
		}
		
		for(int i=0;i<m;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			friend[a][b] = 1;
			friend[b][a] = 1;
		}
		sc.close();
		
		for(int k=1;k<=n;k++) {
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
					if(friend[i][j] > friend[i][k] + friend[k][j]) {
						friend[i][j] = friend[i][k] + friend[k][j];
					}
				}
			}
		}
		
		int min = 100;
		int answer = 1;
		for(int i=1;i<=n;i++) {
			int sum = 0;
			for(int j=1;j<=n;j++) {
				sum += friend[i][j];
			}
			if(min > sum) {
				min = sum;
				answer = i;
			}
		}
		System.out.println(answer);
	}

}

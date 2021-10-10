package com.ohyr.boj.class3.problem1780;

import java.util.Scanner;

public class Main {
	static int[] paperNum = new int[3];
	
	static void checkPaper(int n, int[][] paper, int x, int y) {
		int init = paper[x][y];
		
		boolean isPerfect = true;
		
		for(int i=x;i<x+n;i++) {
			for(int j=y;j<y+n;j++) {
				if(init != paper[i][j]) {
					isPerfect = false;
					break;
				}
			}
			if(isPerfect == false) break;
		}

		if(isPerfect) {
			paperNum[init+1]++;
			return;
		}else {
			n /= 3;
			for(int i=0;i<3;i++) {
				for(int j=0;j<3;j++) {
					checkPaper(n, paper, x+i*n, y+j*n);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[][] paper = new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				paper[i][j] = sc.nextInt();
			}
		}
		sc.close();
		
		checkPaper(n, paper, 0, 0);
		
		for(int answer: paperNum) {
			System.out.println(answer);
		}
	}

}

package com.ohyr.boj.class3.problem1003;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] zn = new int[41];
		int[] on = new int[41];
		
		zn[0] = 1;
		on[0] = 0;
		zn[1] = 0;
		on[1] = 1;
		
		for(int i=2;i<=40;i++) {
			zn[i] = zn[i-1] + zn[i-2];
			on[i] = on[i-1] + on[i-2];
		}
		
		int T = sc.nextInt();
		
		for(int tc=1;tc<=T;tc++) {
			int n = sc.nextInt();	
			System.out.println(zn[n] + " " + on[n]);
		}
		sc.close();
	}

}

package com.ohyr.boj.class3.problem1107;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		boolean[] broken = new boolean[10];
		
		for(int i=0;i<m;i++) {
			int k = sc.nextInt();
			broken[k] = true;
		}
		sc.close();
		
		int pure = Math.abs(n - 100);
		int min = Math.min(Integer.MAX_VALUE, pure);
		
		for(int i=0;i<1000000;i++) {
			String cur = Integer.toString(i);
			
			boolean invalid = false;
			for(int j=0;j<cur.length();j++) {
				if(broken[cur.charAt(j)-'0']) {
					invalid = true;
					break;
				}
			}
			if(invalid) continue;
			
			min = Math.min(min, Math.abs(i-n) + cur.length());
		}
		
		System.out.println(min);
	}

}

package com.ohyr.boj.step06.problem10;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		int answer = 0;
		
		for(int tc=1;tc<=T;tc++) {
			String str = sc.next();
			
			int[] alpha = new int[26];
			
			int al = str.charAt(0)-'a';
			alpha[al] = 1;
			int prev = al;
			boolean isGroup = true;
			for(int i=1;i<str.length();i++) {
				al = str.charAt(i)-'a';
				if(prev != al) {
					if(alpha[al] == 1) {
						isGroup = false;
						break;
					}
					alpha[prev] = 1;
				}
				prev = al;
			}
			if(isGroup) answer++;
		}
		System.out.println(answer);
		sc.close();
	}

}

package com.ohyr.boj.step06.problem03;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s = sc.next();
		sc.close();
		
		int[] alpha = new int[26];
		for(int i=0;i<alpha.length;i++) {
			alpha[i] = -1;
		}
		
		for(int i=0;i<s.length();i++) {
			if(alpha[s.charAt(i)-97] != -1) continue;
			alpha[s.charAt(i)-97] = i;
		}
		
		for(int i=0;i<alpha.length;i++) {
			System.out.print(alpha[i] + " ");
		}
	}

}

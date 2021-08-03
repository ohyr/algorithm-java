package com.ohyr.boj.step7.problem05;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s = sc.next();
		sc.close();
		
		s = s.toUpperCase();
		
		int[] used = new int[26];
		
		for(int i=0;i<s.length();i++) {
			used[s.charAt(i)-'A']++;
		}
		
		int max = 0;
		int answer = 0;
		for(int i=0;i<used.length;i++) {
			if(max < used[i]) {
				max = used[i];
				answer = i;
			}
		}
		
		for(int i=0;i<used.length;i++) {
			if(max == used[i]) {
				if(i != answer) {
					answer = '?'-'A';
					break;
				}
			}
		}
		
		System.out.println((char)(answer+65));
	}

}

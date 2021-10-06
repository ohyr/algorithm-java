package com.ohyr.boj.class3.problem1541;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s = sc.next();
		sc.close();
		
		int answer = 0;
		int pm = 0;
		String tmp = "";
		for(int i=0;i<s.length();i++) {
			char c = s.charAt(i);
			if(c == '+' || c == '-') {
				int num = Integer.parseInt(tmp);
				if(pm == 1) num = -num;
				answer += num;
				
				if(c == '-') pm = 1;
				tmp = "";
			}else {
				tmp += c;
			}
		}
		int num = Integer.parseInt(tmp);
		if(pm == 1) num = -num;
		answer += num;
		
		System.out.println(answer);
	}
}

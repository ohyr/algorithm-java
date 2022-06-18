package com.ohyr.boj.step6.problem06;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s = sc.nextLine();
		sc.close();
		
		s = s.trim();

		int cnt = 0;
		boolean once = true;
		
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i) == ' ') {
				once = true;
			}else {
				if(once) {
					cnt++;
					once = false;
				}
			}
		}
		System.out.println(cnt);
	}

}

package com.step7.problem04;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1;tc<=T;tc++) {
			int r = sc.nextInt();
			String s = sc.next();
			
			String p = "";
			
			for(int i=0;i<s.length();i++) {
				for(int j=0;j<r;j++) {
					p += (s.charAt(i));
				}
			}
			System.out.println(p);
		}
		sc.close();
	}

}

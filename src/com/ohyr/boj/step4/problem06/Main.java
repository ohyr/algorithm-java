package com.ohyr.boj.step4.problem06;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1;tc<=T;tc++) {
			String prob = sc.next();
			
			int answer = 0;
			int s = 0;
			for(int i=0;i<prob.length();i++) {
				if(prob.charAt(i) == 'O') {
					answer += ++s;
				}else {
					s = 0;
				}
			}
			System.out.println(answer);
			sc.close();
		}
	}

}

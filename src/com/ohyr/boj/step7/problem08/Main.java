package com.ohyr.boj.step7.problem08;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] alpha = {3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,8,8,8,8,9,9,9,10,10,10,10};
		
		String word = sc.next();
		sc.close();
		
		int sum = 0;
		for(int i=0;i<word.length();i++) {
			sum += alpha[word.charAt(i)-'A'];
		}
		System.out.println(sum);
	}

}

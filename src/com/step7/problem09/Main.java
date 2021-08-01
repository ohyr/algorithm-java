package com.step7.problem09;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String word = sc.next();
		sc.close();
		
		String[] croa = {"c=","c-","dz=","d-","lj","nj","s=","z="};
		
		for(int i=0;i<croa.length;i++) {
			String cr = croa[i];
			word = word.replaceAll(cr, " ");
		}
		
		System.out.println(word.length());
	}

}

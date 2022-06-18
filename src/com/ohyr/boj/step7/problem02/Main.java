package com.ohyr.boj.step7.problem02;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(in.readLine());
		
		int sum = 1;
		for(int i=0;i<=1000000000;i++) {
			sum += 6*i;
			if(sum >= n) {
				System.out.println(i+1);
				break;
			}
		}
	}

}

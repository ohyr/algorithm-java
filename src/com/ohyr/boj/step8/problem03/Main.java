package com.ohyr.boj.step8.problem03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(in.readLine());
		
		int a = 0;
		int b = 0;
		int sum = 0;
		for(int i=1;i<=n;i++) {
			sum += i;
			if(sum >= n) {
				if(i%2 == 0) {
					a = i - (sum-n);
					b = sum - n + 1;
				}else {
					a = sum - n + 1;
					b = i - (sum-n);
				}
				break;
			}
		}
		System.out.println(a+"/"+b);
	}

}

package com.ohyr.boj.class2.problem15829;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int l = Integer.parseInt(in.readLine());
		char[] rL = in.readLine().toCharArray();
		
		long answer = 0;
		long r = 1;
		long m = 1234567891;
		
		for(int i=0;i<l;i++) {
			answer += (rL[i]-'a'+1)*r;
			answer %= m;
			r *= 31;
			r %= m;
		}
		
		System.out.println(answer);
	}

}

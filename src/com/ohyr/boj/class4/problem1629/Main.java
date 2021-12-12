package com.ohyr.boj.class4.problem1629;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static long divAndConq(long a, long b, long c) {
		if(b == 1) {
			return a % c;
		}
		
		long tmp = divAndConq(a, b / 2, c);
		
		if(b % 2 == 1) {
			return (tmp * tmp % c) * a % c;
		}
		
		return tmp * tmp % c;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine());
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		long c = Long.parseLong(st.nextToken());
		
		long answer = divAndConq(a, b, c);
		
		System.out.println(answer);
	}

}

package com.ohyr.boj.step08.problem06;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		boolean[] isPrime = new boolean[10001];
		Arrays.fill(isPrime, true);
		isPrime[0] = false;
		isPrime[1] = false;
		for(int i=2;i<=10000;i++) {
			if(!isPrime[i]) continue;
			for(int j=2;i*j<=10000;j++) {
				isPrime[i*j] = false;
			}
		}
		
		int T = Integer.parseInt(in.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			int n = Integer.parseInt(in.readLine());
			int a = n / 2;
			int b = n / 2;
			while(a > 0 && b < n) {
				if(isPrime[a] && isPrime[b]) {
					sb.append(a).append(" ").append(b).append("\n");
					break;
				}
				a--;
				b++;
			}
		}
		
		System.out.println(sb.toString());
	}

}

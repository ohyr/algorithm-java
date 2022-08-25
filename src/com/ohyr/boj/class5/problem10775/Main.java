package com.ohyr.boj.class5.problem10775;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int g = Integer.parseInt(in.readLine());
		int p = Integer.parseInt(in.readLine());
		
		int answer = 0;
		int[] state = new int[g+1];
		int[] dp = new int[g+1];
		for(int i=1;i<=g;i++) {
			dp[i] = i;
		}
		
		for(int i=1;i<=p;i++) {
			boolean isClosing = true;
			
			int gi = Integer.parseInt(in.readLine());
			int pgi = findParent(gi, dp);
			for(int j=0;j<pgi;j++) {
				dp[pgi-j] = pgi-j-1;
				if(state[pgi-j] == 0) {
					state[pgi-j] = i;
					isClosing = false;
					break;
				}
			}
			
			if(isClosing) {
				break;
			}
			answer++;
		}
		
		System.out.println(answer);
	}
	
	public static int findParent(int x, int[] p) {
		if(x == p[x]) {
			return x;
		}
		return p[x] = findParent(p[x], p);
	}

}

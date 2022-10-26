package com.ohyr.boj.step16.problem08;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static int[] idx;
	public static int Min;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(in.readLine());
		
		int[][] s = new int[n][n];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0;j<n;j++) {
				s[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		idx = new int[n/2];
		Min = Integer.MAX_VALUE;
		comb(0, 0, n, s);
		
		System.out.println(Min);
	}

	private static void comb(int cnt, int start, int n, int[][] s) {
		if(cnt == n/2) {
			boolean[] isStartTeam = new boolean[n];
			for(int i=0;i<n/2;i++) {
				isStartTeam[idx[i]] = true;
			}
			
			int[] link = new int[n/2];
			int linkIdx = 0;
			for(int i=0;i<n;i++) {
				if(!isStartTeam[i]) {
					link[linkIdx++] = i;
				}
			}
			
			int startTeam = 0;
			int linkTeam = 0;
			
			for(int i=0;i<n/2;i++) {
				for(int j=0;j<n/2;j++) {
					startTeam += s[idx[i]][idx[j]];
					linkTeam += s[link[i]][link[j]];
				}
			}
			
			Min = Math.min(Min, Math.abs(startTeam - linkTeam));
			
			return;
		}
		for(int i=start;i<n;i++) {
			idx[cnt] = i;
			comb(cnt+1, i+1, n, s);
		}
	}

}

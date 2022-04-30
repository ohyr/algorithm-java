package com.ohyr.boj.samsung.problem14890;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		
		int[][] field = new int[n][n];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0;j<n;j++) {
				field[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int answer = 0;
		
		// 가로확인
		for(int i=0;i<n;i++) {
			boolean isGood = true;
			boolean[] tmp = new boolean[n];
			for(int j=0;j<n-1;j++) {
				int cur = field[i][j];
				int next = field[i][j+1];
				
				if(cur - next > 1) {
					isGood = false;
					break;
				}else if(cur - next == 1) {
					if(n <= j+l) {
						isGood = false;
						break;
					}
					
					for(int k=j+1;k<=j+l;k++) {
						if(field[i][k] != next) {
							isGood = false;
							break;
						}
						if(tmp[k]) {
							isGood = false;
							break;
						}
						tmp[k] = true;
					}
					if(!isGood) break;
				}
			}
			for(int j=n-1;j>0;j--) {
				int cur = field[i][j];
				int next = field[i][j-1];
				
				if(cur - next > 1) {
					isGood = false;
					break;
				}else if(cur - next == 1) {
					if(j-l < 0) {
						isGood = false;
						break;
					}
					
					for(int k=j-1;k>=j-l;k--) {
						if(field[i][k] != next) {
							isGood = false;
							break;
						}
						if(tmp[k]) {
							isGood = false;
							break;
						}
						tmp[k] = true;
					}
					if(!isGood) break;
				}
			}
			
			if(isGood) answer++;
		}
		
		// 세로확인
		for(int i=0;i<n;i++) {
			boolean isGood = true;
			boolean[] tmp = new boolean[n];
			for(int j=0;j<n-1;j++) {
				int cur = field[j][i];
				int next = field[j+1][i];
				
				if(cur - next > 1) {
					isGood = false;
					break;
				}else if(cur - next == 1) {
					if(n <= j+l) {
						isGood = false;
						break;
					}
					
					for(int k=j+1;k<=j+l;k++) {
						if(field[k][i] != next) {
							isGood = false;
							break;
						}
						if(tmp[k]) {
							isGood = false;
							break;
						}
						tmp[k] = true;
					}
					if(!isGood) break;
				}
			}
			for(int j=n-1;j>0;j--) {
				int cur = field[j][i];
				int next = field[j-1][i];
				
				if(cur - next > 1) {
					isGood = false;
					break;
				}else if(cur - next == 1) {
					if(j-l < 0) {
						isGood = false;
						break;
					}
					
					for(int k=j-1;k>=j-l;k--) {
						if(field[k][i] != next) {
							isGood = false;
							break;
						}
						if(tmp[k]) {
							isGood = false;
							break;
						}
						tmp[k] = true;
					}
					if(!isGood) break;
				}
			}
			
			if(isGood) answer++;
		}
		
		System.out.println(answer);
	}

}

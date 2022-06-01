package com.ohyr.boj.samsung.problem15686;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
public static int[] idx;
	
	private static void combination(int cnt, int start, int n, int r, List<int[]> list) {
		if(cnt == r) {
			int[] tmp = idx.clone();
			list.add(tmp);
			return;
		}
		for(int i=start;i<n;i++) {
			idx[cnt] = i;
			combination(cnt+1, i+1, n, r, list);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] city = new int[n][n];
		List<int[]> chicken = new LinkedList<>();
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0;j<n;j++) {
				city[i][j] = Integer.parseInt(st.nextToken());
				if(city[i][j] == 2) chicken.add(new int[] {i,j});
			}
		}
		
		int answer = Integer.MAX_VALUE;
		
		List<int[]> comList = new LinkedList<>();
		idx = new int[m];
		combination(0,0,chicken.size(),m,comList);
		
		for(int[] com : comList) {
			int sum = 0;
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(city[i][j] == 1) {
						int min = Integer.MAX_VALUE;
						for(int k=0;k<m;k++) {
							int curLen = Math.abs(i-chicken.get(com[k])[0]) + Math.abs(j-chicken.get(com[k])[1]);
							min = Math.min(min, curLen);
						}
						sum += min;
					}
				}
			}
			
			answer = Math.min(answer, sum);
		}
		
		System.out.println(answer);
	}

}

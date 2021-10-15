package com.ohyr.boj.class3.problem2606;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(in.readLine());
		int m = Integer.parseInt(in.readLine());
		
		int[][] web = new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(i==j)continue;
				web[i][j] = 101;
			}
		}
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			web[x-1][y-1] = 1;
			web[y-1][x-1] = 1;
		}
		
		for(int k=0;k<n;k++) {
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(web[i][j] > web[i][k] + web[k][j]) {
						web[i][j] = web[i][k] + web[k][j];
					}
				}
			}
		}
		
		int answer = 0;
		for(int i=1;i<n;i++) {
			if(web[0][i] != 101) answer++;
		}
		
		System.out.println(answer);
	}
	// 플로이드 와샬 15분 걸림.. 근데 맞는 풀이는 아닌듯 ㅋㅋㅋ
}

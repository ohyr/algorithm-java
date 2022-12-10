package com.ohyr.boj.step18.problem06;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[][] board = new int[n][m];
		for(int i=0;i<n;i++) {
			char[] rL = in.readLine().toCharArray();
			for(int j=0;j<m;j++) {
				board[i][j] = rL[j] == 'B' ? 0 : 1;
			}
		}
		
		int[][] bw = new int[n][m];
		int[][] wb = new int[n][m];
		int r = 0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(board[i][j] != r) {
					bw[i][j] = 1;
				}else {
					wb[i][j] = 1;
				}
				r = (r + 1) % 2;
			}
			r = (r + (m + 1) % 2) % 2;
		}
		
		int[][] bwSum = new int[n+1][m+1];
		int[][] wbSum = new int[n+1][m+1];
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				bwSum[i][j] += bw[i-1][j-1] + bwSum[i-1][j] + bwSum[i][j-1] - bwSum[i-1][j-1];
				wbSum[i][j] += wb[i-1][j-1] + wbSum[i-1][j] + wbSum[i][j-1] - wbSum[i-1][j-1];
			}
		}
		
		int answer = Integer.MAX_VALUE;
		for(int i=0;i<=n-k;i++) {
			for(int j=0;j<=m-k;j++) {
				int bwCur = bwSum[i+k][j+k] - bwSum[i+k][j] - bwSum[i][j+k] + bwSum[i][j];
				int wbCur = wbSum[i+k][j+k] - wbSum[i+k][j] - wbSum[i][j+k] + wbSum[i][j];
				answer = Math.min(answer, Math.min(bwCur, wbCur));
			}
		}
		System.out.println(answer);
	}

}

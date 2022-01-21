package com.ohyr.boj.class4.problem9663;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static int Answer;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		// 인덱스가 행
		// 값이 열
		int[] queen = new int[N];
		
		Answer = 0;
		
		dfs(0, N, queen);
		
		System.out.println(Answer);
	}

	private static void dfs(int row, int N, int[] queen) {
		if(row == N) { // 마지막 행까지 돌았으면
			Answer++;
			return;
		}
		
		// 0부터 N-1까지 놓아보기
		for(int i=0;i<N;i++) {
			queen[row] = i; // i열에 놓기
			if(isAvailable(row, queen)) { // 가능하면 다음 행
				dfs(row+1, N, queen);
			}
		}
	}

	private static boolean isAvailable(int row, int[] queen) {
		for(int i=0;i<row;i++) { // 이전에 놓았던 퀸과 겹치는지 확인
			if(queen[row] == queen[i] || Math.abs(queen[row] - queen[i]) == row - i) return false;
		}
		return true;
	}
}

package com.ohyr.boj.step16.problem06;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static boolean isFin;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int[][] sudoku = new int[9][9];
		for(int i=0;i<9;i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0;j<9;j++) {
				sudoku[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 처음으로 끝났는지 확인하는 isFin
		isFin = false;
		dfs(0, sudoku);
		
		// 값 출력
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				sb.append(sudoku[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void dfs(int cnt, int[][] sudoku) {
		if(cnt == 81) {
			// 처음으로 끝남
			isFin = true;
			return;
		}
		
		// 이미 해당 위치에 값이 있다면 다음 위치 보기
		if(sudoku[cnt/9][cnt%9] != 0) {
			dfs(cnt+1, sudoku);
			return;
		}
		
		// 1~9까지 시도
		for(int tryNum=1;tryNum<=9;tryNum++) {
			// 지금 당장 놓을 수 있는지 확인
			if(!isAvailable(cnt/9, cnt%9, sudoku, tryNum)) continue;
			
			// 놓을 수 있다면 놓고
			sudoku[cnt/9][cnt%9] = tryNum;
			
			// 다음 값을 탐색
			dfs(cnt+1, sudoku);
			
			// 이미 첫번째로 끝났으면 return
			if(isFin) return;
			
			sudoku[cnt/9][cnt%9] = 0;
		}
	}

	private static boolean isAvailable(int x, int y, int[][] sudoku, int tryNum) {
		
		// 가로 세로 체크
		for(int i=0;i<9;i++) {
			if(sudoku[x][i] == tryNum) return false;
			if(sudoku[i][y] == tryNum) return false;
		}
		
		// 3x3 사각형 체크
		for(int i=x-x%3;i<x-x%3+3;i++) {
			for(int j=y-y%3;j<y-y%3+3;j++) {
				if(sudoku[i][j] == tryNum) return false;
			}
		}
		
		return true;
	}

}

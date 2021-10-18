package com.ohyr.boj.class3.problem2667;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	public static int[][] Deltas = {{1,0},{0,1},{-1,0},{0,-1}};
	public static int Cnt;
	
	private static void checkHouse(int x, int y, int[][] map) {
		for(int d=0;d<4;d++) {
			int new_x = x + Deltas[d][0];
			int new_y = y + Deltas[d][1];
			
			if(new_x < 0 || map.length <= new_x || 
					new_y < 0 || map.length <= new_y) continue;
			
			if(map[new_x][new_y] == 0) continue;
			
			map[new_x][new_y] = 0;
			Cnt++;
			
			checkHouse(new_x, new_y, map);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(in.readLine());
		
		int[][] map = new int[n][n];
		
		for(int i=0;i<n;i++) {
			char[] rL = in.readLine().toCharArray();
			for(int j=0;j<n;j++) {
				map[i][j] = rL[j] - '0';
			}
		}
		
		int groupNum = 0;
		List<Integer> houseNum = new ArrayList<>();
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(map[i][j] == 1) {
					groupNum++;
					map[i][j] = 0;
					Cnt = 1;
					checkHouse(i, j, map);
					houseNum.add(Cnt);
				}
			}
		}
		
		System.out.println(groupNum);

		Collections.sort(houseNum);
		for(int h : houseNum) {
			System.out.println(h);
		}
	}

}
// 25분
package com.ohyr.boj.step14.problem04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int k = Integer.parseInt(in.readLine());
		
		int[][] input = new int[6][2];
		int[][] lenMap = new int[5][4];
		
		for(int i=0;i<6;i++) {
			st = new StringTokenizer(in.readLine());
			int direction = Integer.parseInt(st.nextToken());
			int len = Integer.parseInt(st.nextToken());
			
			input[i] = new int[] {direction,len};
			
			if(lenMap[direction][0] == 0) {
				lenMap[direction][0] = len;
				lenMap[direction][2] = i;
			}else {
				lenMap[direction][1] = len;
				lenMap[direction][3] = i;
			}
		}
		
		int big = 1;
		int small = 1;

		int[] wh = new int[2];
		int whIdx = 0;
		
		for(int i=1;i<=4;i++) {
			if(lenMap[i][1] == 0) {
				big *= lenMap[i][0];
				wh[whIdx++] = i;
			}
		}
		
		if(wh[0] == 1 && wh[1] == 4) {
			int wIdx = (lenMap[4][2] + 2)%6;
			int hIdx = (lenMap[4][2] + 3)%6;
			small = input[wIdx][1] * input[hIdx][1];
		}else if(wh[0] == 2 && wh[1] == 3) {
			int wIdx = (lenMap[3][2] + 2)%6;
			int hIdx = (lenMap[3][2] + 3)%6;
			small = input[wIdx][1] * input[hIdx][1];
		}else if(wh[0] == 2 && wh[1] == 4) {
			int wIdx = (lenMap[2][2] + 2)%6;
			int hIdx = (lenMap[2][2] + 3)%6;
			small = input[wIdx][1] * input[hIdx][1];
		}else if(wh[0] == 1 && wh[1] == 3) {
			int wIdx = (lenMap[1][2] + 2)%6;
			int hIdx = (lenMap[1][2] + 3)%6;
			small = input[wIdx][1] * input[hIdx][1];
		}
		
		System.out.println((big-small)*k);
	}

}

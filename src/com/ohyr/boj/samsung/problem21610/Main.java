package com.ohyr.boj.samsung.problem21610;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static int[][] deltas = {
		{0, -1},{-1, -1},{-1, 0},{-1, 1},
		{0, 1},{1, 1},{1, 0},{1, -1},
	};
	
	public static int[][] deltas2 = {
		{-1, -1}, {-1, 1}, {1, 1}, {1, -1},
	};
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] A = new int[n][n];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0;j<n;j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		List<int[]> cList = new ArrayList<>();
		cList.add(new int[] {n-1, 0});
		cList.add(new int[] {n-1, 1});
		cList.add(new int[] {n-2, 0});
		cList.add(new int[] {n-2, 1});
		
		for(int tc=0;tc<m;tc++) {
			st = new StringTokenizer(in.readLine());
			int d = Integer.parseInt(st.nextToken()) - 1;
			int s = Integer.parseInt(st.nextToken());
			
			List<int[]> tmpList = new ArrayList<>();
			
			// 1. 이동
			// 2. 1 더하고
			// 3. 구름이 사라진 위치 저장
			for(int i=0;i<cList.size();i++) {
				int[] cur = cList.get(i);
				int x = (cur[0] + deltas[d][0] * s + 50 * n) % n;
				int y = (cur[1] + deltas[d][1] * s + 50 * n) % n;
				
				A[x][y] += 1;
				tmpList.add(new int[] {x, y});
			}
			
			// 4. 물복사버그
			for(int i=0;i<tmpList.size();i++) {
				int[] cur = tmpList.get(i);
				int cnt = 0;
				for(int dr=0;dr<4;dr++) {
					int x = cur[0] + deltas2[dr][0];
					int y = cur[1] + deltas2[dr][1];
					
					if(x < 0 || n <= x || y < 0 || n <= y) continue;
					if(A[x][y] > 0) {
						cnt++;
					}
				}
				A[cur[0]][cur[1]] += cnt;
			}
			
			// 5. 새 구름 생성
			cList = new ArrayList<>();
			
			boolean[][] checked = new boolean[n][n];
			for(int i=0;i<tmpList.size();i++) {
				int[] cur = tmpList.get(i);
				checked[cur[0]][cur[1]] = true;
			}
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(checked[i][j]) continue;
					if(A[i][j] >= 2) {
						A[i][j] -= 2;
						cList.add(new int[] {i, j});
					}
				}
			}
			
		}
		
		// 바구니에 들어있는 물의 양의 합
		int answer = 0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				answer += A[i][j];
			}
		}
		System.out.println(answer);
	}

}

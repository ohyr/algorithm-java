package com.ohyr.boj.step33.problem06;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] world = new int[n][m];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0;j<m;j++) {
				world[i][j] = -Integer.parseInt(st.nextToken());
			}
		}
		
		// 섬 번호 매기기
		int isN = 0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(world[i][j] == -1) {
					markIsn(i, j, ++isN, n, m, world);
				}
			}
		}
		
		// 각 섬 사이의 거리의 최솟값 구하기
		List<int[]> list = new LinkedList<>();
		makeIsMinLen(list, n, m, world);
		
		// MST 찾기
		Collections.sort(list, (a, b) -> (a[2] - b[2]));
		
		int[] p = new int[7];
		for(int i=0;i<7;i++) {
			p[i] = i;
		}
		
		int answer = 0;
		int bridgeCnt = 0;
		
		for(int i=0;i<list.size();i++) {
			int a = list.get(i)[0];
			int b = list.get(i)[1];
			
			int pa = findParent(a, p);
			int pb = findParent(b, p);
			
			if(pa != pb) {
				answer += list.get(i)[2];
				bridgeCnt++;
				
				if(pa < pb) p[pb] = pa;
				else p[pa] = pb;
			}
		}
		
		if(bridgeCnt != isN-1) answer = -1;
		
		System.out.println(answer);
	}
	
	private static int findParent(int x, int[] p) {
		if(p[x] == x) return x;
		return p[x] = findParent(p[x], p);
	}

	private static void makeIsMinLen(List<int[]> list, int n, int m, int[][] world) {
		for(int i=0;i<n;i++) {
			int from = 0;
			int bridgeLen = 0;
			for(int j=0;j<m;j++) {
				if(world[i][j] != 0) {
					if(from != 0 && bridgeLen > 1) {
						list.add(new int[] {from, world[i][j], bridgeLen});
					}
					from = world[i][j];
					bridgeLen = 0;
				}else {
					bridgeLen++;
				}
			}
		}
		
		for(int j=0;j<m;j++) {
			int from = 0;
			int bridgeLen = 0;
			for(int i=0;i<n;i++) {
				if(world[i][j] != 0) {
					if(from != 0 && bridgeLen > 1) {
						list.add(new int[] {from, world[i][j], bridgeLen});
					}
					from = world[i][j];
					bridgeLen = 0;
				}else {
					bridgeLen++;
				}
			}
		}
	}

	private static void markIsn(int x, int y, int isn, int n, int m, int[][] world) {
		if(x < 0 || n <= x || y < 0 || m <= y) return;
		if(world[x][y] == 0) return;
		if(world[x][y] == isn) return;
		
		world[x][y] = isn;
		
		markIsn(x, y+1, isn, n, m, world);
		markIsn(x+1, y, isn, n, m, world);
		markIsn(x, y-1, isn, n, m, world);
		markIsn(x-1, y, isn, n, m, world);
	}

}

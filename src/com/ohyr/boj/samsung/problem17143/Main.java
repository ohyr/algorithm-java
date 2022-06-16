package com.ohyr.boj.samsung.problem17143;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		Shark[][] sea = new Shark[r][c];
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			
			sea[x][y] = new Shark(s, d, z);
		}
		
		int answer = 0;
		
		// 1. move fishing king
		for(int king=0;king<c;king++) {
			// 2. catch shark
			for(int i=0;i<r;i++) {
				if(sea[i][king] != null) {
					answer += sea[i][king].z;
					sea[i][king] = null;
					break;
				}
			}
			
			// 3. move shark
			sea = moveShark(r, c, sea);
		}
		
		System.out.println(answer);
	}

	private static Shark[][] moveShark(int r, int c, Shark[][] sea) {
		Shark[][] rst = new Shark[r][c];
		
		int[][] deltas = {{},{-1,0},{1,0},{0,1},{0,-1}};
		
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(sea[i][j] != null) {
					Shark shark = sea[i][j];
					int spd = shark.s;
					int dir = shark.d;
					int size = shark.z;
					
					// 속도 상승!!
					if(dir == 3 || dir == 4) spd = spd % (2*c - 2);
					else if(dir == 1 || dir == 2) spd = spd % (2*r - 2);
					
					int x = i;
					int y = j;
					while(spd > 0) {
						x += deltas[dir][0];
						y += deltas[dir][1];
						
						if(x < 0 || r <= x || y < 0 || c <= y) {
							x -= deltas[dir][0];
							y -= deltas[dir][1];
							
							if(dir == 1) dir = 2;
							else if(dir == 2) dir = 1;
							else if(dir == 3) dir = 4;
							else if(dir == 4) dir = 3;
							
							continue;
						}
						
						spd--;
					}
					
					if(rst[x][y] != null) {
						if(rst[x][y].z > size) continue;
					}
					
					rst[x][y] = new Shark(shark.s, dir, size);
				}
			}
		}
		
		return rst;
	}

	static class Shark {
		int s;
		int d;
		int z;
		Shark(int s, int d, int z){
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}
}

package com.ohyr.boj.class3.problem1074;

import java.util.Scanner;

public class MainOld {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int r = sc.nextInt();
		int c = sc.nextInt();
		sc.close();
		
		int[][]deltas = {{0,1},{1,0},{1,1}};
		
		int size = 1 << n;
		
		int[][] Z = new int[size][size];
		
		int num = 0;
		for(int z=1;z<=n;z++) {
			int zz = 1 << z-1;
			for(int i=0;i<zz;i++) {
				for(int j=0;j<zz;j++) {
					num = Z[i][j];
					for(int d=0;d<3;d++) {
						int x = i + deltas[d][0]*zz;
						int y = j + deltas[d][1]*zz;
						
						num += (int) Math.pow(4, z-1);
						Z[x][y] = num;
					}
				}
			}
		}
		
		System.out.println(Z[r][c]);
	}

}

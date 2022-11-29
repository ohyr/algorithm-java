package com.ohyr.boj.step33.problem03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(in.readLine());
		double[][] star = new double[n][2];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(in.readLine());
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			
			star[i][0] = x;
			star[i][1] = y;
		}
		
		double[][] e = new double[n*n][3];
		for(int i=0;i<n*n;i++) {
			int a = i / n;
			int b = i % n;
			double c = Math.sqrt(Math.pow(star[a][0] - star[b][0], 2) + Math.pow(star[a][1] - star[b][1], 2));
			
			e[i][0] = a;
			e[i][1] = b;
			e[i][2] = c;
		}
		Arrays.sort(e, (a, b) -> a[2] < b[2] ? -1 : 1);
		
		int[] p = new int[n];
		for(int i=0;i<n;i++) {
			p[i] = i;
		}
		
		double answer = 0;
		
		for(int i=0;i<n*n;i++) {
			int a = (int) e[i][0];
			int b = (int) e[i][1];
			double c = e[i][2];
			
			int pa = findParent(a, p);
			int pb = findParent(b, p);
			
			if(pa != pb) {
				p[pa] = Math.min(pa, pb);
				p[pb] = Math.min(pa, pb);
				
				answer += c;
			}
		}
		
		System.out.println(answer);
	}

	public static int findParent(int x, int[] p) {
		if(p[x] == x) {
			return x;
		}
		return p[x] = findParent(p[x], p);
	}
}

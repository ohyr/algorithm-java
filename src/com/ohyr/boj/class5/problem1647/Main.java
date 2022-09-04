package com.ohyr.boj.class5.problem1647;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] p = new int[n+1];
		for(int i=0;i<=n;i++) {
			p[i] = i;
		}
		
		int[][] v = new int[m][3];
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			v[i][0] = a;
			v[i][1] = b;
			v[i][2] = c;
		}
		Arrays.sort(v, (a, b) -> a[2] - b[2]);
		
		int answer = 0;
		int last = 0;
		
		for(int i=0;i<m;i++) {
			int a = v[i][0];
			int b = v[i][1];
			int c = v[i][2];
			
			int pa = findParent(a, p);
			int pb = findParent(b, p);
			
			if(pa != pb) {
				p[pa] = Math.min(pa, pb);
				p[pb] = Math.min(pa, pb);
				
				answer += c;
				last = c;
			}
		}
		
		System.out.println(answer - last);
	}
	
	public static int findParent(int x, int[] p) {
		if(p[x] == x) {
			return x;
		}
		return p[x] = findParent(p[x], p);
	}

}

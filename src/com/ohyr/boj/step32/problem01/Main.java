package com.ohyr.boj.step32.problem01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] p = new int[n+1];
		for(int i=1;i<=n;i++) {
			p[i] = i;
		}
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(in.readLine());
			int cmd = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			int pa = findParent(a, p);
			int pb = findParent(b, p);
			
			switch(cmd) {
			case 0:
				p[pa] = Math.min(pa, pb);
				p[pb] = Math.min(pa, pb);
				break;
			case 1:
				sb.append(pa == pb ? "YES" : "NO").append("\n");
				break;
			}
		}
		
		System.out.println(sb.toString());
	}

	public static int findParent(int n, int[] p) {
		if(p[n] == n) {
			return n;
		}
		return p[n] = findParent(p[n], p);
	}
}

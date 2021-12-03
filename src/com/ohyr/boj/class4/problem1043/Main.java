package com.ohyr.boj.class4.problem1043;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	private static int findParent(int x, int[] p) {
		if(x == p[x]) {
			return x;
		}
		return findParent(p[x], p);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] p = new int[n+1];
		for(int i=1;i<=n;i++) {
			p[i] = i;
		}
		
		st = new StringTokenizer(in.readLine());
		int k = Integer.parseInt(st.nextToken());
		for(int i=0;i<k;i++) {
			int person = Integer.parseInt(st.nextToken());
			p[person] = 0;
		}
		
		ArrayList<ArrayList<Integer>> party = new ArrayList<ArrayList<Integer>>();
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(in.readLine());
			int mn = Integer.parseInt(st.nextToken());
			int prev = Integer.parseInt(st.nextToken());
			ArrayList<Integer> tmp = new ArrayList<>();
			tmp.add(prev);
			
			for(int j=1;j<mn;j++) {
				int cur = Integer.parseInt(st.nextToken());
				tmp.add(cur);
				
				int pa = findParent(prev, p);
				int pb = findParent(cur, p);
				
				if(pa < pb) {
					p[pb] = pa;
				}else if(pa > pb) {
					p[pa] = pb;
				}
				
				prev = cur;
			}
			
			party.add(tmp);
		}
		
		int answer = 0;
		
		for(int i=0;i<m;i++) {
			boolean lie = true;
			for(int friend: party.get(i)) {
				if(findParent(friend, p) == 0) {
					lie = false;
					break;
				}
			}
			
			if(lie) {
				answer++;
			}
		}
		
		System.out.println(answer);
	}

}

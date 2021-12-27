package com.ohyr.boj.class4.problem1991;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(in.readLine());
		
		char[][] binTree = new char[n][2];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(in.readLine());
			char node = st.nextToken().toCharArray()[0];
			char left = st.nextToken().toCharArray()[0];
			char right = st.nextToken().toCharArray()[0];
			
			binTree[node - 'A'][0] = left;
			binTree[node - 'A'][1] = right;
		}
		
		StringBuilder pre = new StringBuilder();
		StringBuilder mid = new StringBuilder();
		StringBuilder post = new StringBuilder();
		
		dfsTree('A', binTree, pre, mid, post);
		
		System.out.println(pre.toString());
		System.out.println(mid.toString());
		System.out.println(post.toString());
	}

	private static void dfsTree(char cur, char[][] binTree, StringBuilder pre, StringBuilder mid, StringBuilder post) {
		pre.append(cur);
		if(binTree[cur-'A'][0] != '.') dfsTree(binTree[cur-'A'][0], binTree, pre, mid, post);
		mid.append(cur);
		if(binTree[cur-'A'][1] != '.') dfsTree(binTree[cur-'A'][1], binTree, pre, mid, post);
		post.append(cur);
	}
	
}

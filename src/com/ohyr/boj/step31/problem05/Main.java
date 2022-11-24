package com.ohyr.boj.step31.problem05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static int[] inorder;
	public static int[] postorder;
	public static int[] preorder;
	public static StringBuilder sb;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(in.readLine());
		
		inorder = new int[n];
		postorder = new int[n];
		
		st = new StringTokenizer(in.readLine());
		for(int i=0;i<n;i++) {
			inorder[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(in.readLine());
		for(int i=0;i<n;i++) {
			postorder[i] = Integer.parseInt(st.nextToken());
		}
		
		preorder = new int[n];
		
		sb = new StringBuilder();
		
		makePreorder(0, n-1, 0, n-1);
		
		System.out.println(sb.toString());
	}

	private static void makePreorder(int inSt, int inEd, int postSt, int postEd) {
		if(inSt > inEd || postSt > postEd) return;
		
		int root = postorder[postEd];
		sb.append(root).append(" ");
		
		int idx = 0;
		for(int i=inSt;i<=inEd;i++) {
			if(root == inorder[i]) {
				idx = i;
				break;
			}
		}
		
		makePreorder(inSt, idx - 1, postSt, postSt + idx - inSt - 1);
		makePreorder(idx + 1, inEd, postSt + idx - inSt, postEd - 1);
	}
}

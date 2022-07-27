package com.ohyr.boj.step17.problem03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		String S = in.readLine();
		int[][] aNum = new int[26][S.length() + 1];
		for(int i=0;i<26;i++) {
			for(int j=1;j<=S.length();j++) {
				if(i + 'a' == S.charAt(j-1)) {
					aNum[i][j] += 1;
				}
				aNum[i][j] += aNum[i][j-1];
			}
		}
		
		int n = Integer.parseInt(in.readLine());
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(in.readLine());
			char a = st.nextToken().charAt(0);
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			
			sb.append(aNum[a - 'a'][r+1] - aNum[a - 'a'][l]).append("\n");
		}
		
		System.out.println(sb.toString());
	}

}

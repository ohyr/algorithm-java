package com.ohyr.boj.class2.problem4153;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		while(true) {
			int[] tri = new int[3];
			
			st = new StringTokenizer(in.readLine());
			tri[0] = Integer.parseInt(st.nextToken());
			tri[1] = Integer.parseInt(st.nextToken());
			tri[2] = Integer.parseInt(st.nextToken());
			
			if(tri[0] + tri[1] + tri[2] == 0) break;
			
			Arrays.sort(tri);
			
			if(tri[0]*tri[0] + tri[1]*tri[1] == tri[2]*tri[2]) {
				sb.append("right\n");
			}else {
				sb.append("wrong\n");
			}
		}
		
		System.out.println(sb.toString());
	}

}

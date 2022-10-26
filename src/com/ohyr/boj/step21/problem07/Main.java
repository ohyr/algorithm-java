package com.ohyr.boj.step21.problem07;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int T = Integer.parseInt(in.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			char[] p = in.readLine().toCharArray();
			int n = Integer.parseInt(in.readLine());
			int arr[] = new int[n];
			String str = in.readLine();
			st = new StringTokenizer(str.substring(1,str.length()-1),",");
			for(int i=0;i<n;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int r = 0;
			int start = 0;
			int end = n;
			
			boolean error = false;
			
			for(int i=0;i<p.length;i++) {
				switch(p[i]) {
				case 'R':
					r++;
					break;
				case 'D':
					if(start == end) {
						sb.append("error\n");
						error = true;
					}
					if(r%2 == 0) {
						start++;
					}else {
						end--;
					}
					break;
				}
				if(error) break;
			}
			if(error) continue;
			
			sb.append("[");
			if(r%2 == 0) {
				for(int i=start;i<end;i++) {
					sb.append(arr[i]);
					if(i == end-1) break;
					sb.append(",");
				}
				sb.append("]\n");
			}else {
				for(int i=end-1;i>=start;--i) {
					if(end-1 < 0) continue;
					sb.append(arr[i]);
					if(i == start) break;
					sb.append(",");
				}
				sb.append("]\n");
			}
		}
		System.out.println(sb.toString());
	}

}

package com.ohyr.boj.step36.problem01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int m = Integer.parseInt(in.readLine());
		
		int flag = 0;
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(in.readLine());
			String command = st.nextToken();
			
			switch(command) {
			case "add":
				flag |= 1 << Integer.parseInt(st.nextToken());
				break;
			case "remove":
				flag = flag & ~(1 << Integer.parseInt(st.nextToken()));
				break;
			case "check":
				if((flag & 1 << Integer.parseInt(st.nextToken())) != 0) {
					sb.append("1\n");
				}else {
					sb.append("0\n");
				}
				break;
			case "toggle":
				flag ^= (1 << Integer.parseInt(st.nextToken()));
				break;
			case "all":
				flag |= (~0);
				break;
			case "empty":
				flag &= 0;
				break;
			}
		}
		
		System.out.println(sb.toString());
	}

}

package com.ohyr.boj.class2.problem1259;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			String str = in.readLine();
			if(str.equals("0")) break;
			
			StringBuilder tmp = new StringBuilder();
			tmp.append(str);
			
			if(str.equals(tmp.reverse().toString())) {
				sb.append("yes\n");
			}else {
				sb.append("no\n");
			}
		}
		
		System.out.println(sb.toString());
	}

}

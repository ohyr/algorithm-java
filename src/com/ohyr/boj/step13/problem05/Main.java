package com.ohyr.boj.step13.problem05;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int r = Integer.parseInt(in.readLine());
		
		sb.append(r*r*Math.PI).append("\n");
		sb.append(2*r*r).append("\n");
		System.out.println(sb.toString());
	}

}

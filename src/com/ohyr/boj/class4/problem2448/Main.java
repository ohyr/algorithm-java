package com.ohyr.boj.class4.problem2448;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(in.readLine());
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n-1-i;j++) {
				sb.append(" ");
			}
			for(int j=0;j<2*i+1;j++) {
				if(i%3072 >= 1536 && 2*(i%1536)+1 <= j%3072 && j%3072 < 2*i - 2*(i%1536)) {
					sb.append(" ");
				}else if(i%1536 >= 768 && 2*(i%768)+1 <= j%1536 && j%1536 < 2*i - 2*(i%768)) {
					sb.append(" ");
				}else if(i%768 >= 384 && 2*(i%384)+1 <= j%768 && j%768 < 2*i - 2*(i%384)) {
					sb.append(" ");
				}else if(i%384 >= 192 && 2*(i%192)+1 <= j%384 && j%384 < 2*i - 2*(i%192)) {
					sb.append(" ");
				}else if(i%192 >= 96 && 2*(i%96)+1 <= j%192 && j%192 < 2*i - 2*(i%96)) {
					sb.append(" ");
				}else if(i%96 >= 48 && 2*(i%48)+1 <= j%96 && j%96 < 2*i - 2*(i%48)) {
					sb.append(" ");
				}else if(i%48 >= 24 && 2*(i%24)+1 <= j%48 && j%48 < 2*i - 2*(i%24)) {
					sb.append(" ");
				}else if(i%24 >= 12 && 2*(i%12)+1 <= j%24 && j%24 < 2*i - 2*(i%12)) {
					sb.append(" ");
				}else if(i%12 >= 6 && 2*(i%6)+1 <= j%12 && j%12 < 2*i - 2*(i%6)) {
					sb.append(" ");
				}else if(i%6 >= 3 && 2*(i%3)+1 <= j%6 && j%6 < 2*i - 2*(i%3)) {
					sb.append(" ");
				}else if(i%3 == 1 && j%3 == 1) {
					sb.append(" ");
				}else {
					sb.append("*");
				}
			}
			for(int j=0;j<n-1-i;j++) {
				sb.append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}

}

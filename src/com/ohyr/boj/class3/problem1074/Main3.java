package com.ohyr.boj.class3.problem1074;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main3 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int size = 1 << n;
		
		int answer = 0;
		
		for(int z=1;z<=n;z++) {
			int sum = (int) Math.pow(4, n-z);
			if(r < size/2 && c < size/2){
				size /= 2;
			}else if(r < size/2 && c >= size/2) {
				size /= 2;
				answer += sum;
				c -= size;
			}else if(r >= size/2 && c < size/2) {
				size /= 2;
				answer += 2*sum;
				r -= size;
			}else if(r >= size/2 && c >= size/2) {
				size /= 2;
				answer += 3*sum;
				r -= size;
				c -= size;
			}
		}
		
		System.out.println(answer);
	}

}

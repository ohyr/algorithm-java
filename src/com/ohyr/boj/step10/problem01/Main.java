package com.ohyr.boj.step10.problem01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] cards = new int[n];
		st = new StringTokenizer(in.readLine());
		for(int i=0;i<n;i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		
		int answer = 0;
		
		for(int i=0;i<n;i++) {
			for(int j=i+1;j<n;j++) {
				for(int k=j+1;k<n;k++) {
					int sum = cards[i] + cards[j] + cards[k];
					if(sum <= m) {
						answer = Math.max(answer, sum);
					}
				}
			}
		}
		
		System.out.println(answer);
	}

}

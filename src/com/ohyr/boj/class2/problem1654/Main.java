package com.ohyr.boj.class2.problem1654;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine());
		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		long max = 0;
		int[] lan = new int[k];
				
		for(int i=0;i<k;i++) {
			lan[i] = Integer.parseInt(in.readLine());
			max = Math.max(max, lan[i]);
		}
		
		long left = 0;
		long right = max + 1;
		long mid = 0;
		
		while(left < right) {
			mid = (left + right)/2;
			
			long sum = 0;
			for(int i=0;i<k;i++) {
				sum += lan[i]/mid;
			}
			
			if(sum < n) {
				right = mid;
			}else {
				left = mid+1;
			}
		}
		
		System.out.println(left-1);
	}

}

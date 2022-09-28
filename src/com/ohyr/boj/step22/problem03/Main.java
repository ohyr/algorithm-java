package com.ohyr.boj.step22.problem03;

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
		
		int[] lan = new int[k];
				
		for(int i=0;i<k;i++) {
			lan[i] = Integer.parseInt(in.readLine());
		}
		
		long left = 0;
		long right = Integer.MAX_VALUE + 1L;
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

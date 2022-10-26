package com.ohyr.boj.step10.problem04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(in.readLine());
		int[] num = new int[n];
		for(int i=0;i<n;i++) {
			num[i] = Integer.parseInt(in.readLine());
		}
		
		long sum = 0;
		for(int i=0;i<n;i++) {
			sum += num[i];
		}
		sb.append(Math.round((double)sum/n)).append("\n");
		
		Arrays.sort(num);
		sb.append(num[n/2]).append("\n");
		
		int[] used = new int[8001];
		for(int i=0;i<n;i++) {
			int cur = num[i] + 4000;
			used[cur]++;
		}
		
		int max = 0;
		int many = 0;
		int ans = 0;
		int cnt = 1;
		for(int i=0;i<8001;i++) {
			if(used[i] > max) {
				max = used[i];
				many = i;
				cnt = 1;
			}else if(used[i] == max && max != 0) {
				if(cnt == 1) {
					ans = i;
				}
				cnt++;
			}
		}
		if(cnt == 1) {
			sb.append(many-4000).append("\n");
		}else {			
			sb.append(ans-4000).append("\n");
		}
		
		sb.append(num[n-1] - num[0]).append("\n");
		
		System.out.println(sb.toString());
	}

}

package com.ohyr.boj.samsung.problem14888;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static int[] numbers;
	public static int[] ops;
	public static int Max;
	public static int Min;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int n = Integer.parseInt(in.readLine());
		
		numbers = new int[n];
		st = new StringTokenizer(in.readLine());
		for(int i=0;i<n;i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		// 0:+ 1:- 2:x 3:/
		ops = new int[n-1];
		int opsIdx = 0;
		st = new StringTokenizer(in.readLine());
		for(int i=0;i<4;i++) {
			int tmp = Integer.parseInt(st.nextToken());
			for(int j=0;j<tmp;j++) {
				ops[opsIdx++] = i;
			}
		}
		
		Max = Integer.MIN_VALUE;
		Min = Integer.MAX_VALUE;
		
		dfs(0, 0, n, numbers[0]);
		
		sb.append(Max).append("\n").append(Min);
		System.out.println(sb.toString());
	}

	private static void dfs(int cnt, int flag, int n, int sum) {
		if(cnt == n-1) {
			Max = Math.max(Max, sum);
			Min = Math.min(Min, sum);
			return;
		}
		for(int i=0;i<n-1;i++) {
			if((flag & 1<<i) != 0) continue;
			if(ops[i] == 0) {
				dfs(cnt+1, flag|1<<i, n, sum+numbers[cnt+1]);
			}else if(ops[i] == 1) {
				dfs(cnt+1, flag|1<<i, n, sum-numbers[cnt+1]);
			}else if(ops[i] == 2) {
				dfs(cnt+1, flag|1<<i, n, sum*numbers[cnt+1]);
			}else if(ops[i] == 3) {
				dfs(cnt+1, flag|1<<i, n, sum/numbers[cnt+1]);
			}
		}
	}

}

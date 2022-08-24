package com.ohyr.boj.class5.problem2568;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int n = Integer.parseInt(in.readLine());
		
		int[][] tmp = new int[n][2];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			tmp[i][0] = a;
			tmp[i][1] = b;
		}
		Arrays.sort(tmp, (a, b) -> a[0] - b[0]);
		
		int[] A = new int[n];
		for(int i=0;i<n;i++) {
			A[i] = tmp[i][1];
		}
		
		int cnt = 0;
		int[] chk = new int[n];
		int[] lis = new int[n];
		for(int i=0;i<n;i++) {
			int idx = lowerBound(0, cnt, lis, A[i]);
			if(idx >= cnt) {
				chk[i] = cnt;
				lis[cnt++] = A[i];
			}else {
				chk[i] = idx;
				lis[idx] = A[i];
			}
		}
		
		sb.append(n - cnt).append("\n");
		
		int chkCnt = cnt - 1;
		boolean[] checked = new boolean[n];
		for(int i=n-1;i>=0;i--) {
			if(chk[i] == chkCnt) {
				checked[i] = true;
				chkCnt--;
			}
		}
		
		for(int i=0;i<n;i++) {
			if(!checked[i]) {
				sb.append(tmp[i][0]).append("\n");
			}
		}
		
		System.out.println(sb.toString());
	}
	
	public static int lowerBound(int l, int r, int[] data, int target) {
		while(l < r) {
			int mid = (l + r) / 2;
			
			if(data[mid] < target) {
				l = mid + 1;
			}else {
				r = mid;
			}
		}
		return r;
	}
}

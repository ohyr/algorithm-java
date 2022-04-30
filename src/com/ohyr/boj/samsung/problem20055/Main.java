package com.ohyr.boj.samsung.problem20055;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] A = new int[2*n];
		
		st = new StringTokenizer(in.readLine());
		for(int i=0;i<2*n;i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		int answer = 0;
		int cnt = 0;
		
		int[] r = new int[n];
		
		while(true) {
			answer++;
			// 1. 벨트 회전
			int[] tmp = new int[2*n];
			for(int i=0;i<n - 1;i++) {
				r[n - 1 - i] = r[n - 2 - i];
			}
			r[0] = 0;
			for(int i=0;i<2*n - 1;i++) {
				tmp[i + 1] = A[i];
			}
			tmp[0] = A[2*n - 1];
			
			// 2. 로봇 이동
			r[n-1] = 0;
			for(int i=n-2;i>=0;i--) {
				if(r[i] == 0) continue;
				if(r[i+1] != 0) continue;
				if(tmp[i+1] == 0) continue;
				r[i] = 0;
				r[i+1] = 1;
				tmp[i+1] -= 1;
				if(tmp[i+1] == 0) cnt++;
			}
			
			// 3. 로봇 올리기
			if(tmp[0] != 0) {
				tmp[0] -= 1;
				r[0] = 1;
				if(tmp[0] == 0) cnt++;
			}
			
			// 4. 종료조건
			if(cnt >= k) {
				break;
			}
			
			A = tmp;
		}
		
		System.out.println(answer);
	}

}

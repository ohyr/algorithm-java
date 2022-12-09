package com.ohyr.boj.step48.problem02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int t = Integer.parseInt(in.readLine());
		for(int tc=1;tc<=t;tc++) {
			st = new StringTokenizer(in.readLine());
			long k = Integer.parseInt(st.nextToken());
			long c = Integer.parseInt(st.nextToken());
			
			long[] rst = exGcd(k, c);
			
			if(rst[2] != 1) {
				sb.append("IMPOSSIBLE\n");
				continue;
			}
			
			long answer = rst[1];
			
			answer = (answer % k + k) % k; // 음수인 경우
			answer = Math.max(answer, (k+c)/c); // k = 1 or c = 1 인 경우
			
			sb.append(answer > 1e9 ? "IMPOSSIBLE" : answer).append("\n");
		}
		
		System.out.println(sb.toString());
	}

	public static long[] exGcd(long a, long b) {
		long r0 = a, r1 = b;
		long s0 = 1, s1 = 0;
		long t0 = 0, t1 = 1;
		
		while(r1 != 0) {
			long q = r0/r1;
			
			long tmp = r0 - q*r1;
			r0 = r1;
			r1 = tmp;
			
			tmp = s0 - q*s1;
			s0 = s1;
			s1 = tmp;
			
			tmp = t0 - q*t1;
			t0 = t1;
			t1 = tmp;
		}
		
		return new long[] {s0, t0, r0};
	}
}

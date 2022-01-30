package com.ohyr.boj.class4.problem11444;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main2 {

	public static final long MOD = 1_000_000_007;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		Long n = Long.parseLong(in.readLine());
		
		if(n == 1 || n == 2) {
			System.out.println(1);
			return;
		}
		
		Map<Long, Long> fibo = new HashMap<>();
		fibo.put(0L, 0L);
		fibo.put(1L, 1L);
		fibo.put(2L, 1L);
		
		for(long i=3L;i<=n;i++) {
			fibo.put(i, (fibo.get(i-1) + fibo.get(i-2)) % MOD);
			fibo.remove(i-3);
		}
		
		System.out.println(fibo.get(n));
	}

}

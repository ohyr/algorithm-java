package com.ohyr.boj.class5.problem1644;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(in.readLine());
		
		List<Integer> primeList = new ArrayList<>();
		boolean[] isPrime = new boolean[n+1];
		Arrays.fill(isPrime, true);
		isPrime[0] = false;
		isPrime[1] = false;
		for(int i=2;i<=n;i++) {
			if(!isPrime[i]) continue;
			for(int j=2;i*j<=n;j++) {
				isPrime[i*j] = false;
			}
			primeList.add(i);
		}
		
		int answer = 0;
		
		int l = 0;
		int r = 0;
		int sum = 0;
		while(true) {
			if(sum > n) {
				sum -= primeList.get(l++);
			}else if(r == primeList.size()) {
				break;
			}else {
				sum += primeList.get(r++);
			}
			
			if(sum == n) {
				answer++;
			}
		}
		
		System.out.println(answer);
	}

}

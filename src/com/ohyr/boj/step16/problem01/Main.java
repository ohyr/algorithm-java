package com.ohyr.boj.step16.problem01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n;
	static int m;
	static int[] numbers;
	static boolean[] isSelected;
	
	private static void permutation(int cnt) {
		if(cnt == m) {
			for(int num : numbers) {
				System.out.print(num+" ");
			}
			System.out.println();
			return;
		}
		for(int i=1;i<=n;i++) {
			if(isSelected[i]) continue;
			
			numbers[cnt] = i;
			
			isSelected[i] = true;
			permutation(cnt+1);
			isSelected[i] = false;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		numbers = new int[m];
		isSelected = new boolean[n+1];
		
		permutation(0);
		
	}

}

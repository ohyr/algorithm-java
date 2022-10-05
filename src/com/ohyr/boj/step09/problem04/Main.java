package com.ohyr.boj.step09.problem04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int K;
	static int answer;
	static int[] tmp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		answer = -1;
		
		int[] A = new int[N];
		st = new StringTokenizer(in.readLine());
		for(int i=0;i<N;i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		tmp = new int[N];
		
		mergeSort(A, 0, N - 1);
		
		System.out.println(answer);
	}
	
	public static void mergeSort(int[] A, int p, int r) {
		if(K <= 0) return;
		if(p < r) {
			int q = (p + r) / 2;
			mergeSort(A, p, q);
			mergeSort(A, q+1, r);
			merge(A, p, q, r);
		}
	}
	
	public static void merge(int[] A, int p, int q, int r) {
		int i = p;
		int j = q + 1;
		int t = 0;
		while(i <= q && j <= r) {
			if(A[i] <= A[j]) {
				tmp[t++] = A[i++];
			}else {
				tmp[t++] = A[j++];
			}
		}
		while(i <= q) {
			tmp[t++] = A[i++];
		}
		while(j <= r) {
			tmp[t++] = A[j++];
		}
		i = p;
		t = 0;
		while(i <= r) {
			if(--K == 0) {
				answer = tmp[t];
			}
			A[i++] = tmp[t++];
		}
	}

}

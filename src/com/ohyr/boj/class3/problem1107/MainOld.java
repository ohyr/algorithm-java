package com.ohyr.boj.class3.problem1107;

import java.util.Scanner;

public class MainOld {
	
	static boolean[] broken = new boolean[10];
	
	static int minBtnNum = Integer.MAX_VALUE;
	static int N;
	static int Size;
	
	static void remote(int n, int cur, int idx, int[] number) {
		if(n <= 0) {
			int sum = 0;
			for(int i=0;i<idx;i++) {
				sum += number[i]*(int)Math.pow(10, i);
			}
			sum = Math.abs(sum-N);
			sum += idx;
			Size = idx;
			minBtnNum = Math.min(minBtnNum, sum);
			return;
		}
		
		n /= 10;
		if(!broken[cur]) {
			number[idx] = cur;
			remote(n, n%10, idx+1, number);
		}else {
			for(int i=cur-1;i>=0;--i) {
				if(!broken[i]) {
					number[idx] = i;
					remote(n, n%10, idx+1, number);
					break;
				}
			}
			for(int i=cur+1;i<10;i++) {
				if(!broken[i]) {
					number[idx] = i;
					remote(n, n%10, idx+1, number);
					break;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		int m = sc.nextInt();
		
		for(int i=0;i<m;i++) {
			int k = sc.nextInt();
			broken[k] = true;
		}
		sc.close();
		
		int pure = Math.abs(N-100);
		minBtnNum = Math.min(minBtnNum, pure);
		
		int[] number = new int[6];
		remote(N, N%10, 0, number);
		
		int low = 0;
		for(int i=9;i>=0;--i) {
			if(!broken[i]) {
				for(int j=0;j<Size-1;j++) {
					low += i*(int)Math.pow(10,j);
				}
				break;
			}
		}
		minBtnNum = Math.min(minBtnNum, N-low);
		
		int over = 0;
		for(int i=1;i<10;i++) {
			if(!broken[i]) {
				if(!broken[0]) {
					over = i*(int)Math.pow(10, Size);
				}else {
					for(int j=0;j<Size;j++) {
						over += i*(int)Math.pow(10,j);
					}
				}
				break;
			}
		}
		minBtnNum = Math.min(minBtnNum, over-N);
		
		System.out.println(minBtnNum);
	}

}

package com.ohyr.boj.class3.problem1074;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int r = sc.nextInt();
		int c = sc.nextInt();
		sc.close();
		
		int size = 1 << n;
		
		int answer = 0;
		
		for(int z=1;z<=n;z++) {
			int sum = (int) Math.pow(4, n-z);
			if(r < size/2 && c < size/2){
				size /= 2;
			}else if(r < size/2 && c >= size/2) {
				size /= 2;
				answer += sum;
				c -= size;
			}else if(r >= size/2 && c < size/2) {
				size /= 2;
				answer += 2*sum;
				r -= size;
			}else if(r >= size/2 && c >= size/2) {
				size /= 2;
				answer += 3*sum;
				r -= size;
				c -= size;
			}
		}
		
		System.out.println(answer);
	}

}

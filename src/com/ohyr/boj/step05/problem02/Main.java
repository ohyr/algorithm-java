package com.ohyr.boj.step05.problem02;

public class Main {

	public static int d(int n) {
		int tmp = n;
		while(tmp > 0) {
			n += tmp%10;
			tmp /= 10;
		}
		return n;
	}
	
	public static void main(String[] args) {
		int[] checked = new int[10001];
		for(int i=1;i<=10000;i++) {
			int self = d(i);
			if(self > 10000) continue;
			checked[d(i)] = 1;
		}
		
		for(int i=1;i<=10000;i++) {
			if(checked[i] == 0) {
				System.out.println(i);
			}
		}
	}

}

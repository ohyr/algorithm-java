package com.ohyr.boj.class3.problem1697;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		sc.close();
		
		int answer = 0;
		int[] visited = new int[100001];

		class Subin {
			int cur;
			int sec;
			
			Subin(int cur, int sec){
				this.cur = cur;
				this.sec = sec;
			}
		}
		
		Queue<Subin> q = new LinkedList<>();
		q.offer(new Subin(n, 0));
		
		while(!q.isEmpty()) {
			Subin subin = q.poll();
			if(subin.cur == k) {
				answer = subin.sec;
				break;
			}
			if(subin.cur < 0 || 100000 < subin.cur) continue;
			if(visited[subin.cur] == 1) continue;
			visited[subin.cur] = 1;
			
			q.offer(new Subin(subin.cur*2, subin.sec+1));
			q.offer(new Subin(subin.cur-1, subin.sec+1));
			q.offer(new Subin(subin.cur+1, subin.sec+1));
		}
		
		System.out.println(answer);
	}

}

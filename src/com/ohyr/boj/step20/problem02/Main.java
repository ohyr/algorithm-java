package com.ohyr.boj.step20.problem02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(in.readLine());
		
		Queue<Integer> q = new LinkedList<>();
		
		for(int i=1;i<=n;i++) {
			q.offer(i);
		}
		
		int r = 0;
		while(q.size() > 1){
			int tmp = q.poll();
			
			if(r%2 == 1) {
				q.offer(tmp);
			}

			r++;
		}
		
		System.out.println(q.poll());
	}

}

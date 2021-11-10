package com.ohyr.boj.class3.problem9019;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		class DSLR {
			int n;
			String commands;
			char dslr;
			DSLR(int n, String commands, char dslr){
				this.n = n;
				this.commands = commands;
				this.dslr = dslr;
			}
		}
		
		int T = Integer.parseInt(in.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(in.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			Queue<DSLR> q = new LinkedList<>();
			String answer = "";
			
			q.offer(new DSLR(A,"",'A'));
			
			boolean[] checked = new boolean[10000];
			
			while(!q.isEmpty()) {
				DSLR cur = q.poll();
				int n = cur.n;
				String commands = cur.commands;
				char dslr = cur.dslr;
				
				if(dslr == 'D') {
					n = 2*n%10000;
				}else if(dslr == 'S') {
					n = (n == 0) ? 9999 : n-1;
				}else if(dslr == 'L') {
					int front = n*10%10000;
					int back = n/1000;
					n = front + back;
				}else if(dslr == 'R') {
					int front = n*1000%10000;
					int back = n/10;
					n = front + back;
				}
				
				if(checked[n]) continue;
				checked[n] = true;
				
				if(n == B) {
					answer = commands;
					break;
				}
				
				q.offer(new DSLR(n, commands.concat("D"), 'D'));
				q.offer(new DSLR(n, commands.concat("S"), 'S'));
				q.offer(new DSLR(n, commands.concat("L"), 'L'));
				q.offer(new DSLR(n, commands.concat("R"), 'R'));
			}
			
			sb.append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}

}

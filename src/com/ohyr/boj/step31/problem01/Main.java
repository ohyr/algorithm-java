package com.ohyr.boj.step31.problem01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		class Node {
			int root;
			List<Integer> childs;
			
			Node(List<Integer> childs) {
				this.root = 0;
				this.childs = childs;
			}
			
			void add(int a) {
				childs.add(a);
			}
		}
		
		int n = Integer.parseInt(in.readLine());
		Node[] nodes = new Node[n + 1];
		for(int i=0;i<=n;i++) {
			nodes[i] = new Node(new LinkedList<>());
		}
		
		for(int i=0;i<n - 1;i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			nodes[a].add(b);
			nodes[b].add(a);
		}
		
		Queue<Integer> q = new LinkedList<>();
		q.offer(1);
		
		boolean[] visited = new boolean[n + 1];
		visited[1] = true;
		
		while(!q.isEmpty()) {
			int cur = q.peek();
			q.poll();
			
			for(int node : nodes[cur].childs) {
				if(visited[node]) continue;
				visited[node] = true;
				q.offer(node);
				nodes[node].root = cur;
			}
		}
		
		for(int i=2;i<=n;i++) {
			sb.append(nodes[i].root).append("\n");
		}
		System.out.println(sb.toString());
	}

}

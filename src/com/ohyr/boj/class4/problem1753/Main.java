package com.ohyr.boj.class4.problem1753;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		int K = Integer.parseInt(in.readLine())-1;
		
		// 인접 리스트 생성
		class Node{
			int vertex;
			int weight;
			Node link;
			Node(int vertex, int weight, Node link){
				this.vertex = vertex;
				this.weight = weight;
				this.link = link;
			}
		}
		Node[] adjList = new Node[V];
		
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(in.readLine());
			int u = Integer.parseInt(st.nextToken())-1;
			int v = Integer.parseInt(st.nextToken())-1;
			int w = Integer.parseInt(st.nextToken());
			
			// 인접 리스트에 입력
			adjList[u] = new Node(v, w, adjList[u]);
		}
		
		final int INF = Integer.MAX_VALUE;
		
		// 다익스트라
		boolean[] visited = new boolean[V];
		int[] distance = new int[V];
		Arrays.fill(distance, INF);
		
		distance[K] = 0;
		
		while(true) {
			int cur = -1;
			int min = INF;
			
			for(int j=0;j<V;j++) {
				if(!visited[j] && distance[j] < min) {
					min = distance[j];
					cur = j;
				}
			}
			
			if(cur == -1) break;
			
			visited[cur] = true;
			
			for(Node temp = adjList[cur]; temp != null; temp = temp.link) {
				if(!visited[temp.vertex] && distance[temp.vertex] > min + temp.weight) {
					distance[temp.vertex] = min + temp.weight;
				}
			}
		}
		
		for(int i=0;i<V;i++) {
			if(distance[i] == INF) {
				sb.append("INF");
			}else {
				sb.append(distance[i]);				
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}

}

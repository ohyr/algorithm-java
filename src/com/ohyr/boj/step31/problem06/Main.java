package com.ohyr.boj.step31.problem06;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static class Node {
		int value;
		Node left;
		Node right;
		
		Node(int value){
			this.value = value;
		}
		
		void addNode(int value) {
			if(value < this.value) {
				if(this.left != null) {
					this.left.addNode(value);
				}else {
					this.left = new Node(value);
				}
			}else {
				if(this.right != null) {
					this.right.addNode(value);
				}else {
					this.right = new Node(value);
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		Node root = new Node(Integer.parseInt(in.readLine()));
		
		String input = "";
		while((input = in.readLine()) != null) {
			root.addNode(Integer.parseInt(input));
		}
		
		postOrder(root, sb);
		
		System.out.println(sb.toString());
	}

	private static void postOrder(Node node, StringBuilder sb) {
		if(node.left != null) postOrder(node.left, sb);
		if(node.right != null) postOrder(node.right, sb);
		
		sb.append(node.value).append("\n");
	}

}

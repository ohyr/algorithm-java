package com.ohyr.boj.class2.problem9012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			Stack<Character> stk = new Stack<>();
			
			boolean vps = true;
			
			char[] rL = in.readLine().toCharArray();
			for(int i=0;i<rL.length;i++) {
				if(rL[i] == '(') {
					stk.push(rL[i]);
				}else {
					if(stk.isEmpty()) {
						vps = false;
						break;
					}
					stk.pop();
				}
			}
            
            if(!stk.isEmpty()) vps = false;
            
			if(vps) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
		}
	}

}

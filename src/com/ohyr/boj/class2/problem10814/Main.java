package com.ohyr.boj.class2.problem10814;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int n = Integer.parseInt(in.readLine());
		
		class OJ {
			int age;
			String name;
			OJ(int age, String name){
				this.age = age;
				this.name = name;
			}
		}
		
		OJ[] oj = new OJ[n];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(in.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			
			oj[i] = new OJ(age, name);
		}
		
		Arrays.sort(oj, (a, b) -> (a.age - b.age));
		
		for(int i=0;i<n;i++) {
			sb.append(oj[i].age).append(" ").append(oj[i].name).append("\n");
		}
		
		System.out.println(sb.toString());
	}

}

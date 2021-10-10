package com.ohyr.boj.class3.problem1764;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		Map<String,Integer> neverHeard = new HashMap<String,Integer>();
		
		for(int i=0;i<n;i++) {
			String neverHeardMan = sc.next();
			neverHeard.put(neverHeardMan, 0);
		}
		
		List<String> neverHeardAndSeen = new ArrayList<>();
		
		for(int i=0;i<m;i++) {
			String neverSeenMan = sc.next();
			if(neverHeard.get(neverSeenMan) != null) {
				neverHeardAndSeen.add(neverSeenMan);
			}
		}
		sc.close();
		
		String[] answer = neverHeardAndSeen.toArray(new String[neverHeardAndSeen.size()]);
		Arrays.sort(answer);
		
		System.out.println(answer.length);
		for(int i=0;i<answer.length;i++) {
			System.out.println(answer[i]);
		}
	}

}

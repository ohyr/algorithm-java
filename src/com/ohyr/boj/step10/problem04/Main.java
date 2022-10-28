package com.ohyr.boj.step10.problem04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(in.readLine());
		
        int[] arr = new int[n];
        
        for(int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(in.readLine());
        }
        
        Arrays.sort(arr);
        
        for(int i=0;i<n;i++){
		    sb.append(arr[i]).append("\n");
        }
        System.out.println(sb.toString());
	}

}

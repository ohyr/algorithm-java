package com.ohyr.boj.step12.problem03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		Map<String, String> pokemon = new HashMap<String,String>();
		Map<String, String> pokemonIndex = new HashMap<String,String>();
		
		for(int i=1;i<=n;i++) {
			String pokemonName = in.readLine();
			pokemon.put(Integer.toString(i), pokemonName);
			pokemonIndex.put(pokemonName, Integer.toString(i));
		}
		
		for(int i=0;i<m;i++) {
			String search = in.readLine();
			
			String result = "";
			
			if(65 <= search.charAt(0) && search.charAt(0) < 91) {
				result = pokemonIndex.get(search);
			}else {
				result = pokemon.get(search);
			}
			
			sb.append(result).append("\n");
		}
		
		System.out.println(sb.toString());
	}

}

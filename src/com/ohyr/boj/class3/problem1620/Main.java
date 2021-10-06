package com.ohyr.boj.class3.problem1620;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		Map<String, String> pokemon = new HashMap<String,String>();
		Map<String, String> pokemonIndex = new HashMap<String,String>();
		
		for(int i=1;i<=n;i++) {
			String pokemonName = sc.next();
			pokemon.put(Integer.toString(i), pokemonName);
			pokemonIndex.put(pokemonName, Integer.toString(i));
		}
		
		for(int i=0;i<m;i++) {
			String search = sc.next();
			
			String result = "";
			
			if(65 <= search.charAt(0) && search.charAt(0) < 91) {
				result = pokemonIndex.get(search);
			}else {
				result = pokemon.get(search);
			}
			
			System.out.println(result);
		}
		sc.close();
	}

}

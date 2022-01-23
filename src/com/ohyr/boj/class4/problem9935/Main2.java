package com.ohyr.boj.class4.problem9935;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main2 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		String bombstr = in.readLine();
		
		while(str.contains(bombstr)) {
			str = str.replace(bombstr, "");
		}
		
		if(str.equals("")) {
			System.out.println("FRULA");
		}else {
			System.out.println(str);
		}
	}

}

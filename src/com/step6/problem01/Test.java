package com.step6.problem01;

public class Test {
	public long sum(int[] a) {
		long ans = 0;
		for(int i=0;i<a.length;i++) {
			ans+=a[i];
		}
		return ans;
	}
}

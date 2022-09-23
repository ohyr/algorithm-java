package com.ohyr.programmers.kakao2022.level2.problem92335;

import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        StringTokenizer st = null;
        st = new StringTokenizer(dec2k(n, k), "0");
        while(st.hasMoreTokens()) {
            String p = st.nextToken();
            
            if(!p.equals("") && isPrime(Long.parseLong(p))) {
                answer++;
            }
        }
        
        return answer;
    }
    
    public boolean isPrime(long n) {
        if(n <= 1) {
            return false;
        }
        
        for(long i=2;i*i<=n;i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    public String dec2k(int n, int k) {
        StringBuilder sb = new StringBuilder();
        
        while(n > 0) {
            sb.append(n % k);
            n /= k;
        }
        
        return sb.reverse().toString();
    }
}
package com.ohyr.programmers.kakao2018.level2.problem17687;

class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        
        int num = 0;
        int cnt = 0;
        p--;
        
        out: while(num < t*m){
            String cur = Integer.toString(num++, n);
            for(int i=0;i<cur.length();i++){
                if(cnt++ % m == p){
                    answer.append(cur.charAt(i));
                    if(answer.length() == t){
                        break out;
                    }
                }
            }
        }
        
        return answer.toString().toUpperCase();
    }
}
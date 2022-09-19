package com.ohyr.programmers.kakao2018.level4.problem17685;

import java.util.*;

class Solution {
    public int solution(String[] words) {
        int answer = 0;
        int n = words.length;
        
        Arrays.sort(words);
        
        int pre = 0;
        
        for(int i=0;i<n-1;i++) {
            String a = words[i];
            String b = words[i+1];
            int len = dupLen(a, b);
            
            if(a.length() == len) {
                answer += Math.max(pre, len);
            }else {
                answer += Math.max(pre, len + 1);
            }
            pre = len + 1;
        }
        
        answer += pre;
        
        return answer;
    }
    
    public int dupLen(String s1, String s2) {
        int len = 0;
        
        for(int i=0;i<Math.min(s1.length(), s2.length());i++) {
            if(s1.charAt(i) != s2.charAt(i)) {
                break;
            }
            len++;
        }
        
        return len;
    }
}
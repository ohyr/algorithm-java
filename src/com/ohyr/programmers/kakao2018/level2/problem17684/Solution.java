package com.ohyr.programmers.kakao2018.level2.problem17684;

import java.util.*;

class Solution {
    public List<Integer> solution(String msg) {
        List<Integer> answer = new LinkedList<>();
        
        Map<String, Integer> dict = new HashMap<>();
        for(int i=1;i<=26;i++) {
            dict.put(Character.toString((char)(i+64)), i);
        }
        int dictIdx = 27;
        
        for(int i=0;i<msg.length();i++){
            String w = msg.substring(i, i+1);
            
            for(int j=i+1;j<=msg.length();j++){
                String wc = msg.substring(i, j);
                if(dict.get(wc) == null){
                    dict.put(wc, dictIdx++);
                    break;
                }
                w = wc;
            }
            
            answer.add(dict.get(w));
            
            i += w.length()-1;
        }
        
        return answer;
    }
}
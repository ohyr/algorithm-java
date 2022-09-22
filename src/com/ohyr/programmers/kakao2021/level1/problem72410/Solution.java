package com.ohyr.programmers.kakao2021.level1.problem72410;

class Solution {
    public String solution(String new_id) {
        String answer = "";
        
        // 1
        answer = new_id.toLowerCase();
        
        // 2
        StringBuilder tmp = new StringBuilder();
        for(int i=0;i<answer.length();i++) {
            char c = answer.charAt(i);
            if(('a' <= c && c <= 'z') || ('0' <= c && c <= '9') || c == '-' || c == '_' || c == '.') {
                tmp.append(c);
            }
        }
        answer = tmp.toString();
        
        // 3
        int dupCheck = 0;
        tmp = new StringBuilder();
        for(int i=0;i<answer.length();i++) {
            char c = answer.charAt(i);
            if(c == '.') {
                if(dupCheck == 0) {
                    tmp.append(c);
                }
                dupCheck++;
            }else {
                tmp.append(c);
                dupCheck = 0;
            }
        }
        answer = tmp.toString();
        
        // 4
        if(!answer.equals("") && answer.charAt(0) == '.') {
            answer = answer.substring(1);
        }
        
        if(!answer.equals("") && answer.charAt(answer.length() - 1) == '.') {
            answer = answer.substring(0, answer.length() - 1);
        }
        
        // 5
        if(answer.equals("")) {
            answer = "a";
        }
        
        // 6
        if(answer.length() >= 16) {
            tmp = new StringBuilder();
            for(int i=0;i<15;i++) {
                tmp.append(answer.charAt(i));
            }
            answer = tmp.toString();
            
            if(answer.charAt(answer.length() - 1) == '.') {
                answer = answer.substring(0, answer.length() - 1);
            }
        }
        
        // 7
        if(answer.length() <= 2) {
            char lastC = answer.charAt(answer.length() - 1);
            if(answer.length() == 2) {
                answer += lastC;
            }else {
                answer += lastC;
                answer += lastC;
            }
        }
        
        return answer;
    }
}
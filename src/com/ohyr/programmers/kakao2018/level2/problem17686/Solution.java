package com.ohyr.programmers.kakao2018.level2.problem17686;

import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        
        File[] fp = new File[files.length];
        for(int i=0;i<files.length;i++){
            String head = "";
            String number = "";
            String file = files[i];
            
            int tmp = 0;
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<file.length();j++){
                if(isDigit(file.charAt(j))){
                    tmp = j;
                    head = sb.toString();
                    break;
                }
                sb.append(file.charAt(j));
            }
            sb = new StringBuilder();
            for(int j=tmp;j<file.length();j++){
                if(!isDigit(file.charAt(j))){
                    break;
                }
                sb.append(file.charAt(j));
            }
            number = sb.toString();
            
            fp[i] = new File(head.toUpperCase(), Integer.parseInt(number), file);
        }
        
        Arrays.sort(fp, (a, b) -> (a.head.equals(b.head) ? (a.number - b.number) : a.head.compareTo(b.head)));
        
        for(int i=0;i<files.length;i++){
            answer[i] = fp[i].origin;
        }
        
        return answer;
    }
    
    private boolean isDigit(char c) {
        if(c - '0' < 0 || 9 < c - '0') {
            return false;
        }
        return true;
    }
    
    public class File {
        String head;
        int number;
        String origin;
        
        File(String head, int number, String origin){
            this.head = head;
            this.number = number;
            this.origin = origin;
        }
    }
}
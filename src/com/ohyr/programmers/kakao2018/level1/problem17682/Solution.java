package com.ohyr.programmers.kakao2018.level1.problem17682;

class Solution {
    public int solution(String dartResult) {
        int[] score = new int[4];
        int key = 0;
        
        for(int i=0;i<dartResult.length();i++) {
            char dr = dartResult.charAt(i);
            
            if(dr == 'S') {
                
            }else if(dr == 'D') {
                score[key] *= score[key];
            }else if(dr == 'T') {
                score[key] *= score[key] * score[key];
            }else if(dr == '*') {
                score[key - 1] *= 2;
                score[key] *= 2;
            }else if(dr == '#') {
                score[key] *= -1;
            }else {
                key++;
                if(dartResult.charAt(i + 1) == '0') {
                    i++;
                    score[key] = 10;
                }else {
                    score[key] = dr - '0';
                }
            }
        }
        
        return score[1] + score[2] + score[3];
    }
}
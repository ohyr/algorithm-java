package com.ohyr.programmers.kakao2018.level1.problem17681;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for(int i=0;i<n;i++) {
            int cur = arr1[i] | arr2[i];
            StringBuilder tmp = new StringBuilder();
            for(int j=0;j<n;j++) {
                if(cur % 2 == 1) {
                    tmp.append("#");
                }else {
                    tmp.append(" ");
                }
                cur /= 2;
            }
            
            answer[i] = tmp.reverse().toString();
        }
        
        return answer;
    }
}
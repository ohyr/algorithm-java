package com.ohyr.programmers.kakao2022.level2.problem92342;

import java.util.*;

class Solution {
    
    public int[] ryanAns;
    public int[] idx;
    public int max;
    
    public int[] solution(int n, int[] info) {
        int[] answer = { -1 };
        ryanAns = new int[11];
        
        idx = new int[n];
        max = 0;
        
        dupComb(0, 0, n, info);
        
        if(max != 0) {
            answer = ryanAns;
        }
        
        return answer;
    }
    
    public void dupComb(int start, int cnt, int n, int[] apeachInfo) {
        if(cnt == n) {
            int[] ryanInfo = new int[11];
            for(int i=0;i<n;i++) {
                ryanInfo[10 - idx[i]]++;
            }
            
            int apeach = 0;
            int ryan = 0;
            for(int i=0;i<11;i++) {
                int ap = apeachInfo[10 - i];
                int ry = ryanInfo[10 - i];
                
                if(ap == 0 && ry == 0) {
                    continue;
                }
                
                if(ap >= ry) {
                    apeach += i;
                }else {
                    ryan += i;
                }
            }
            
            if(ryan > apeach) {
                if(ryan - apeach > max) {
                    max = ryan - apeach;
                    ryanAns = ryanInfo;
                }
            }
            
            return;
        }
        for(int i=start;i<11;i++) {
            idx[cnt] = i;
            dupComb(i, cnt + 1, n, apeachInfo);
        }
    }
}
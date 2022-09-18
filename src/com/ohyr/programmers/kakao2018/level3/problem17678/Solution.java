package com.ohyr.programmers.kakao2018.level3.problem17678;

import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        int[] mintable = new int[timetable.length];
        for(int i=0;i<timetable.length;i++) {
            mintable[i] = time2min(timetable[i]);
        }
        Arrays.sort(mintable);
        
        int idx = 0;
        int start = 540;
        int con = 0;
        while(n-- > 0) {
            for(int i=0;i<m;i++) {
                if(idx >= mintable.length) {
                    con = start;
                    continue;
                }
                
                if(start >= mintable[idx]) {
                    con = mintable[idx] - 1;
                    idx++;
                }else {
                    con = start;
                }
            }
            
            start += t;
        }
        
        return min2time(con);
    }
    
    public int time2min(String time) {
        StringTokenizer st = new StringTokenizer(time, ":");
        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        return h * 60 + m;
    }
    
    public String min2time(int min) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%02d", min / 60));
        sb.append(":");
        sb.append(String.format("%02d", min % 60));
        return sb.toString();
    }
}
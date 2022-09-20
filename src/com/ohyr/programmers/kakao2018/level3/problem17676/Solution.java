package com.ohyr.programmers.kakao2018.level3.problem17676;

import java.util.*;

class Solution {
    public int solution(String[] lines) {
        StringTokenizer st = null;
        
        int answer = 0;
        int n = lines.length;
        
        ArrayList<Log> list = new ArrayList<>();
        
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(lines[i]);
            String ymd = st.nextToken();
            String time = st.nextToken();
            String proc = st.nextToken();
            
            double h = Double.parseDouble(time.substring(0,2));
            double m = Double.parseDouble(time.substring(3,5));
            double s = Double.parseDouble(time.substring(6));
            
            int times = (int)((3600 * h + 60 * m + s) * 1000);
            int ptimes = (int)(Double.parseDouble(proc.substring(0, proc.length() - 1)) * 1000);
            
            list.add(new Log(times - ptimes + 1, times));
        }
        
        Collections.sort(list, (a, b) -> a.end - b.end);
        
        for(int i=0;i<list.size();i++) {
            int endChk = list.get(i).end;
            
            int cnt = 0;
            
            for(int j=i;j<list.size();j++) {
                int curStart = list.get(j).start;
                
                if(endChk + 999 >= curStart) {
                    cnt++;
                }
            }
            
            answer = Math.max(answer, cnt);
        }
        
        return answer;
    }
    
    class Log {
        private int start;
        private int end;
        
        Log(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
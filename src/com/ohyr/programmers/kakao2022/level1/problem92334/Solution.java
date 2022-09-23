package com.ohyr.programmers.kakao2022.level1.problem92334;

import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        StringTokenizer st = null;
        
        int[] answer = new int[id_list.length];
        
        Map<String, Integer> idIdxMap = new HashMap<>();
        Map<String, Set<String>> reportedMap = new HashMap<>();
        for(int i=0;i<id_list.length;i++) {
            reportedMap.put(id_list[i], new HashSet<String>());
            idIdxMap.put(id_list[i], i);
        }
        
        for(int i=0;i<report.length;i++) {
            st = new StringTokenizer(report[i]);
            String a = st.nextToken();
            String b = st.nextToken();
            
            reportedMap.get(b).add(a);
        }
        
        for(String key : reportedMap.keySet()) {
            if(reportedMap.get(key).size() >= k) {
                sendMailOfReportResult(reportedMap.get(key), idIdxMap, answer);
            }
        }
        
        return answer;
    }
    
    public void sendMailOfReportResult(Set<String> userSet, Map<String, Integer> idIdxMap, int[] mailed) {
        for(String user : userSet) {
            mailed[idIdxMap.get(user)]++;
        }
    }
}
package com.ohyr.programmers.kakao2018.level2.problem17683;

import java.util.*;
//C# -> H 로 바꿔주는 방법도!! 해보기
class Solution {
 public String solution(String m, String[] musicinfos) {
     String answer = "(None)";
     
     List<String> mList = mStringToArr(m);
     int maxPlayTime = 0;
     
     StringTokenizer st = null;
     
     for(String musicinfo: musicinfos) {
         st = new StringTokenizer(musicinfo, ",");
         String startTime = st.nextToken();
         String endTime = st.nextToken();
         String title = st.nextToken();
         String melody = st.nextToken();
         
         int playTime = calMin(endTime) - calMin(startTime);
         
         List<String> melodyList = mStringToArr(melody);
         
         List<String> playMelody = new ArrayList<>();
         for(int i=0;i<playTime;i++){
             playMelody.add(melodyList.get(i % melodyList.size()));
         }
         
         if(isThatMusic(mList, playMelody)){
             if(maxPlayTime < playTime){
                 maxPlayTime = playTime;
                 answer = title;
             }
         }
     }
     
     return answer;
 }
 
 private List<String> mStringToArr(String m) {
     List<String> mList = new ArrayList<>();
     
     for(int i=0;i<m.length();i++){
         if(m.charAt(i) == '#'){
             mList.set((mList.size()-1), mList.get((mList.size()-1)) + "#");
         }else{
             mList.add(m.substring(i, i+1));
         }
     }
     
     return mList;
 }
 
 private int calMin(String time) {
     StringTokenizer st = new StringTokenizer(time, ":");
     int h = Integer.parseInt(st.nextToken());
     int m = Integer.parseInt(st.nextToken());
     return h*60 + m;
 }
 
 private boolean isThatMusic(List<String> m, List<String> pm) {
     for(int i=0;i<=pm.size() - m.size();i++){
         if(!pm.get(i).equals(m.get(0))) continue;
         
         for(int j=0;j<m.size();j++){
             if(!pm.get(i+j).equals(m.get(j))) break;
             
             if(j == m.size() - 1) return true;
         }
     }
     
     return false;
 }
}
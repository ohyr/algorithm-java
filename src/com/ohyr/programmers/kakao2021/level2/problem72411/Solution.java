package com.ohyr.programmers.kakao2021.level2.problem72411;

import java.util.*;

class Solution {
    
    public static char[] selectedMenu;
    
    public static Set<String> maxMenu;
    public static int maxMenuCnt;
    
    private static void comb(int cnt, int start, int n, int r, char[] menu, String[] orders){
        if(cnt == r){
            int count = 0;
            for(int i=0;i<orders.length;i++){
                boolean isContain = true;
                
                for(int j=0;j<selectedMenu.length;j++){
                    StringBuilder tmp = new StringBuilder();
                    if(!orders[i].contains(tmp.append(selectedMenu[j]))) {
                        isContain = false;
                    }
                }
                
                if(isContain){
                    count++;
                }
            }
            
            if(count < 2) return;
            
            char[] tmpMenu = selectedMenu.clone();
            Arrays.sort(tmpMenu);
            String menuStr = new String(tmpMenu);
            
            if(maxMenuCnt < count){
                maxMenuCnt = count;
                maxMenu.clear();
                maxMenu.add(menuStr);
            }else if(maxMenuCnt == count){
                maxMenu.add(menuStr);
            }
            
            return;
        }
        for(int i=start;i<n;i++){
            selectedMenu[cnt] = menu[i];
            comb(cnt+1, i+1, n, r, menu, orders);
        }
    }
    
    public String[] solution(String[] orders, int[] course) {
        String[] answer = new String[200];
        int ansIdx = 0;
        
        for(int i=0;i<course.length;i++){
            int r = course[i];
            selectedMenu = new char[r];
            
            maxMenu = new HashSet<>();
            maxMenuCnt = 0;
            
            for(String order: orders){
                int menuNum = order.length();
                char[] menu = order.toCharArray();
                
                comb(0, 0, menuNum, r, menu, orders);
            }
            
            for(String m: maxMenu){
                answer[ansIdx++] = m;
            }
        }
        
        answer = Arrays.copyOf(answer, ansIdx);
        Arrays.sort(answer);
        return answer;
    }
}
package com.ohyr.programmers.kakao2018.level2.problem17680;

import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        List<String> cache = new ArrayList<>();
        
        for(String city: cities){
            city = city.toLowerCase();
            if(cache.contains(city)){
                answer++;
                for(int i=0;i<cache.size();i++){
                    if(cache.get(i).equals(city)){
                        cache.remove(i);
                        break;
                    }
                }
                cache.add(city);
            }else{
                answer += 5;
                if(cacheSize == 0) continue;
                if(cache.size() == cacheSize){
                    cache.remove(0);
                }
                cache.add(city);
            }
        }
        
        return answer;
    }
}
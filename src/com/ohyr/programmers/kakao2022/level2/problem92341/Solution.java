package com.ohyr.programmers.kakao2022.level2.problem92341;

import java.util.*;

class Solution {
    public List<Integer> solution(int[] fees, String[] records) {
        StringTokenizer st = null;
        
        List<Integer> answer = new LinkedList<>();
        
        Map<String, Integer> parkingCheck = new TreeMap<>();
        Map<String, Integer> parkingTimeCheck = new TreeMap<>();
        
        for(String record : records) {
            st = new StringTokenizer(record);
            int m = time2min(st.nextToken());
            String car = st.nextToken();
            String ioStr = st.nextToken();
            
            if(ioStr.equals("IN")) {
                parkingCheck.put(car, m);
            }else {
                int start = parkingCheck.get(car);
                parkingCheck.remove(car);
                
                if(parkingTimeCheck.get(car) == null) {
                    parkingTimeCheck.put(car, 0);
                }
                parkingTimeCheck.put(car, parkingTimeCheck.get(car) + m - start);
            }
        }
        
        for(String remainCar : parkingCheck.keySet()) {
            int start = parkingCheck.get(remainCar);
            
            if(parkingTimeCheck.get(remainCar) == null) {
                parkingTimeCheck.put(remainCar, 0);
            }
            parkingTimeCheck.put(remainCar, parkingTimeCheck.get(remainCar) + 23 * 60 + 59 - start);
        }
        
        for(String car : parkingTimeCheck.keySet()) {
            answer.add(payFee(fees, parkingTimeCheck.get(car)));
        }
        
        return answer;
    }
    
    public int payFee(int[] fees, int m) {
        if(m <= fees[0]) {
            return fees[1];
        }
        
        m -= fees[0];
        
        if(m % fees[2] == 0) {
            return fees[1] + m / fees[2] * fees[3];
        }
        
        return fees[1] + (m / fees[2] + 1) * fees[3];
    }
    
    public int time2min(String time) {
        StringTokenizer st = new StringTokenizer(time, ":");
        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        return h * 60 + m;
    }
}
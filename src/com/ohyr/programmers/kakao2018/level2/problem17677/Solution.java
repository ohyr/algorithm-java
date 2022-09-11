package com.ohyr.programmers.kakao2018.level2.problem17677;

class Solution {
    public int solution(String str1, String str2) {
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        
        String[] A = new String[str1.length()-1];
        String[] B = new String[str2.length()-1];
        
        int sizeA = 0;
        int sizeB = 0;
        
        for(int i=0;i<str1.length()-1;i++){
            String substr = str1.substring(i, i+2);
            if(invalid(substr)) continue;
            
            A[sizeA++] = substr;
        }
        
        for(int i=0;i<str2.length()-1;i++){
            String substr = str2.substring(i, i+2);
            if(invalid(substr)) continue;
            
            B[sizeB++] = substr;
        }
        
        int dup = 0;
        
        for(int i=0;i<sizeA;i++){
            for(int j=0;j<sizeB;j++){
                if(B[j] == null) continue;
                if(A[i].equals(B[j])){
                    B[j] = null;
                    dup++;
                    break;
                }
            }
        }
        
        if(sizeA == 0 && sizeB == 0) return 65536 * 1;
        
        return 65536 * dup / (sizeA + sizeB - dup);
    }
    
    private static boolean invalid(String str) {
        for(char c: str.toCharArray()){
            if(c < 'A' || 'Z' < c){
                return true;
            }
        }
        return false;
    }
}
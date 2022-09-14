package com.ohyr.programmers.kakao2018.level2.problem17679;

class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        
        char[][] block = new char[m][n];
        for(int i=0;i<m;i++){
            block[i] = board[i].toCharArray().clone();
        }
        
        while(true){
            boolean isDone = true;
            boolean[][] check = new boolean[m][n];
            
            for(int i=0;i<m-1;i++){
                for(int j=0;j<n-1;j++){
                    if(block[i][j] == 0) continue;
                    if(block[i][j] == block[i][j+1]){
                        char target = block[i][j];
                        if((block[i+1][j] == target) && (block[i+1][j+1] == target)){
                            check[i][j] = true;
                            check[i][j+1] = true;
                            check[i+1][j] = true;
                            check[i+1][j+1] = true;
                            isDone = false;
                        }
                    }
                }
            }
            
            if(isDone) break;
            
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(check[i][j]){
                        answer++;
                        
                        for(int k=i;k>0;k--){
                            block[k][j] = block[k-1][j];
                        }
                        block[0][j] = 0;
                    }
                }
            }
        }
        
        return answer;
    }
}
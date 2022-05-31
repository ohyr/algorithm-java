package com.ohyr.boj.samsung.problem15683;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	private static int[][] cloneTmp(int n, int m, int[][] arr){
		int[][] tmp = new int[n][m];
		for(int i=0;i<n;i++) {
			tmp[i] = arr[i].clone();
		}
		return tmp;
	}
	
	private static int calSee(int x, int y, int dx, int dy, int n, int m, int[][] office) {
		int see = 0;
		while(true) {
			x += dx;
			y += dy;
			
			if(x < 0 || n <= x || y < 0 || m <= y) break;
			if(office[x][y] == 6) break;			
			if(office[x][y] == 0) {
				office[x][y] = -1;
				see++;
			}
		}
		return see;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] office = new int[n][m];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0;j<m;j++) {
				office[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		class CCTV{
			int num;
			int x;
			int y;
			int[][] searched;
			int cnt;
			int sum;
			CCTV(int num, int x, int y, int[][] searched, int cnt, int sum){
				this.num = num;
				this.x = x;
				this.y = y;
				this.searched = searched;
				this.cnt = cnt;
				this.sum = sum;
			}
		}
		
		int cctvNum = 0;
		int[][] cctvList = new int[9][3];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(office[i][j] == 0 || office[i][j] == 6) continue;
				cctvList[cctvNum][0] = office[i][j];
				cctvList[cctvNum][1] = i;
				cctvList[cctvNum][2] = j;
				
				cctvNum++;
			}
		}
		
		Queue<CCTV> q = new LinkedList<>();
		
		q.offer(new CCTV(cctvList[0][0], cctvList[0][1], cctvList[0][2], office, 0, 0));
		
		int see = 0;
		
		while(!q.isEmpty()) {
			CCTV cctv = q.poll();
			int x = cctv.x;
			int y = cctv.y;
			int cnt = cctv.cnt;
			int sum = cctv.sum;
			int[][] tmp = new int[n][m];
			for(int i=0;i<n;i++) {
				tmp[i] = cctv.searched[i].clone();
			}
			
			if(cnt == cctvNum) {
				see = Math.max(see, sum);
			}
			
			if(cctv.num == 1) {
				int[][] tmpp = cloneTmp(n, m, tmp);
				int cs = calSee(x, y, 0, 1, n, m, tmpp);
				q.offer(new CCTV(cctvList[cnt+1][0], cctvList[cnt+1][1], cctvList[cnt+1][2], tmpp, cnt+1, sum+cs));
				
				int[][] tmpp2 = cloneTmp(n, m, tmp);
				int cs2 = calSee(x, y, 1, 0, n, m, tmpp2);
				q.offer(new CCTV(cctvList[cnt+1][0], cctvList[cnt+1][1], cctvList[cnt+1][2], tmpp2, cnt+1, sum+cs2));
				
				int[][] tmpp3 = cloneTmp(n, m, tmp);
				int cs3 = calSee(x, y, 0, -1, n, m, tmpp3);
				q.offer(new CCTV(cctvList[cnt+1][0], cctvList[cnt+1][1], cctvList[cnt+1][2], tmpp3, cnt+1, sum+cs3));
				
				int[][] tmpp4 = cloneTmp(n, m, tmp);
				int cs4 = calSee(x, y, -1, 0, n, m, tmpp4);
				q.offer(new CCTV(cctvList[cnt+1][0], cctvList[cnt+1][1], cctvList[cnt+1][2], tmpp4, cnt+1, sum+cs4));
			}else if(cctv.num == 2) {
				int[][] tmpp = cloneTmp(n, m, tmp);
				int cs = calSee(x, y, 0, 1, n, m, tmpp);
				cs += calSee(x, y, 0, -1, n, m, tmpp);
				q.offer(new CCTV(cctvList[cnt+1][0], cctvList[cnt+1][1], cctvList[cnt+1][2], tmpp, cnt+1, sum+cs));
				
				int[][] tmpp2 = cloneTmp(n, m, tmp);
				int cs2 = calSee(x, y, 1, 0, n, m, tmpp2);
				cs2 += calSee(x, y, -1, 0, n, m, tmpp2);
				q.offer(new CCTV(cctvList[cnt+1][0], cctvList[cnt+1][1], cctvList[cnt+1][2], tmpp2, cnt+1, sum+cs2));
			}else if(cctv.num == 3) {
				int[][] tmpp = cloneTmp(n, m, tmp);
				int cs = calSee(x, y, 0, 1, n, m, tmpp);
				cs += calSee(x, y, 1, 0, n, m, tmpp);
				q.offer(new CCTV(cctvList[cnt+1][0], cctvList[cnt+1][1], cctvList[cnt+1][2], tmpp, cnt+1, sum+cs));
				
				int[][] tmpp2 = cloneTmp(n, m, tmp);
				int cs2 = calSee(x, y, 1, 0, n, m, tmpp2);
				cs2 += calSee(x, y, 0, -1, n, m, tmpp2);
				q.offer(new CCTV(cctvList[cnt+1][0], cctvList[cnt+1][1], cctvList[cnt+1][2], tmpp2, cnt+1, sum+cs2));
				
				int[][] tmpp3 = cloneTmp(n, m, tmp);
				int cs3 = calSee(x, y, 0, -1, n, m, tmpp3);
				cs3 += calSee(x, y, -1, 0, n, m, tmpp3);
				q.offer(new CCTV(cctvList[cnt+1][0], cctvList[cnt+1][1], cctvList[cnt+1][2], tmpp3, cnt+1, sum+cs3));
				
				int[][] tmpp4 = cloneTmp(n, m, tmp);
				int cs4 = calSee(x, y, -1, 0, n, m, tmpp4);
				cs4 += calSee(x, y, 0, 1, n, m, tmpp4);
				q.offer(new CCTV(cctvList[cnt+1][0], cctvList[cnt+1][1], cctvList[cnt+1][2], tmpp4, cnt+1, sum+cs4));
			}else if(cctv.num == 4) {
				int[][] tmpp = cloneTmp(n, m, tmp);
				int cs = calSee(x, y, 0, 1, n, m, tmpp);
				cs += calSee(x, y, 1, 0, n, m, tmpp);
				cs += calSee(x, y, 0, -1, n, m, tmpp);
				q.offer(new CCTV(cctvList[cnt+1][0], cctvList[cnt+1][1], cctvList[cnt+1][2], tmpp, cnt+1, sum+cs));
				
				int[][] tmpp2 = cloneTmp(n, m, tmp);
				int cs2 = calSee(x, y, 1, 0, n, m, tmpp2);
				cs2 += calSee(x, y, 0, -1, n, m, tmpp2);
				cs2 += calSee(x, y, -1, 0, n, m, tmpp2);
				q.offer(new CCTV(cctvList[cnt+1][0], cctvList[cnt+1][1], cctvList[cnt+1][2], tmpp2, cnt+1, sum+cs2));
				
				int[][] tmpp3 = cloneTmp(n, m, tmp);
				int cs3 = calSee(x, y, 0, -1, n, m, tmpp3);
				cs3 += calSee(x, y, -1, 0, n, m, tmpp3);
				cs3 += calSee(x, y, 0, 1, n, m, tmpp3);
				q.offer(new CCTV(cctvList[cnt+1][0], cctvList[cnt+1][1], cctvList[cnt+1][2], tmpp3, cnt+1, sum+cs3));
				
				int[][] tmpp4 = cloneTmp(n, m, tmp);
				int cs4 = calSee(x, y, -1, 0, n, m, tmpp4);
				cs4 += calSee(x, y, 0, 1, n, m, tmpp4);
				cs4 += calSee(x, y, 1, 0, n, m, tmpp4);
				q.offer(new CCTV(cctvList[cnt+1][0], cctvList[cnt+1][1], cctvList[cnt+1][2], tmpp4, cnt+1, sum+cs4));
			}else if(cctv.num == 5) {
				int cs = calSee(x, y, 0, 1, n, m, tmp);
				cs += calSee(x, y, 1, 0, n, m, tmp);
				cs += calSee(x, y, 0, -1, n, m, tmp);
				cs += calSee(x, y, -1, 0, n, m, tmp);
				q.offer(new CCTV(cctvList[cnt+1][0], cctvList[cnt+1][1], cctvList[cnt+1][2], tmp, cnt+1, sum+cs));				
			}
		}
		
		int zeroNum = 0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(office[i][j] == 0) zeroNum++;
			}
		}
		
		System.out.println(zeroNum - see);
	}

}

package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA1861 {

	static int[][] board;
	static int N;
	static int locationx;
	static int locationy;
	static int ans = Integer.MIN_VALUE;
	static ArrayList<Integer> aList = new ArrayList<>();
	

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		stk = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(stk.nextToken());

		for (int tc = 1; tc <= T; tc++) {
			stk = new StringTokenizer(br.readLine());
			N = Integer.parseInt(stk.nextToken());
			board = new int[N][N];
			locationx=0;
			locationy=0;
			ans=0;
			aList.clear();

			for (int i = 0; i < N; i++) {
				stk = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					board[i][j] = Integer.parseInt(stk.nextToken());
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					BFS(i, j);
				}
			}
			Collections.sort(aList);
			for(int i=0; i<aList.size(); i++) {
				
				System.out.println(aList.get(i));
			}
			
			System.out.println("#"+tc+" "+aList.get(0)+" "+ ans);
			
//			System.out.println();
			
			

		}

	}

	private static void BFS(int r, int c) {
		Queue<int[]> q = new LinkedList<int[]>();
		
		boolean[][] visited = new boolean[N][N];

		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { 1, 0, -1, 0 };
		int startx = r;
		int starty = c;
		int cnt =1;
		int val =0;
		
		visited[startx][starty] = true;
		q.add(new int[] {startx,starty,cnt});
		
		while(!q.isEmpty()) {
			
			int[] pos = q.poll();
			
			
			int x = pos[0];
			int y = pos[1];
			int count = pos[2];
			//int value =pos[3];
			
			for(int d=0; d<4; d++) {
				int nx = x+dx[d];
				int ny = y+dy[d];
				if(nx>=0 && nx<N && ny>=0 && ny<N && !visited[nx][ny]) {
					if(board[nx][ny]==board[x][y] +1) {
						visited[nx][ny]=true;
						q.add(new int[] {nx,ny,count+1});
						cnt++;
						//break;
					}
				}
			}
			//ans= Math.max(ans, cnt);
			if(q.isEmpty()) {
				if(count>=ans) {
					ans=count;
					locationx=startx;
					locationy=starty;
//					if(board[locationx][locationy]>board[startx][starty]) {
//						locationx= startx;
//						locationy= starty;
//					}
					aList.add(board[startx][starty]);
					
					//break;
				}
			}
			
		}
		
		
		
		

	}

}

package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11660 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		stk = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(stk.nextToken());
		int M = Integer.parseInt(stk.nextToken());
		int[][] board = new int[N+1][N+1];
		
		for(int i=1;i<=N; i++) {
			int temp=0;
			stk = new StringTokenizer(br.readLine());
			for(int j=1; j<=N;j++) {
				temp += Integer.parseInt(stk.nextToken());
				board[i][j] = temp;
				
			}
		}
		

		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<M; i++) {
			stk = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(stk.nextToken());
			int y1 = Integer.parseInt(stk.nextToken());
			int x2 = Integer.parseInt(stk.nextToken());
			int y2 = Integer.parseInt(stk.nextToken());
			int sum=0;
			for(int k=x1; k<=x2; k++) {
				
				sum += board[k][y2]-board[k][y1-1];
				//System.out.println(board[k][y2] + " SDD"+ board[k][y1-1]);
				
			}
			sb.append(sum+"\n");
			//System.out.println(sum);
		
			
			
		}
		
		System.out.println(sb.toString());
		
		
		
	}

}

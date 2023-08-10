package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14891 {
	
	static int[][] board;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		board = new int[4][8];
		
		for(int i=0; i<4; i++) {
			String str = br.readLine();
			for(int n=0; n<8; n++) {
				board[i][n] = str.charAt(n)-'0';
			}
		}
		stk = new StringTokenizer(br.readLine());
		int N= Integer.parseInt(stk.nextToken());
		for(int i=0; i<N; i++) {
			stk = new StringTokenizer(br.readLine());
			for(int j=0; j<2; j++) {
				int target =Integer.parseInt(stk.nextToken());
				int clock =Integer.parseInt(stk.nextToken());
				rotate(target,clock);
			}
		}
		
		
		
		
	}
	private static void rotate(int tar,int clk) {
		if(clk==1) {
			for(int i=0; i<8; i++) {
				board[tar][i]
			}
		}
		
	}

}

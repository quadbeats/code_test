package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10026_ColorWeakness {
	
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static char[][] board;
	static int N;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		
		for(int i=0; i < N; i++) {
			String str = br.readLine();
			board[i] = str.toCharArray();
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				BFS(i,j);					
			}
		}
		
	}
	private static void BFS(int i, int j) {
		// TODO Auto-generated method stub
		
		
		
	}
	
	
	

}

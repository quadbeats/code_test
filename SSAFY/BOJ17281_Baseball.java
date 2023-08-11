package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17281_Baseball {
	static int[][] board;
	static boolean[] checked=new boolean[8];	//1번 타자 제외한 8! 
	static int[] answer= new int[8];
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		
		board = new int[N][9];
		for(int i=0; i<N; i++) {
			stk = new StringTokenizer(br.readLine());
			for(int j=0; j<9; j++) {
				board[i][j]=Integer.parseInt(stk.nextToken());
			}
		}
		perm(0);
		
	}
	private static void perm(int idx) {
		
		if(idx ==8){
			//8
		}
		for(int i=0; i<checked.length; i++) {
			
		}
		
	}

}

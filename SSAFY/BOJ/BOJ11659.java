package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11659 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		stk = new StringTokenizer(br.readLine()," ");
		int N= Integer.parseInt(stk.nextToken());
		int M =Integer.parseInt(stk.nextToken());
		
		int temp = 0;
		int[] board = new int[N+1];
		board[0] = 0;
		stk = new StringTokenizer(br.readLine()," ");
		
		for(int i=1; i<=N; i++) {
			temp += Integer.parseInt(stk.nextToken());
			board[i]= temp;
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<M; i++) {
			stk = new StringTokenizer(br.readLine()," ");
			int start =Integer.parseInt(stk.nextToken());
			int end =Integer.parseInt(stk.nextToken());
			int a = board[end]-board[start-1];
			//System.out.println(a);
			sb.append(a+"\n");
			
			//System.out.println(Arrays.toString(board));
			
		}
		
		
	
	}

}

package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ12927 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer stk;
		//stk = new StringTokenizer(br.readLine());
		String str = br.readLine();
		char[] board = str.toCharArray();
		int ans = 0;
		System.out.println(Arrays.toString(board));
		
		for(int i=0; i<board.length; i++) {
			int num =i+1;
			while(num<board.length) {
				
				if(board[num-1] =='Y') { 
					board[num-1]='N';
					num+=num;
					ans++;
				}
			}
			
		}
		System.out.println(Arrays.toString(board));
		
	}

}

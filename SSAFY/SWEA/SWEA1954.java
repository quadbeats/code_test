package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA1954 {
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		
		int[] dx= {0,1,0,-1}; //우 하 좌 상
		int[] dy= {1,0,-1,0};
		
		stk = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(stk.nextToken());
		
		for(int tc=1; tc<=T; tc++) {
			
			stk = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(stk.nextToken());
			int[][] board = new int[N][N];
			board[0][0]=1;
			
			int nowd=0;
			int i=0;
			int j=0;
			
			while(true) {
				
				if(N==1) {
				
					break;
				}
				
				
				int nx=i+dx[nowd];
				int ny=j+dy[nowd];
				if(0<=nx && nx<N && ny>=0 && ny<N && board[nx][ny]==0 ) {
					
					board[nx][ny]=board[i][j]+1;
					if(board[nx][ny] ==N*N) {
						break;
					}
					i=nx;
					j=ny;
					
				}else {
					nowd= (nowd+1)%4;
				}
				

			}
			System.out.println("#"+tc);
			
			for(int r=0; r<N; r++) {
				for(int c=0; c<N;c++) {
					System.out.print(board[r][c]+ " ");
				}
				
				System.out.println();
			}
			
			
			
		}
		
		
		
		
		
	}

}

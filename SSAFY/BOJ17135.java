package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ17135 {
	static int[][] board;
	static int D,N,M;
	static int ans = Integer.MIN_VALUE;

	static ArrayList<int[]> monster = new ArrayList<>();
	static boolean[] checked;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		stk = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		D = Integer.parseInt(stk.nextToken());
		
		board = new int[N+1][M];
		checked = new boolean[M]; 	//열 개수가 nCr에서 n
		for(int i=0; i<N;i++) {
			stk = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<M;j++) {
				board[i][j]=Integer.parseInt(stk.nextToken());
				if(board[i][j] ==1) {
					monster.add(new int[] {i,j});
				}
			}
		}
		comb(0,0);
		
		
	}
	private static void comb(int idx, int depth) {

		if(depth==3) {
			
			int total=0; //하나의 조합에서 나오는 킬 수
			///////////////////////////////////// 보드 딥카피 해서 새로운 조합은 원본 보드에서 플레이 하도록 진행
			
			//while()  //여기부터 게임 반복 구간 감싸야함.
			for(int i=0; i<checked.length;i++) {
				if(checked[i]) {
					System.out.println(i+" ");
					int ar=N;
					int ac=i;	//i가 열의 위치 조합 나올 수 있는거
					int[] temp = BFS(N-1,i);//시작점은 궁수의 한칸 북쪽
					//System.out.println("====="+i+"번째 궁수가 죽일 타겟");
					//System.out.println(Arrays.toString(temp));
					
					if(temp[0]!=-99) {//사격범위내에 타겟이 존재할때만 
						if(board[temp[0]][temp[1]]==1) {//근데 누가 먼저 쏴서 죽였을 수도 있으니까 그 위치가 1인지 보고
							
							board[temp[0]][temp[1]]=0; //사격해서 0으로 없애버림
							total++; //킬수 1 증가
							
						}
					}
					
				}
			}
			
			ans = Math.max(ans, total); //하나의 조합에서 나오는 킬수 합을 갱신
			System.out.println();
			System.out.println();
			return;
		}
		if(idx==checked.length) return;
		checked[idx]=true;
		comb(idx+1,depth+1);
		checked[idx]=false;
		comb(idx+1,depth);
	}
	
	private static int[] BFS(int r, int c) {
		Queue<int[]> q = new LinkedList<int[]>();
		boolean[][] visited = new boolean[N][M];

//		for(int z=0; z<N;z++) {
//			System.out.println(Arrays.toString(visited[z]));
//		}
		int[] dx= {0,-1,0};	//좌 상 우
		int[] dy= {-1,0,1};
		int range=1;
		
		if(board[r][c]==1) {
			return new int[]{r,c};
		}//처음본자리가 적이면 바로 끝

		q.add(new int[] {r,c}); // 처음 궁수가 보는 위치
		System.out.println(r+" 처음 궁수가 보는 위치 "+c);
		
		visited[r][c]=true;
		
		while(!q.isEmpty()) {
			if(range==D) {// 범위까지 봤는데 적이 없으면
				return new int[]{-99,-99};
			}
			
			int[] temp =q.poll();
			int x = temp[0];
			int y= temp[1];
			
			for(int d=0; d<3; d++) {
				int nx = x+ dx[d];
				int ny = y+ dy[d];
				if(nx>=0&&nx<N&& ny>=0 && ny<M&& !visited[nx][ny]) {
					if(board[nx][ny]==1) {
						return new int[]{nx,ny};
					}
					q.add(new int[] {nx,ny});
					visited[nx][ny]=true;
				}
			}
			range++;
		}
		return new int[] {-1,-1};
		
	}

}

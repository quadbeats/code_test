package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ17281_BaseBall {

	static int N;
	static int P;	// 선수 타석 끊기는 곳 기록용
	static int[][] board;
	static int[] player= new int[9];
	static int[] tplayer= new int[9];
	static boolean[] checked= new boolean[9];
	static int ans = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		stk = new StringTokenizer(br.readLine());

		N = Integer.parseInt(stk.nextToken());
		board = new int[N][9];
		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				board[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		perm(0);
		System.out.println(ans);

		

	}
	private static void perm(int idx) {
		// TODO Auto-generated method stub
		if(idx ==8) {
			tplayer = new int[9];
			tplayer = player.clone();
			tplayer[8] = tplayer[3];		// 원래 4번타자를 맨뒤로 빼고
			tplayer[3] = 0;	
			P=0;
			// 4번 타자는 0번 선수임
			//////////////////// 타순 완성
			//System.out.println(Arrays.toString(tplayer));
			
			int sum = 0; // 조합 하나에서 나오는 총 점수
			
			for(int i=0; i<N; i++) {	// 총 이닝 수 만큼 게임 플레이 함.
				
				//int inningScore=0;
				
				sum += playball(i); //  해당 이닝 플레이볼!

				
			}
			ans = Math.max(ans, sum);
			
			
			
			
			
			return;
		}
		
		for(int i=1; i<9; i++) {
			
			if(!checked[i]) {
				player[idx] = i;
				checked[i] = true;
				perm(idx+1);
				checked[i] = false;
				
			}
			
		}
		
		
	}
	private static int playball(int inning) {
		
		int inningScore=0, out=0;		//  한 이닝에서 나오는 아웃카운트 , 이닝 점수
		int[] base = new int[4];	//베이스 현황 기록		0 => 1루  ,  2=> 3루	3=> 홈
		
		while(true) {
			
			if(out == 3) {		// 3아웃 이닝 종료
				return inningScore;
			}
			//System.out.println(P++%9);
			int hittype = tplayer[P++%9];	// 해당 이닝에서의 타순 0 - 8 선수 까지 타구 종류
			switch (hittype) {
			case 0:
				out++;
				break;
			case 1:	//안타
				for(int i=2; i>-1; i--) {
					base[i+1] =base[i];	// 한루 씩 진루
				}
				inningScore += base[3];
				base[0] =1;	//타자주자 1루
				base[3]=0;
				break;
			case 2:
				for(int i=2; i>-1; i--) {
					if(base[i] == 1) {
						if(i+2 >= 3) {
							base[i] =0;
							base[3]++;
						}else {
							base[i+2] =base[i];	// 2루 씩 진루						
						}
					}
					
				}
				inningScore += base[3];
				base[0] = 1;
				base[3] = 0;
				
				//if(board)
				
				break;
			case 3:
				int tmp3 =0;
				for(int i=2; i>-1; i--) {
					if(base[i] == 1) {
						tmp3++;
					}
				}
				inningScore += tmp3;
				base[0] = 1;
			
				
				break;
			case 4:
				int tmp=0;
				for(int i=0; i<2; i++) {
					if(base[i] == 1) {
						tmp++;
					}
				}
				inningScore += tmp == 0 ? 1 : tmp+1; 
				
				break;


			default:
				System.out.println("Error");
				break;
			}
			
			
			
			
		}
		
		
	}

}

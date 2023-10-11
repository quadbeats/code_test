import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static int N, M;
	static int[][] board;
	static int dx[] = { 0, 1, 0, -1 };
	static int dy[] = { 1, 0, -1, 0 };
	static int ans;
	static int K;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		stk = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(stk.nextToken());

		for (int tc = 1; tc <= T; tc++) {

			stk = new StringTokenizer(br.readLine());
			N = Integer.parseInt(stk.nextToken());
			M = Integer.parseInt(stk.nextToken());
			ans = Integer.MIN_VALUE;
			board = new int[N][N];
			int housecnt = 0;
			for (int i = 0; i < N; i++) {
				stk = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					board[i][j] = Integer.parseInt(stk.nextToken());
					if (board[i][j] == 1) {
						housecnt++;
					}
				}
			}

//			for( int i =0; i<N; i++) {
//				System.out.println(Arrays.toString(board[i]));
//			}
//			for(int k = 1; k<=N+1; k++) {	// k <= N+1??
//				

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {

					BFS(i, j);
				}
			}

//				
//			}
			System.out.println("#" + tc + " " + ans);

		}

	}

	private static void BFS(int i, int j) {

		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { i, j });

		boolean checked[][] = new boolean[N][N];
		checked[i][j] = true;

		int counter = 1;
		int home = 0;
		if (board[i][j] == 1) {
			home++;
		}
		while (!q.isEmpty()) {

			int dep = q.size();
			if(counter!=1) {
				
				for (int l = 0; l < dep; l++) {
					
					int[] temp = q.poll();
					int x = temp[0];
					int y = temp[1];
					
					for (int d = 0; d < 4; d++) {
						int nx = x + dx[d];
						int ny = y + dy[d];
						
						if (nx >= 0 && nx < N && ny >= 0 && ny < N && !checked[nx][ny]) {
							checked[nx][ny] = true;
							q.add(new int[] { nx, ny });
							
							if (board[nx][ny] == 1) {
								home++;
							}
						}
						
					}
					
				}
			}
			


			int price = counter * counter + (counter - 1) * (counter - 1);
			if ((home * M - price) >= 0) {
				ans = Math.max(ans, home);
				K = counter;
			}
			counter++;

		}

	}

}


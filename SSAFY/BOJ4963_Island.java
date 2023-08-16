package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ4963_Island {
	static int[] dx = { 0, 1, 1, 1, 0, -1, -1, -1};
	static int[] dy = { 1, 1, 0, -1, -1, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;

		while (true) {
			stk = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(stk.nextToken());
			int M = Integer.parseInt(stk.nextToken());

			if (N == 0 && M == 0) {
				break;
			}

			int[][] board = new int[N][M];
			for (int i = 0; i < N; i++) {

				stk = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < M; j++) {
					board[i][j] = Integer.parseInt(stk.nextToken());
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					BFS(i, j);
				}
			}

		}
	}

	private static void BFS(int i, int j) {
		// TODO Auto-generated method stub
		Queue<int[]> q = new LinkedList<int[]>();

	}

}

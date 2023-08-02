package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ15650 {
	static int N;
	static int M;
	static int[] ans;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		stk = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		ans = new int[M];
		
		recur(0,1);
		
		
	}

	private static void recur(int dep,int start) {
		// TODO Auto-generated method stub
		if(dep==M) {
			//System.out.println(Arrays.toString(ans));
			for(int v:ans) {
				System.out.print(v+" ");
			}
			System.out.println();
			return;
		}
		for(int i=start;i<=N;i++) {
			ans[dep]=i;
			recur(dep+1,i+1);
		}
		
		
	}

}

package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14888 {

	static int N;
	static int[] numbers;
	static int[] op;
	static int max,min;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		numbers= new int[N];
		op = new int[4];
		stk = new StringTokenizer(br.readLine()," ");
		for(int i =0; i<N; i++) {
			numbers[i] = Integer.parseInt(stk.nextToken());
		}
		stk = new StringTokenizer(br.readLine()," ");
		for(int i =0; i<4; i++) {
			op[i] = Integer.parseInt(stk.nextToken());
		}
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		
		
		func(numbers[0], 1);
		System.out.println(max);
		System.out.println(min);
	}

	private static void func(int num, int nextidx) {
		// TODO Auto-generated method stub
		if(nextidx == numbers.length) {
			max = Math.max(max, num);
			min = Math.min(min, num);
			return;
		}
		
		if (op[0] > 0) {
			op[0]--;
			func(num + numbers[nextidx], nextidx + 1);
			op[0]++;
		}
		if (op[1] > 0) {
			op[1]--;
			func(num - numbers[nextidx], nextidx + 1);
			op[1]++;
		}
		if (op[2] > 0) {
			op[2]--;
			func(num * numbers[nextidx], nextidx + 1);
			op[2]++;
		}
		if (op[3] > 0) {
			op[3]--;
			func(num / numbers[nextidx], nextidx + 1);
			op[3]++;
		}
		return;

	}

}

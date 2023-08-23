package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ17471_Gary {
	static int N;
	static int[] people;
	static int totalppl=0;
	static ArrayList<Integer>[] aList;
	static boolean[] checked;
	static int ans= Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk; 
		stk = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(stk.nextToken());
		people = new int[N+1];
		aList = new ArrayList[N+1];
		for(int i =0; i< N+1; i++) {
			aList[i] = new ArrayList<>();
		}
		stk = new StringTokenizer(br.readLine()," ");
		for(int i=1; i< N+1; i++) {
			people[i] = Integer.parseInt(stk.nextToken());
			totalppl += people[i];
		}
		for(int i =1; i<N+1; i++) {
			stk = new StringTokenizer(br.readLine()," ");
			int A = Integer.parseInt(stk.nextToken());
			for(int z=0; z<A; z++) {
				int temp = Integer.parseInt(stk.nextToken());
				aList[i].add(temp);
			}
		}
		

		//////////////
		for(int q = 1; q < N+1; q++) {
			
			BFS(q);
			
		}
		
		if(ans == Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(ans);
		}
		
		
		
		
	}
	private static void BFS(int startpoint) {
		// TODO Auto-generated method stub
		Queue<Integer> q = new LinkedList<Integer>();
		checked = new boolean[N+1];

		q.add(startpoint);

		
		while(!q.isEmpty()) {
			int subsum=0;
			int cnt=0;
			
			int target = q.poll(); 
			//마지막에 하나도 없으면 처리 ㄱㄱ
			//checked 전부 true면 안해도됨 이거
			checked[target] = true;
			
			for(int d=1; d<N+1; d++) {
				if(checked[d]) {
					cnt++;
				}
			}
			if(cnt == N) {
				return;
			}
			
			/////////////////////////////////////////////////////
			if(checkrest()) {//지금은 된다는 거니까
				for(int z=1; z<N+1; z++) {
					if(checked[z]) {	//A 지역구
						subsum+=people[z];
					}
				}
				ans = Math.min(ans, Math.abs(subsum - (totalppl - subsum)));
			}
			
			for(int i=0; i<aList[target].size(); i++) {
				int tarfriend = aList[target].get(i);
				if(!checked[tarfriend]) {
					
					q.add(tarfriend);
				}
			}
			
		}
		
	}
	
	private static boolean checkrest() {
		// TODO Auto-generated method stub
		Queue<Integer> restq = new LinkedList<>();
		
		
		boolean[] visited = new boolean[N+1];
		
		visited = checked.clone();
//		System.out.println();
//		System.out.println("START==");
//		System.out.println(Arrays.toString(visited));
//		System.out.println("=========");
		
		int falsepos =0;
		for(int i=1; i<N+1; i++) {
			if(!visited[i]) {
				falsepos = i;
			}
		}
		
		restq.add(falsepos);
		visited[falsepos] = true;
		while(!restq.isEmpty()) {
			
			int tar = restq.poll();			//이제 tar의 친구들을 큐에 넣어야 함
			for(int w=0; w<aList[tar].size(); w++) {	//tar의 친구들 길이만큼
				
				int tarfriend = aList[tar].get(w);	//tar의 친구를 가져왔는데
				if(!visited[tarfriend]) {		// 걔가 다른 구역도 아니고 안가본애만
					visited[tarfriend] = true;
					restq.add(tarfriend);
				}
				
			}
		}
		// rest구역 BFS돌았는데 

		for(int i=1; i<N+1; i++) {
			if(!visited[i]) {	//  근데 false가 남아있어? 그럼 불가능방법임
				return false;
			}
		}
		return true;	//아ㅣ니면 ㅇㅋ
		
		
	}
	

}

package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15649 {
    static int N;
    static int M;
    static boolean[] used;
    static int[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        stk=new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        used = new boolean[N];
        result = new int[M];
        perm(0);

    }

    private static void perm(int idx) {
        if(idx==M){

            for(int i=0; i< result.length;i++){
                System.out.print(result[i]+1+" ");
            }
            System.out.println();
            return;
        }

        for(int i=0; i<N; i++) {
            if(used[i]==false) {
                result[idx] = i;
                used[i] = true;
                perm(idx+1);
                used[i] = false;
            }
        }

    }
}

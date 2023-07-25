package BOJ3985;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ3985 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));



        int L = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        int maxval = -1;
        int maxidx =-1;
        int maxcake =-1;
        int maxcakeidx =-1;


        int[] cake = new int[L];
        int[][] board = new int[N][2];

        int[] user = new int[N];

        StringTokenizer stk;
        for (int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 2; j++) {
                board[i][j] = Integer.parseInt(stk.nextToken());
            }
        }


        for (int i=0; i<N;i++) {

            int temp = board[i][1]-board[i][0];
            if (temp> maxval) {
                maxval = temp;
                maxidx = i;
            }

        }

        System.out.println(maxidx+1);

        for (int i=0; i<N;i++) {
            int start = board[i][0]-1;
            int end = board[i][1]-1;
            int cakelen =0;
            for (int t= start; t<=end;t++ ) {
                if (cake[t]==0) {
                    cake[t]=i+1;
                    cakelen+=1;
                    user[i]+=1;
                }
            }

            if (cakelen>maxcake) {
                maxcake =cakelen;
                maxcakeidx=i+1;
            }



        }
        System.out.println(maxcakeidx);



    }

}
package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ6603 {
    static int[] board;
    static boolean[] checked;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        //여기 while
        while(true){
            stk = new StringTokenizer(br.readLine()," ");
            int N = Integer.parseInt(stk.nextToken());
            board=new int[N];
            checked=new boolean[N];
            if(N==0){
                break;
            }
            for(int i=0; i<N; i++){
                board[i]=Integer.parseInt(stk.nextToken());
            }

            comb(0,0);
            System.out.println();



        }





    }

    private static void comb(int idx, int depth) {
        if(depth ==6){
            for(int i=0; i<checked.length; i++) {
                if(checked[i]) {
                    System.out.print(board[i]+" ");
                }
            }
            System.out.println();


            return;
        }
        if(idx==checked.length) return;
        checked[idx]=true;
        comb(idx+1,depth+1);
        checked[idx]=false;
        comb(idx+1,depth);

    }
}

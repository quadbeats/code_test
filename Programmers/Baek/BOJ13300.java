package BOJ13300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ13300 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        stk = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(stk.nextToken());
        int K = Integer.parseInt(stk.nextToken());
        int S = 0,Y=0;

        int[][] sorted = new int[6][2];
        int res=0;


        for (int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine(), " ");
            S = Integer.parseInt(stk.nextToken());
            Y = Integer.parseInt(stk.nextToken());

            sorted[Y-1][S] +=1;
        }

        for (int i = 0; i < 6; i++) {
            //System.out.println(Arrays.toString(sorted[i]));

            for(int j=0; j<2;j++) {
                if (sorted[i][j]==0){
                    continue;
                }

                if(sorted[i][j]%K != 0){
                    res+=1;

                }
                res+= sorted[i][j]/K;
            }
        }


        System.out.println(res);


    }

}
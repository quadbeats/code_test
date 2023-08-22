package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ17281_BaseBall {

    static boolean[] checked = new boolean[10];
    static int[] player = new int[10];
    static int[][] board;
    static  int N;
    static int sum;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        board = new int[N][10];

        for(int i =0; i<N; i ++){

            stk = new StringTokenizer(br.readLine());
            for(int j=1; j<=9; j++){
                board[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        player[4]=1;
        checked[4]=true;
        perm(1);    //0은 뺼거라 1부터 시작

    }

    private static void perm(int idx) {

        if(idx==9){
            System.out.println(Arrays.toString(player));
            gamestart();
            System.out.println(sum);
            return;
        }

        for(int i=1; i<=9; i++){


            if(checked[i]==false) {
                player[idx] = i;
                checked[i]=true;
                perm(idx+1);
                checked[i]=false;

            }





        }


    }

    private static void gamestart() {
        int sum=0;

        int idx = 1; // player 조합나온거 1부터 시작해야함
        for(int i=0; i<N; i++){
            int perscore =0;
            int out =0;

            while(out<3){
                boolean[] base= new boolean[4];
                if(board[i][player[idx]] == 0){ //아웃
                    out++;
                }
                if(board[i][player[idx]] == 1){ //안타
                    if(base[3]){
                        perscore++; //3루주자 진루해서 점수 얻음
                        base[3] = false;
                    }
                    if(base[2]){
                        base[2] = false;    //2루주자 진루
                        base[3] = true;
                    }
                    if(base[1]){
                        base[1] = false;
                        base[2] = true;
                    }
                    base[1]=true;
                }
                if(board[i][player[idx]] == 2){ //2루타
                    if(base[3]){
                        perscore++; //3루주자 진루해서 점수 얻음
                        base[3] = false;
                    }
                    if(base[2]){
                        perscore++;  //2루주자 진루

                    }
                    if(base[1]){
                        base[1] = false;
                        base[3] = true;
                    }
                    base[2]=true;

                }
                if(board[i][player[idx]] == 3){ //3루타

                    if(base[3]){
                        perscore++; //3루주자 진루해서 점수 얻음
                        base[3] = false;
                    }
                    if(base[2]){
                        perscore++;  //2루주자 진루
                        base[2] = false;

                    }
                    if(base[1]){
                        base[1] = false;
                        perscore++;
                    }
                    base[3]=true;

                }
                if(board[i][player[idx]] == 4){ //홈런
                    if(base[3]){
                        perscore++; //3루주자 진루해서 점수 얻음
                        base[3] = false;
                    }
                    if(base[2]){
                        perscore++;  //2루주자 진루
                        base[2] = false;

                    }
                    if(base[1]){
                        base[1] = false;
                        perscore++;
                    }
                    perscore++;


                }
                idx++;
                if(idx>9){
                    idx=1;
                }

                sum  += perscore;

            }



        }



    }


}

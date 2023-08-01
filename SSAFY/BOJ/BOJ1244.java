package SWEA;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1244 {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        stk =new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int[] board = new int[N+1];
        //int[] stdboard = new int[N];

        stk =new StringTokenizer(br.readLine()," ");
        for(int i=1; i<=N; i++) {
            board[i] = Integer.parseInt(stk.nextToken());
        }

        stk =new StringTokenizer(br.readLine());
        int SN = Integer.parseInt(stk.nextToken());

        for(int i=0; i<SN; i++) {
            stk =new StringTokenizer(br.readLine()," ");
            //stdboard[]
            int gen = Integer.parseInt(stk.nextToken());
            int num = Integer.parseInt(stk.nextToken());
            if(gen ==1) {
                int tmp=num;
                while(num < board.length) {


                    board[num]= (board[num]==0)? 1:0;
                    num+=tmp;

                    //System.out.println(tmp+"tmp"+num);

                }

            }else if(gen==2){
                int offset=1;
                board[num]= (board[num]==0)? 1:0;
                while(true) {

                    if(num-offset<=0 || num+offset>board.length-1) {

                        break;
                    }


                    if(board[num-offset] == board[num+offset]){

                        board[num-offset] =(board[num-offset]==0)?1:0;
                        board[num+offset] =(board[num+offset]==0)?1:0;
                        offset++;
                    }else{
                        break;
                    }



                }


            }
        }
        //System.out.println(Arrays.toString(board));
        for (int i=1; i<board.length;i++){

            System.out.print(board[i]+" ");
            if(i%20==0){
                System.out.println();
            }

        }


    }

}
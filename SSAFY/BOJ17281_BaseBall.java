package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_BaseBall {

    static int N;
    static int P;	// 선수 타석 끊기는 곳 기록용
    static int[][] board;
    static int[] player= new int[9];
    static int[] tplayer= new int[9];
    static boolean[] checked= new boolean[9];
    static int ans = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        stk = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stk.nextToken());
        board = new int[N][9];
        for (int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                board[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        perm(0);
        System.out.println(ans);



    }
    private static void perm(int idx) {
        // TODO Auto-generated method stub
        if(idx ==8) {
            tplayer = new int[9];
            tplayer = player.clone();
            tplayer[8] = tplayer[3];		// 원래 4번타자를 맨뒤로 빼고
            tplayer[3] = 0;
            P=0;
            // 4번 타자는 0번 선수임
            //////////////////// 타순 완성
            //System.out.println(Arrays.toString(tplayer));

            int sum = 0; // 조합 하나에서 나오는 총 점수

            for(int i=0; i<N; i++) {	// 총 이닝 수 만큼 게임 플레이 함.

                //int inningScore=0;

                sum += playball(i); //  해당 이닝 플레이볼!


            }
            ans = Math.max(ans, sum);





            return;
        }

        for(int i=1; i<9; i++) {

            if(!checked[i]) {
                player[idx] = i;
                checked[i] = true;
                perm(idx+1);
                checked[i] = false;

            }

        }


    }
    private static int playball(int inning) {

        int inningScore=0, out=0;		//  한 이닝에서 나오는 아웃카운트 , 이닝 점수
        boolean[] base= new boolean[4];	//베이스 현황 기록		0 => 1루  ,  2=> 3루	3=> 홈

        while(true) {

            if(out == 3) {		// 3아웃 이닝 종료
                return inningScore;
            }
            //System.out.println(P++%9);
            int hittype = tplayer[P++%9];	// 해당 이닝에서의 타순 0 - 8 선수 까지 타구 종류
            switch (board[inning][hittype]) {
                case 0:
                    out++;
                    break;
                case 1:	//안타
                    if(base[3]){
                        inningScore++; //3루주자 진루해서 점수 얻음
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
                    break;
                case 2:
                    if(base[3]){
                        inningScore++; //3루주자 진루해서 점수 얻음
                        base[3] = false;
                    }
                    if(base[2]){
                        inningScore++;  //2루주자 진루

                    }
                    if(base[1]){
                        base[1] = false;
                        base[3] = true;
                    }
                    base[2]=true;

                    break;
                case 3:
                    if(base[3]){
                        inningScore++; //3루주자 진루해서 점수 얻음
                        base[3] = false;
                    }
                    if(base[2]){
                        inningScore++;  //2루주자 진루
                        base[2] = false;

                    }
                    if(base[1]){
                        base[1] = false;
                        inningScore++;
                    }
                    base[3]=true;


                    break;
                case 4:
                    if(base[3]){
                        inningScore++; //3루주자 진루해서 점수 얻음
                        base[3] = false;
                    }
                    if(base[2]){
                        inningScore++;  //2루주자 진루
                        base[2] = false;

                    }
                    if(base[1]){
                        base[1] = false;
                        inningScore++;
                    }
                    inningScore++;

                    break;


                default:
                    System.out.println("Error");
                    break;
            }




        }


    }

}

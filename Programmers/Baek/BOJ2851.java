package BOJ2851;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2851 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        int res =0;
        int dif =100;
        int ans =0;
        for (int i=0; i<10; i++){
            stk = new StringTokenizer(br.readLine()," ");
            int N = Integer.parseInt(stk.nextToken());
            res+=N;
            if(Math.abs(res-100)<= dif){
                dif=Math.abs(res-100);
                ans = res;
            }
        }
        System.out.println(ans);


    }
}

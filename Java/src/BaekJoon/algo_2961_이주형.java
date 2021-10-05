package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class algo_2961_이주형 {
    static int n;
    static int[] sour;
    static int[] bitter;
    static int[] meterial;
    static int soursum;
    static int bittersum;
    static int result;

    public static void subSet(int level, int c, int cnt){
        if(c == cnt){
            int temp = Math.abs(soursum - bittersum);
            if(result > temp) result = temp;

            return;
        }

        for(int i = level; i < n; i++){
            soursum *= sour[i];
            bittersum += bitter[i];
            subSet(i + 1 , c + 1, cnt);
            soursum /= sour[i];
            bittersum -= bitter[i];
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        sour = new int[n];
        bitter = new int[n];
        result = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++){
            String[] input = br.readLine().split(" ");
            sour[i] = Integer.parseInt(input[0]);
            bitter[i] = Integer.parseInt(input[1]);
        }

        for(int i = 1; i <= n; i++){
            soursum = 1;
            bittersum = 0;
            meterial = new int[i];
            subSet(0, 0, i);
        }

        System.out.println(result);
    }
}

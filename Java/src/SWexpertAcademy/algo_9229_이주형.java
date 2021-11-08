package SWexpertAcademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class algo_9229_이주형 {
    static int n;
    static int m;
    static int[] check;
    static boolean flag;
    static int result;
    public static void combination(int[] snacks, int level, int cnt){
        if(cnt == 2){
            int sum = 0;
            for(int i = 0; i < check.length; i++){
                sum += check[i];
            }
            if(sum <= m){
                flag = true;
                result = Math.max(sum, result);
            }
            return;
        }

        for(int i = level; i < snacks.length; i++){
            check[cnt] = snacks[i];
            combination(snacks, i + 1, cnt + 1);
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int t = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= t; test_case++){
            String[] input = br.readLine().split(" ");
            n = Integer.parseInt(input[0]);
            m = Integer.parseInt(input[1]);
            check = new int[2];
            result = Integer.MIN_VALUE;
            flag = false;

            int[] snacks = new int[n];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++){
                snacks[i] = Integer.parseInt(st.nextToken());
            }

            combination(snacks, 0, 0);

            if(flag) System.out.println("#" + test_case + " " + result);
            else System.out.println("#" + test_case + " " + -1);
        }
    }
}

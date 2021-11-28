package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class algo_12865_이주형 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n, k, w, v;
        n = Integer.parseInt(st.nextToken());       // 물품개수
        k = Integer.parseInt(st.nextToken());       // 총 들수있는 무게
        int[] knapsack = new int[k + 1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());   // 물건의 무게
            v = Integer.parseInt(st.nextToken());   // 물건의 가치

            for (int j = k; j >= w; j--) {              // 냅색문제 - 일차원배열로 처리 -> 뒤에서부터 무게까지
                if(knapsack[j] < knapsack[j - w] + v) {
                    knapsack[j] = knapsack[j - w] + v;
                }
            }
        }
        System.out.println(knapsack[k]);
    }
}

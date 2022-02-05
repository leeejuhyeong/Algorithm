package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class algo_17626_이주형 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        dp[1] = 1;

        int min, temp;
        for (int i = 2; i < n + 1; i++) {
            min = Integer.MAX_VALUE;

            for (int j = 1; j * j <= i; j++) {
                temp = i - j * j;
                min = min > dp[temp] ? dp[temp] : min;
            }
            dp[i] = min + 1;
        }
        bw.write(dp[n] + "\n");
        bw.flush();
        bw.close();
    }
}

/*
1 -> 1                      1개
2 -> 1 + 1                  2개
3 -> 1 + 1 + 1              3개
4 -> 2                      1개
5 -> 2 + 1                  2개

i 보다 작은 제곱근을 뺀 개수들 중 가장 작은 값 + 1
 */
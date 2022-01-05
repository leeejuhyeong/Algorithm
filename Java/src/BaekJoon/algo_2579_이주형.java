package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class algo_2579_이주형 {
    public static int result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] stairs = new int[n + 1];
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = stairs[0];
        dp[1] = stairs[1];

        if (n >= 2) {
            dp[2] = stairs[1] + stairs[2];
        }
//        System.out.println(Arrays.toString(dp));
        System.out.println(find(n, stairs, dp));
    }

    private static int find(int n, int[] stairs, int[] dp) {
        if (dp[n] == 0 && n != 0) {
            dp[n] = Math.max(find(n - 2, stairs, dp), find(n - 3, stairs, dp) + stairs[n - 1]) + stairs[n];
        }
        return dp[n];
    }
}

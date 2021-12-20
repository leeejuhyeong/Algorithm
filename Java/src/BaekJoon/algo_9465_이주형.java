package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class algo_9465_이주형 {
    public static int result;
    public static int[] moveR = {-1, 1, 0, 0};
    public static int[] moveC = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int n;
        int[][] numbers;
        int[][] dp;

        for (int testCase = 0; testCase < t; testCase++) {
            n = Integer.parseInt(br.readLine());
            numbers = new int[2][n + 1];
            dp = new int[2][n + 1];
            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= n; j++) {
                    numbers[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dp[0][1] = numbers[0][1];   // 1행 시작점 저장
            dp[1][1] = numbers[1][1];   // 2행 시작점 저장

            for (int i = 2; i <= n; i++) {
                dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + numbers[0][i]; // 둘 중 큰 값(선택한 스티커 중 큰 점수)를 더해줌
                dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + numbers[1][i];
            }
            System.out.println(Math.max(dp[0][n], dp[1][n]));
        }
    }
}

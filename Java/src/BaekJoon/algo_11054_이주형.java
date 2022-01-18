package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// LIS 문제인줄 알았지만 알고보니 새로운 유형..
public class algo_11054_이주형 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 2];         // 0 인덱스, n + 1 인덱스 0으로 만들기 위해
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[2][n + 2];

        // 0인덱스 ~ n인덱스까지 증가하는 수
        for (int i = 1; i <= n; i++) {      // 1부터 n까지
        for (int j = i - 1; j >= 0; j--) {      // 0부터 i-1까지
                if (arr[j] < arr[i] && dp[0][j] + 1 > dp[0][i]) {
                    dp[0][i] = dp[0][j] + 1;
                }
            }
        }

        // n인덱스 ~ 0인덱스까지 증가하는 수
        for (int i = n; i > 0; i--) {
            for (int j = i + 1; j <= n + 1; j++) {
                if (arr[j] < arr[i] && dp[1][j] + 1 > dp[1][i]) {
                    dp[1][i] = dp[1][j] + 1;
                }
            }
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (max < dp[0][i] + dp[1][i] - 1) {
                max = dp[0][i] + dp[1][i] - 1;
            }
        }
        System.out.println(max);
    }
}

package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class algo_9251_이주형 {        // 냅색 문제였다...
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] a = br.readLine().toCharArray();
        char[] b = br.readLine().toCharArray();

        int[][] dp = new int[a.length + 1][b.length + 1];       // 문자열의 길이만큼 배열 생성 - 0인덱스는 빈곳
        for (int i = 1; i <= a.length; i++) {
            for (int j = 1; j <= b.length; j++) {
                if (a[i - 1] == b[j - 1]) {     // i-1 현재 index, 같은 문자일 때
                    dp[i][j] = dp[i - 1][j - 1] + 1;        // i, j : 현재 index의 문자열을 포함할 때, 기존까지 비교한 같은 문자열의 개수 + 1
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);    // 기존 문자열을 포함하기 전 값중 큰 값을 가져오기
                }
            }
        }

        System.out.println(dp[a.length][b.length]);
    }
}
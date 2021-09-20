package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class algo_1149_이주형 {
    public static int[][] house;
    public static int[][] cost;

    public static int dp(int level, int color) {
        if (cost[level][color] == 0) {
            if (color == 0)
                cost[level][color] = house[level][0] + Math.min(dp(level - 1, 1), dp(level - 1, 2));
            else if (color == 1)
                cost[level][color] = house[level][1] + Math.min(dp(level - 1, 0), dp(level - 1, 2));
            else
                cost[level][color] = house[level][2] + Math.min(dp(level - 1, 0), dp(level - 1, 1));
        }
        return cost[level][color];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());
        int[] uses = new int[n + 1];
        house = new int[n + 1][3];
        cost = new int[n + 1][3];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                house[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        cost[1][0] = house[1][0];
        cost[1][1] = house[1][1];
        cost[1][2] = house[1][2];

        System.out.println(Math.min(dp(n, 0), Math.min(dp(n, 1), dp(n, 2))));
    }
}

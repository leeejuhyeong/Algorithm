package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class algo_1238_이주형 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int max = 100001;
        int[][] villages = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(villages[i], max);
        }

        int start, end, time;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            time = Integer.parseInt(st.nextToken());
            villages[start - 1][end - 1] = time;
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                if (i == k) continue;
                for (int j = 0; j < n; j++) {
                    if (j == i || j == k) continue;
                    if (villages[i][j] > villages[i][k] + villages[k][j])
                        villages[i][j] = villages[i][k] + villages[k][j];
                }
            }
        }

        for (int i = 0; i < n; i++) {
            villages[i][i] = 0;
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            if (i == x) continue;
            result = result < villages[i][x - 1] + villages[x - 1][i] ? villages[i][x - 1] + villages[x - 1][i] : result;       // 자신의 집에서 해당 마을을 갔다가 다시 자기 집으로 돌아오는 값
        }
        System.out.println(result);
    }
}

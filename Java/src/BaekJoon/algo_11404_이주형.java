package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class algo_11404_이주형 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());        // 도시의 개수
        int m = Integer.parseInt(br.readLine());        // 버스의 개수
        long max = 10000000001L;

        int start, end, weight;
        long[][] result = new long[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                else result[i][j] = max;
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            weight = Integer.parseInt(st.nextToken());

            result[start - 1][end - 1] = Math.min(result[start - 1][end - 1], weight);
        }

        fluid(n, result);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (result[i][j] == max)
                    result[i][j] = 0;
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }

    private static void fluid(int n, long[][] result) {
        for (int k = 0; k < n; k++) {       // 경우지
            for (int i = 0; i < n; i++) {   // 출발지
                if (k == i) continue;
                for (int j = 0; j < n; j++) {   // 도착지
                    if (j == k || j == i) continue;
                    if (result[i][j] > result[i][k] + result[k][j]) {
                        result[i][j] = result[i][k] + result[k][j];
                    }
                }
            }
        }
    }
}

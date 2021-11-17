package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class algo_1389_이주형 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        final int max = 5001;

        int[][] floyd = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) floyd[i][j] = 0;            // 자기자신은 0
                else floyd[i][j] = max;                 // 이외는 max값
            }
        }

        int a, b;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            floyd[a][b] = 1;                            // 친구 관계일 경우 양방향이므로 1로 초기화
            floyd[b][a] = 1;
        }

        for (int k = 1; k <= n; k++) {      // 플루이드 와샬
            for (int i = 1; i <= n; i++) {
                if (i == k) continue;
                for (int j = 1; j <= n; j++) {
                    if (j == i || j == k) continue;
                    if (floyd[i][j] > floyd[i][k] + floyd[k][j]) {
                        floyd[i][j] = floyd[i][k] + floyd[k][j];
                    }
                }
            }
        }

        int result_person = 0;              // 케빈 베이컨 수가 적은 사람의 index
        int result = Integer.MAX_VALUE;     // 가장 작은 케빈 베이컨 수
        int sum;
        for (int i = 1; i <= n; i++) {      // index가 1번부터 시작함으로
            sum = 0;
            for (int j = 1; j <= n; j++) {
                sum += floyd[i][j];
            }
            if (result > sum) {             // 케빈 베이컨 수가 같아도 가장 작은 index를 result_person이 갖고있음.
                result = sum;
                result_person = i;
            }
        }
        System.out.println(result_person);
    }
}

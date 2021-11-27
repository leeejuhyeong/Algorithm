package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class algo_11660_이주형 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n, m, x1, y1, x2, y2;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] numbers = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {  // 1, 1부터 i, j까지 구간을 더한 합으로 저장
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                numbers[i][j] = numbers[i - 1][j] + numbers[i][j - 1] - numbers[i - 1][j - 1] + Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());      // 구하려는 값 = x2, y2 구간까지 더한 값에서 시작점 구한값을 빼줌(중복된것은 더해주고)
            sb.append(numbers[x2][y2] - numbers[x2][y1 - 1] - numbers[x1 - 1][y2] + numbers[x1 - 1][y1 - 1]).append("\n");
        }

        System.out.println(sb);
    }
}

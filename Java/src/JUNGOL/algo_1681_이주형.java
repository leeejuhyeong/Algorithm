package JUNGOL;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class algo_1681_이주형 {
    public static int n, answer;
    public static int[][] map;
    public static boolean[] visited;

    public static void move(int i, int nodeCnt, int weight) {
        if (weight > answer) return;                // 가지치기
        if (nodeCnt == n - 1) {                     // 모두 배달했을 때
            weight += map[i][1];                    // 회사로 돌아가는 비용 더하기
            if (answer > weight && map[i][1] != 0) answer = weight; // 회사로 돌아갈 수 있고(비용이 0이 아님), 비용이 작을 경우
            return;
        }

        for (int j = 1; j <= n; j++) {
            if (map[i][j] == 0 || visited[j]) continue;         // 갈 수 없거나 방문한 곳이면 가지 않음.
            visited[j] = true;
            move(j, nodeCnt + 1, weight + map[i][j]);
            visited[j] = false;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine().trim());

        map = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        answer = Integer.MAX_VALUE;
        visited = new boolean[n + 1];
        visited[1] = true;                  // 1번 장소로 가지 않도록 방문처리
        move(1, 0, 0);
        System.out.println(answer);
    }
}

package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class algo_2638_이주형 {
    public static int[] moveR = {-1, 1, 0, 0};
    public static int[] moveC = {0, 0, -1, 1};

    public static class Melting {
        int row, col;

        Melting(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int result, sum, input;
        sum = result = 0;

        int[][] cheese = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                input = Integer.parseInt(st.nextToken());
                if (input == 1) sum++;
                cheese[i][j] = input;
            }
        }

        boolean[][] visited;
        Queue<Melting> queue = new LinkedList<>();
        Melting now;
        while (sum > 0) {
            visited = new boolean[n][m];
            visited[0][0] = true;
            dfs(0, 0, n, m, cheese, visited, queue);

            while (!queue.isEmpty()) {
                now = queue.poll();
                if(cheese[now.row][now.col] == 0)           // 이미 녹은 치즈인지 확인(queue에 중복되서 저장되기 때문에)
                    continue;
                cheese[now.row][now.col] = 0;
                sum--;
            }
            result++;
        }
        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }

    private static void dfs(int i, int j, int n, int m, int[][] cheese, boolean[][] visited, Queue<Melting> queue) {
        int nextR, nextC;
        for (int k = 0; k < 4; k++) {
            nextR = i + moveR[k];
            nextC = j + moveC[k];
            if (isRange(nextR, nextC, n, m) && !visited[nextR][nextC]) {         // 범위 내의 방문하지 않은 것이 있을 때
                visited[nextR][nextC] = true;                                   // 0(공기), 1(치즈) 둘 다 방문 처리하고
                if (cheese[nextR][nextC] == 0) {                                 // 0(공기)일 경우 dfs
                    dfs(nextR, nextC, n, m, cheese, visited, queue);
                }
            } else if (isRange(nextR, nextC, n, m) && visited[nextR][nextC] && cheese[nextR][nextC] == 1) {      // 범위내에 방문처리된 치즈가 있을 경우
                queue.add(new Melting(nextR, nextC));                   // 2변 이상 공기와 접촉된 것이므로 녹이기(공기와 맞닿은 부분이 2변인지 3변인지 모르기때문에 중복되서 queue에 저장됨)
            }
        }
    }

    private static boolean isRange(int i, int j, int n, int m) {
        return i >= 0 && j >= 0 && i < n && j < m;
    }
}

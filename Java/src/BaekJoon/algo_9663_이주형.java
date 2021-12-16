package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class algo_9663_이주형 {
    public static int result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        boolean[][] visited = new boolean[n][n];

        result = 0;
        dfs(0, map, visited, n);
        System.out.println(result);
    }

    public static void dfs(int row, int[][] map, boolean[][] visited, int n) {
        if (row == n) {
            result++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if(check(row, i, visited, n)) {
                visited[row][i] = true;                 // 해당 행에 퀸을 놓는다고 체크
                dfs(row + 1, map, visited, n);
                visited[row][i] = false;
            }
        }
    }

    public static boolean check(int r, int c, boolean[][] visited, int n) {
        for (int i = 0; i < n; i++) {   // 같은 열에 있는지 확인
            if (visited[i][c])
                return false;
        }

        int nextR, nextC;
        nextR = r + 1;
        nextC = c + 1;
        while (isRange(nextR, nextC, n)) {  // 왼쪽에서 오른쪽 위 대각선(자기 자신보다 높은 행)
            if (visited[nextR][nextC])
                return false;
            nextR++;
            nextC++;
        }
        nextR = r - 1;
        nextC = c - 1;
        while (isRange(nextR, nextC, n)) { // 왼쪽아래에서 오른쪽 위 대각선(자기 자신보다 낮은 행)
            if (visited[nextR][nextC])
                return false;
            nextR--;
            nextC--;
        }
        nextR = r + 1;
        nextC = c - 1;
        while (isRange(nextR, nextC, n)) {  // 왼쭉 위에서 오른쪽 아래 대각선(자기 자신보다 높은 행)
            if (visited[nextR][nextC])
                return false;
            nextR++;
            nextC--;
        }
        nextR = r - 1;
        nextC = c + 1;
        while (isRange(nextR, nextC, n)) {  // 왼쭉 위에서 오른쪽 아래 대각선(자기 자신보다 낮은 행)
            if (visited[nextR][nextC])
                return false;
            nextR--;
            nextC++;
        }

        return true;
    }

    public static boolean isRange(int r, int c, int n) {
        return r >= 0 && c >= 0 && r < n && c < n;
    }
}

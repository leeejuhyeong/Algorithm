package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class algo_2178_이주형 {
    public static int[] moveR = {-1, 1, 0, 0};
    public static int[] moveC = {0, 0, -1, 1};

    public static class Location {
        int r, c, count;

        Location(int r, int c, int count) {
            this.r = r;
            this.c = c;
            this.count = count;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] map = new char[n][m];
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        Queue<Location> queue = new LinkedList<>();
        visited[0][0] = true;
        queue.offer(new Location(0, 0, 1));
        Location now;
        int nextR, nextC;

        while(!queue.isEmpty()) {
            now = queue.poll();

            if(now.r == n - 1 && now.c == m - 1) {
                System.out.println(now.count);
                System.exit(0);
            }

            for (int i = 0; i < 4; i++) {
                nextR = now.r + moveR[i];
                nextC = now.c + moveC[i];

                if(!isRange(nextR, nextC, n, m) || visited[nextR][nextC] || map[nextR][nextC] == '0') continue;
                visited[nextR][nextC] = true;
                queue.offer(new Location(nextR, nextC, now.count + 1));
            }
        }
    }

    private static boolean isRange(int r, int c, int n, int m) {
        return r >= 0 && c >= 0 && r < n && c < m;
    }
}

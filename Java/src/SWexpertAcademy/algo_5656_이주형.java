package SWexpertAcademy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class algo_5656_이주형 {
    private static class Point {
        int r, c, cnt; // 행, 열, 벽돌 숫자

        Point(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }

    public static int n, w, h, min;
    public static int[] moveR = {-1, 1, 0, 0};
    public static int[] moveC = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        int maxIdx, temp, result;
        int[][] map;
        int[] max;

        for (int test_case = 1; test_case <= t; test_case++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            min = Integer.MAX_VALUE;
            map = new int[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            go(0, map);
            bw.append("#").append(String.valueOf(test_case)).append(" ").append(String.valueOf(min));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    public static int getRemain(int[][] map) {
        int count = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (map[i][j] > 0) count++;
            }
        }
        return count;
    }

    public static void go(int cnt, int[][] map) {
        if (cnt == n) {
            // 남아있는 벽돌 수 count, 최소값 갱신
            int result = getRemain(map);
            min = Math.min(result, min);
            return;
        }

        int[][] newMap = new int[h][w];
        for (int c = 0; c < w; c++) {
            int r = 0;
            while (r < h && map[r][c] == 0) r++;

            if (r == h)      // 맞은 벽돌이 없는 경우(해당 열 모두 빈칸)
                go(cnt + 1, map);
            else {
                copy(map, newMap);
                boom(r, c, newMap);
                down(newMap);
                go(cnt + 1, newMap);
            }
        }
    }

    private static void down(int[][] map) {
        for (int c = 0; c < w; c++) {
            int r = h - 1;
            while (r > 0) {
                if (map[r][c] == 0) {
                    int nr = r - 1;
                    while (nr > 0 && map[nr][c] == 0) nr--;
                    map[r][c] = map[nr][c];
                    map[nr][c] = 0;
                }
                r--;
            }
        }
    }

    private static ArrayList<Integer> list = new ArrayList<>();
    private static void down2(int[][] map) {
        for (int c = 0; c < w; c++) {
            for (int r = h - 1; r >= 0; r--) {
                if(map[r][c] > 0){
                    list.add(map[r][c]);
                    map[r][c] = 0;
                }
            }
            int r = h;
            for (int b : list) map[--r][c] = b;
            list.clear();
        }
    }

    private static void boom(int r, int c, int[][] newMap) {
        Queue<Point> queue = new LinkedList<>();
        if (newMap[r][c] > 1) {
            queue.offer(new Point(r, c, newMap[r][c]));
        }
        newMap[r][c] = 0;

        Point current;
        while (!queue.isEmpty()) {
            current = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nr = current.r;
                int nc = current.c;
                for (int k = 1; k < current.cnt; k++) {
                    nr += moveR[d];
                    nc += moveC[d];
                    if (isRange(nr, nc) && newMap[nr][nc] != 0) {
                        if (newMap[nr][nc] > 1) {
                            queue.offer(new Point(nr, nc, newMap[nr][nc]));
                        }
                        newMap[nr][nc] = 0;
                    }
                }
            }
        }
    }

    private static void copy(int[][] map, int[][] newMap) {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                newMap[i][j] = map[i][j];
            }
        }
    }

    public static boolean isRange(int r, int c) {
        return r >= 0 && c >= 0 && r < h && c < w;
    }
}

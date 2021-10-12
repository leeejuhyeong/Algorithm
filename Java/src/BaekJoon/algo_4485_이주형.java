package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;

public class algo_4485_이주형 {
    public static int result, sum;
    public static int[] movex = {-1, 1, 0, 0};
    public static int[] movey = {0, 0, -1, 1};

    public static class Point implements Comparable<Point> {
        int x, y, weight;

        Point(int x, int y, int weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }


        @Override
        public int compareTo(Point o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[][] map;
        int t = 1;

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            result = Integer.MAX_VALUE;
            sum = 0;
            map = new int[n][];
            for (int i = 0; i < n; i++) {
                map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
            int[][] edge = new int[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(edge[i], Integer.MAX_VALUE);
            }

            PriorityQueue<Point> pq = new PriorityQueue<>();
            pq.offer(new Point(0, 0, map[0][0]));
            edge[0][0] = map[0][0];

            Point current;
            while (true) {
                current = pq.poll();

                if (current.x == n - 1 && current.y == n - 1) break;
                if (edge[current.x][current.y] < current.weight) continue;

                int nextR, nextC;
                for (int i = 0; i < 4; i++) {
                    nextR = current.x + movex[i];
                    nextC = current.y + movey[i];
                    if (!isRange(nextR, nextC, n)) continue;
                    if (edge[nextR][nextC] > edge[current.x][current.y] + map[nextR][nextC]) {
                        edge[nextR][nextC] = edge[current.x][current.y] + map[nextR][nextC];
                        pq.offer(new Point(nextR, nextC, edge[nextR][nextC]));
                    }
                }
            }
            bw.append("Problem ").append(String.valueOf(t)).append(": ").append(String.valueOf(edge[n - 1][n - 1]));
            bw.newLine();
            t++;
        }
        bw.flush();
        bw.close();
    }


    private static boolean isRange(int i, int j, int n) {
        return i >= 0 && j >= 0 && i < n && j < n;
    }
}


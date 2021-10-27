package SWexpertAcademy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;

// SWExpertAcademy
public class algo_1249_이주형 {
    public static int result;
    public static int[] moveR = {-1, 1, 0, 0};
    public static int[] moveC = {0, 0, -1, 1};

    public static class Node implements Comparable<Node> {
        int r, c, weight;

        Node(int r, int c, int weight) {
            this.r = r;
            this.c = c;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    public static boolean isRange(int r, int c, int n) {
        return r >= 0 && c >= 0 && r < n && c < n;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        int n, nextR, nextC;
        ;
        int[][] map;
        int[][] minMap;
        String input;
        PriorityQueue<Node> pq;

        for (int test_case = 1; test_case <= t; test_case++) {
            n = Integer.parseInt(br.readLine());
            map = new int[n][n];

            for (int i = 0; i < n; i++) {
                input = br.readLine();
                for (int j = 0; j < n; j++) {
                    map[i][j] = input.charAt(j) - '0';
                }
            }

            minMap = new int[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(minMap[i], Integer.MAX_VALUE);
            }

            pq = new PriorityQueue<>();
            pq.offer(new Node(0, 0, 0));
            Node current;

            while (!pq.isEmpty()) {
                current = pq.poll();
                if (current.r == n - 1 && current.c == n - 1) break;

                for (int i = 0; i < 4; i++) {
                    nextR = moveR[i] + current.r;
                    nextC = moveC[i] + current.c;

                    if (!isRange(nextR, nextC, n)) continue;
                    if (minMap[nextR][nextC] > current.weight + map[nextR][nextC]) {
                        minMap[nextR][nextC] = current.weight + map[nextR][nextC];
                        pq.offer(new Node(nextR, nextC, minMap[nextR][nextC]));
                    }
                }
            }
            bw.append("#").append(String.valueOf(test_case)).append(" ").append(String.valueOf(minMap[n - 1][n - 1]));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    private static int dijkstra(int startR, int startC, int n, int[][] map) {
        boolean[][] checked = new boolean[n][n];
        int[][] minTime = new int[n][n];

        int INF = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                minTime[i][j] = INF;
            }
        }

        minTime[startR][startC] = 0;

        int r = 0, c = 0, minCost = 0, nr, nc;
        while (true) {
            minCost = INF;
            for (int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++){
                    if(!checked[i][j] && minCost > minTime[i][j]){
                        minCost = minTime[i][j];
                        r = i;
                        c = j;
                    }
                }
            }

            checked[r][c] = true;
            if(r == n - 1 && c == n - 1){
                return minCost;
            }

            for(int d = 0; d < 4; d++){
                nr = r + moveR[d];
                nc = c + moveC[d];

                if(isRange(nr, nc, n) && !checked[nr][nc] && minTime[nr][nc] > minCost + map[nr][nc]){
                    minTime[nr][nc] = minCost + map[nr][nc];
                }
            }
        }
    }
}

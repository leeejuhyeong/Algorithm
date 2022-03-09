package Programmers;

import java.util.*;

public class SharedTaxiFee_KakaoBlindRecrument_2021 {
    public static class Node implements Comparable<Node> {
        int next;
        int weight;

        public Node(int next, int weight) {
            this.next = next;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {      // miss.1 pq 사용 시
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) {
        int n = 6;
        int s = 4;
        int a = 6;
        int b = 2;
        int[][] fares = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};
        System.out.println(solution1(6, 4, 6, 2, fares));
    }

    // 다익스트라
    public static int solution2(int n, int s, int a, int b, int[][] fares) {
        List<Node>[] map = new List[n + 1];
        int MAX_FEE = 20000000;

        for (int i = 1; i <= n; i++) {
            map[i] = new LinkedList<>();
        }

        for (int[] fare : fares) {
            map[fare[0]].add(new Node(fare[1], fare[2]));
            map[fare[1]].add(new Node(fare[0], fare[2]));
        }

        int[] fareFee = new int[n + 1];
        int[] aFee = new int[n + 1];
        int[] bFee = new int[n + 1];

        Arrays.fill(fareFee, MAX_FEE);
        Arrays.fill(aFee, MAX_FEE);
        Arrays.fill(bFee, MAX_FEE);

        dijkstra(n, map, fareFee, s);
        dijkstra(n, map, aFee, a);
        dijkstra(n, map, bFee, b);

        int answer = fareFee[a] + fareFee[b];
        for (int i = 1; i <= n; i++) {
            if (answer > fareFee[i] + aFee[i] + bFee[i]) {       // 이 부분이 포인트!(발상의 전환)
                answer = fareFee[i] + aFee[i] + bFee[i];
            }
        }

        return answer;
    }

    public static void dijkstra(int n, List<Node>[] map, int[] minFare, int dest) {
        boolean[] visited = new boolean[n + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        minFare[dest] = 0;
        pq.add(new Node(dest, 0));
        Node now;

        while (!pq.isEmpty()) {
            now = pq.poll();
            if (visited[now.next])
                continue;

            visited[now.next] = true;
            for (Node next : map[now.next]) {
                if (!visited[next.next] && now.weight + next.weight < minFare[next.next]) {  // miss.2 : visited 처리
                    minFare[next.next] = now.weight + next.weight;
                    pq.add(new Node(next.next, minFare[next.next]));
                }
            }
        }
    }

    // 플로이드 와샬
    public static int solution1(int n, int s, int a, int b, int[][] fares) {
        int[][] map = new int[n + 1][n + 1];
        int MAX_FEE = 20000000;

        // 초기화
        for (int i = 1; i <= n; i++) {
            Arrays.fill(map[i], MAX_FEE);
            map[i][i] = 0;
        }

        for (int[] fee : fares) {
            map[fee[0]][fee[1]] = fee[2];
            map[fee[1]][fee[0]] = fee[2];
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                if (i == k)
                    continue;
                for (int j = 1; j <= n; j++) {
                    if (j == i || j == k)
                        continue;
                    if (map[i][j] > map[i][k] + map[k][j]) {
                        map[i][j] = map[i][k] + map[k][j];
                    }
                }
            }
        }

        int answer = map[s][a] + map[s][b];
        for (int i = 1; i <= n; i++) {
            if (answer > map[s][i] + map[i][a] + map[i][b]) {
                answer = map[s][i] + map[i][a] + map[i][b];
            }
        }
        return answer;
    }
}

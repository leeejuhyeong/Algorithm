package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 문제를 잘못이해함 한번 다녀오면 비용이 안드는줄알고...
// 플루이드와샬X -> 1 -> 2, 2 -> 3, 3 -> 4가 어딜 경유해서 오는지 모름
// 다익스트라로 해야함
public class algo_1504_이주형 {
    public static int INF = 200000000;                      // 경로가 없을 경우 Integer.MAX_VALUE를 넣으면 int 범위를 벗어남

    public static class Node implements Comparable<Node> {
        int next;
        int weight;

        Node(int next, int weight) {
            this.next = next;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Node>[] edge = new List[n + 1];

        for (int i = 1; i <= n; i++) {
            edge[i] = new LinkedList<>();
        }

        int start, end, weight;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            weight = Integer.parseInt(st.nextToken());
            edge[start].add(new Node(end, weight));
            edge[end].add(new Node(start, weight));
        }

        int portal1, portal2;
        st = new StringTokenizer(br.readLine());
        portal1 = Integer.parseInt(st.nextToken());
        portal2 = Integer.parseInt(st.nextToken());

        int[] dist1 = new int[n + 1];                    // 시작정점 1 : 다익스트라 거리 저장
        int[] distP1 = new int[n + 1];                    // 시작정점 portal1 : 다익스트라 거리 저장
        int[] distP2 = new int[n + 1];                    // 시작정점 portal2 : 다익스트라 거리 저장
        Arrays.fill(dist1, INF);
        Arrays.fill(distP1, INF);
        Arrays.fill(distP2, INF);
        PriorityQueue<Node> pq = new PriorityQueue<>();     // 다익스트라 우선순위 큐 구현

        dijkstra(1, edge, dist1, pq);
        dijkstra(portal1, edge, distP1, pq);
        dijkstra(portal2, edge, distP2, pq);

        int sum1, sum2;
        sum1 = dist1[portal1] + distP1[portal2] + distP2[n];
        sum2 = dist1[portal2] + distP2[portal1] + distP1[n];

        if (sum1 >= INF && sum2 >= INF) System.out.println(-1);
        else System.out.println(sum1 > sum2 ? sum2 : sum1);
    }

    private static void dijkstra(int start, List<Node>[] edge, int[] dist, PriorityQueue<Node> pq) {
        dist[start] = 0;
        pq.offer(new Node(start, dist[start]));                             // 모든 간선을 pq에 담기때문에 메모리 효율이 안좋음 -> visited 처리하고 가장 짧은 간선으로 다음 노드를 탐색하도록 했으면 더 좋음

        Node now;
        while (!pq.isEmpty()) {
            now = pq.poll();

            if (now.weight > dist[now.next])
                continue;
            for (Node nextNode : edge[now.next]) {
                if (dist[nextNode.next] > dist[now.next] + nextNode.weight) {
                    dist[nextNode.next] = dist[now.next] + nextNode.weight;
                    pq.offer(new Node(nextNode.next, dist[nextNode.next]));
                }
            }
        }
    }
}

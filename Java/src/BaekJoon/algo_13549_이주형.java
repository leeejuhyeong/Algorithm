package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class algo_13549_이주형 {
    public static class Node implements Comparable<Node> {
        int location;
        int count;

        public Node(int location, int count) {
            this.location = location;
            this.count = count;
        }


        @Override
        public int compareTo(Node o) {
            return this.count - o.count;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        System.out.println(bfs(n, k));
    }

    private static int bfs(int n, int k) {
        if(n >= k) {
            return n - k;
        } else {
            PriorityQueue<Node> pq = new PriorityQueue<>();                 // 이동횟수가 적은 것부터 연산하도록
            boolean[] visited = new boolean[100001];
            pq.offer(new Node(n, 0));

            Node now;
            while(true) {
                now = pq.poll();
                visited[now.location] = true;
                if(now.location == k) {
                    break;
                }
                if(now.location + 1 <= 100000 && !visited[now.location + 1]) {
                    pq.offer(new Node(now.location + 1, now.count + 1));
                }
                if(now.location - 1 >= 0 && !visited[now.location - 1]) {
                    pq.offer(new Node(now.location - 1, now.count + 1));
                }
                if(now.location * 2 <= 100000 && !visited[now.location * 2]) {
                    pq.offer(new Node(now.location * 2, now.count));        // 순간이동은 이동횟수 증가X
                }
            }
            return now.count;
        }
    }
}
/*
0 0
답: 0

5 5
답: 0

100000 0
답: 100000

25000 100000
답: 0

2 1024
답: 0

99999 100000
답: 1

4 6
1

 */
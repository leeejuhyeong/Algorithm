package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class algo_1753_이주형 {
    public static class Node implements Comparable<Node>{
        int end, weight;        // 도착지점, 가중치

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int INFINITY = Integer.MAX_VALUE;

        int v = Integer.parseInt(st.nextToken());   // 정점의 개수
        int e = Integer.parseInt(st.nextToken());   // 간선의 개수

        int k = Integer.parseInt(br.readLine());    // 시작 정점

        ArrayList<Node>[] matrix = new ArrayList[v + 1];    // 인접 리스트

        for (int i = 1; i <= v; i++) {
            matrix[i] = new ArrayList<Node>();      // 인접리스트 초기화
        }

        int start, end, weight;
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            weight = Integer.parseInt(st.nextToken());

            matrix[start].add(new Node(end, weight));
        }

        int[] distance = new int[v + 1];                // 가중치 배열
        boolean[] visited = new boolean[v + 1];         // 방문 체크 배열
        Arrays.fill(distance, INFINITY);                // 가중치 MAXVAULE로 초기화
        distance[k] = 0;                                // 시작지점

        // 1. 우선순위 큐 사용
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(k, 0));

        while(!pq.isEmpty()){
            Node current = pq.poll();
            int next = current.end;

            if(visited[next]) continue;
            visited[next] = true;

            for(Node node : matrix[next]){
                if(distance[node.end] > distance[next] + node.weight){
                    distance[node.end] = node.weight + distance[next];
                    pq.add(new Node(node.end, distance[node.end]));
                }
            }
        }

        // 2. 기존 배운것 사용
//        int min = 0, current = 0;       // 거리 최소값, 최소 index 저장
//        for (int i = 1; i <= v; i++) {
//            min = INFINITY;
//            for (int j = 1; j <= v; j++) {
//                if (!visited[j] && distance[j] < min) {         // 방문하지 않은 정점이며 거리가 가장 작을 경우
//                    min = distance[j];
//                    current = j;
//                }
//            }
//
//            visited[current] = true;                        // 거리가 가장 작은 정점을 다음 이동 정점으로 선택
//
//            for(Node node : matrix[current]){
//                if(!visited[node.end] && node.weight + min < distance[node.end]){   // 이동한 정점에서 생겨나는 새로운 최단 경로가 기존경로보다 가중치가 낮을 경우
//                    distance[node.end] = node.weight + min;                     // 새로운 최단 경로로 갱신
//                }
//            }
//        }

        for(int i = 1; i <= v; i++){
            if(distance[i] == INFINITY) bw.append("INF");
            else bw.append(String.valueOf(distance[i]));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}

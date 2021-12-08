package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class algo_1967_이주형 {
    public static int endNode;
    public static int length;

    public static class Node {
        int end, weight;

        Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        List<Node>[] graph = new List[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        int start, end, weight;
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            weight = Integer.parseInt(st.nextToken());

            graph[start].add(new Node(end, weight));
            graph[end].add(new Node(start, weight));
        }

        boolean[] visited = new boolean[n + 1];
        visited[1] = true;
        length = 0;
        endNode = 1;        // 노드가 1개일 때도 있어서 루트로 초기화(안했을 경우 마지막테케에서 nullpoint)
        dfs(1, n, graph, visited, 0);       // 임의의 한 노드에서 출발
        visited = new boolean[n + 1];
        visited[endNode] = true;                    // endNode = 트리의 지름 중 하나
        dfs(endNode, n, graph, visited, 0);     // 트리의 지름 구하기
        System.out.println(length);
    }

    private static void dfs(int i, int n, List<Node>[] graph, boolean[] visited, int sum) {
        Node current;
        for (int j = 0; j < graph[i].size(); j++) {
            current = graph[i].get(j);
            if (!visited[current.end]) {
                visited[current.end] = true;
                dfs(current.end, n, graph, visited, sum + current.weight);
                visited[current.end] = false;
            }
        }

        if (length < sum) {
            length = sum;
            endNode = i;
        }
    }
}

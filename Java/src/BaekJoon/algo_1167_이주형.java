package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

// 찾아봤음.
public class algo_1167_이주형 {
    public static int result;
    public static int vertax;

    public static class Node {      // 노드 클래스로 저장하는 것이 시간 단축에 좋음.
        int end, weight;

        Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }

    private static void dfs(int sum, int node, List<Node>[] graph, boolean[] visited) {
        if (sum > result) {
            result = sum;
            vertax = node;
        }

        visited[node] = true;

//        Node current;
//        for (int i = 0; i < graph[node].size(); i++) {
//            current = graph[node].get(i);
//            if (!visited[current.end]) {
//                dfs(sum + current.weight, current.end, graph, visited);
//                visited[current.end] = true;
//            }
//        }

        for(Node current : graph[node]){            // 대신 LinkedList를 사용했다면 for Each문을 사용할 것
            if(!visited[current.end]){
                dfs(sum + current.weight, current.end, graph, visited);
                visited[current.end] = true;
            }
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        List<Node>[] graph = new List[n + 1];
        int start, end, edge;

        for (int i = 1; i <= n; i++) {
            graph[i] = new LinkedList<>();          // LinkedList를 사용해서 시간초과.. 탐색은 기본적으로 ArrayList를 사용하자
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            while (true) {
                end = Integer.parseInt(st.nextToken());
                if (end == -1) break;
                edge = Integer.parseInt(st.nextToken());
                graph[start].add(new Node(end, edge));
            }
        }

        boolean[] visited = new boolean[n + 1];
        result = Integer.MIN_VALUE;
        dfs(0, 1, graph, visited);      // 어느 노드든 가장 긴 길이의 노드를 탐색했을 때, 그것이 트리의 지름 중 한 부분의 노드.
        visited = new boolean[n + 1];
        dfs(0, vertax, graph, visited);     // 트리의 지름 중 한 부분의 노드를 알았으니 그 길이를 탐색
        System.out.println(result);
    }
}

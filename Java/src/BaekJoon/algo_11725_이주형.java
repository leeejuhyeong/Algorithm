package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class algo_11725_이주형 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int a, b;
        List<Integer>[] list = new List[n + 1];
        int[] visited = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            list[a].add(b);         //양쪽으로 해줌
            list[b].add(a);
        }

        visited[1] = 1;         // 1은 루트임으로 자기자신을 가르키도록 햇음
        for(int i : list[1]) {
            visited[i] = 1;     // 1과 연결되어있는 것들 = 자식, 그들의 루트(부모)를 1이라고 표시
            dfs(i, list, visited);  // 자식 탐색
        }

        for (int i = 2; i <= n; i++) {
            sb.append(visited[i]).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int parent, List<Integer>[] list, int[] visited) {
        for(int i : list[parent]) {         // parent와 연결되어 있는 수(i)는 자식이므로
            if(visited[i] == 0) {           // 0일때만(0이 아니라면 자식이아닌 부모)
                visited[i] = parent;        // i의 부모는 parent
                dfs(i, list, visited);
            }
        }
    }
}

/*

visited[7] = 0 / 1 0 6 0 0 0 0

1 6
6 3
3 5
4 1
2 4
4 7

     1
   4    6
 2  7     3
            5

2 부모 : 4
3 부모 : 6
4 부모 : 1
5 부모 : 3
6 부모 : 1
7 부모 : 4

 */
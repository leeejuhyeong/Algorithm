package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class algo_11724_이주형 {
    public static void make(int n, int[] vertax) {
        for (int i = 1; i <= n; i++) {
            vertax[i] = i;
        }
    }

    public static int find(int node, int[] vertax) {
        if (vertax[node] == node) return node;
        return vertax[node] = find(vertax[node], vertax);
    }

    public static void union(int a, int b, int[] vertax) {
        int aRoot = find(a, vertax);
        int bRoot = find(b, vertax);

        if (aRoot == bRoot) return;

        vertax[bRoot] = aRoot;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int start, end;
        int[] vertax = new int[n + 1];
        make(n, vertax);                // 서로소 집합 생성

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());

            union(start, end, vertax);      // 연결
        }

        int root;                       // 해당 집합의 root
        Set<Integer> set = new HashSet<>();     // 모든 노드의 root를 찾아 set에 추가.(중복이 제거되므로 set의 크기가 연결요소의 개수)
        for (int i = 1; i <= n; i++) {
            root = find(i, vertax);
            set.add(root);
        }
        System.out.println(set.size());
    }
}

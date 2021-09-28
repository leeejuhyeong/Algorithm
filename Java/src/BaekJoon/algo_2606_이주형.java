package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class algo_2606_이주형 {
    public static int[] networks;

    public static void make(int n) {
        for (int i = 1; i <= n; i++) {
            networks[i] = i;
        }
    }

    public static boolean union(int i, int j) {
        int iRoot = find(i);
        int jRoot = find(j);

        if (iRoot == jRoot) return false;

        networks[jRoot] = iRoot;
        return true;
    }

    public static int find(int i) {
        if (i == networks[i]) return i;
        return networks[i] = find(networks[i]);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        networks = new int[n + 1];

        make(n);            // 서로소 집합 생성

        int start, end;         // 출발점, 도착점

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());

            union(start, end);      // 연결
        }

        int root = find(1);     // 컴퓨터 1의 루트
        int cnt = 0;

        for (int i = 2; i <= n; i++) {
            if (find(i) == root) cnt++;     // 컴퓨터들의 루트를 조회하면서 같을 시 cnt 증가
        }

        System.out.println(cnt);

    }
}

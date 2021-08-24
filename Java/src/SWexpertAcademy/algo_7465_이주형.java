package SWexpertAcademy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class algo_7465_이주형 {
    private static void make(int n, int[] set) {
        for (int i = 1; i <= n; i++) {
            set[i] = i;
        }
    }

    private static int find(int a, int[] set) {
        if (a == set[a]) return a;

        return set[a] = find(set[a], set);
    }

    private static void union(int a, int b, int[] set) {
        int aRoot = find(a, set);
        int bRoot = find(b, set);

        if (aRoot == bRoot) return;
        set[bRoot] = aRoot;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        String[] input = null;

        for (int test_case = 1; test_case <= t; test_case++) {
            input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);                     // 전체 인원
            int m = Integer.parseInt(input[1]);                     // 지인관계의 수

            int[] set = new int[n + 1];                             // 서로소집합 초기화
            make(n, set);

            int a, b;
            for (int i = 0; i < m; i++) {
                input = br.readLine().split(" ");
                a = Integer.parseInt(input[0]);                     // 사람 a,
                b = Integer.parseInt(input[1]);                     // 사람 b는 지인관계

                union(a, b, set);
            }

            boolean[] root = new boolean[n + 1];                // 무리의 장 확인
            int cnt = 0;
            for (int i = 1; i <= n; i++) {
                if (!root[find(i, set)]) {                   // find를 통해 Root 반환, 해당 사람이 root일 시
                    root[find(i, set)] = true;               // true
                    cnt++;                                   // 새로운 무리이므로 cnt 증가
                }
            }
            bw.append("#").append(String.valueOf(test_case)).append(" ").append(String.valueOf(cnt));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}

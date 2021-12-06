package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class algo_1865_이주형 {
    public static class Node {
        int end, weight;

        Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());
        int n, m, w;
        int s, e, t;
        List<Node>[] list;                          // 도로, 웜홀 저장 리스트
        int[] dist;                                 // 최단 거리 배열
        boolean minusCycle;                         // 음의 순환 확인

        for (int test_case = 0; test_case < tc; test_case++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());               // 노드 개수
            m = Integer.parseInt(st.nextToken());               // 도로 개수
            w = Integer.parseInt(st.nextToken());               // 웜홀 개수

            list = new List[n + 1];
            for (int i = 1; i <= n; i++) {
                list[i] = new ArrayList<>();                    // 리스트 초기화
            }

            dist = new int[n + 1];
            for (int i = 0; i < m; i++) {                       // 도로 저장
                st = new StringTokenizer(br.readLine());
                s = Integer.parseInt(st.nextToken());           // 출발점
                e = Integer.parseInt(st.nextToken());           // 도착점
                t = Integer.parseInt(st.nextToken());           // 비용

                list[s].add(new Node(e, t));                    // 도로는 양방향임.
                list[e].add(new Node(s, t));
            }
            for (int i = 0; i < w; i++) {                       // 웜홀 저장
                st = new StringTokenizer(br.readLine());
                s = Integer.parseInt(st.nextToken());           // 출발점
                e = Integer.parseInt(st.nextToken());           // 도착점
                t = Integer.parseInt(st.nextToken());           // 비용

                list[s].add(new Node(e, -t));                   // 웜홀은 일방향이며 가중치는 음수로 저장
            }

            minusCycle = false;
            for (int i = 1; i <= n; i++) {                      // 모든 노드를 출발점으로
                if (ballman(i, n, list, dist)) {                // 음의 순환이 있다면
                    minusCycle = true;                          // true
                    bw.append("YES");
                    bw.newLine();
                    break;
                }
            }

            if (!minusCycle) {                                  // 음의 순환이 없을 때
                bw.append("NO");
                bw.newLine();
            }
        }
        bw.flush();
        bw.close();
    }

    private static boolean ballman(int i, int n, List<Node>[] list, int[] dist) {
        Arrays.fill(dist, Integer.MAX_VALUE);               // 모든 경로를 무한대로 초기화
        boolean flag = true;                                // 경로 변경이 일어나면 flase, 일어나지 않았다면 true
        dist[i] = 0;
        List<Node> current;                                 // 현재 노드 저장

        for (int j = 1; j < n; j++) {                       // n - 1번 탐색
            flag = true;

            for (int k = 1; k <= n; k++) {
                current = list[k];                          // 현재 노드(지점)
                for (int l = 0; l < current.size(); l++) {  // 현재 노드(지점)과 연결된 도로 또는 웜홀 탐색
                    if (dist[k] != Integer.MAX_VALUE && dist[current.get(l).end] > dist[k] + current.get(l).weight) {   // 다음 노드로의 경로가 더 짧다면
                        dist[current.get(l).end] = dist[k] + current.get(l).weight;             // 변경
                        flag = false;               // 변경이 일어났으므로 false로 변경
                    }
                }
            }

            if (flag) break;                        // 변경이 더이상 일어나지 않으면 for문 탈출(음의 순환이 존재하지 않음)
        }

        if (!flag) {                                // n-1번 반복하고도 변경이 있었다면 => 1번 더 반복해서 변경이 일어나면 음의 순환 존재!
            for (int k = 1; k <= n; k++) {
                current = list[k];
                for (int l = 0; l < current.size(); l++) {
                    if (dist[k] != Integer.MAX_VALUE && dist[current.get(l).end] > dist[k] + current.get(l).weight) {   // 변경이 일어난다면
                        return true;                // 음의 순환이 있으므로 true 반환
                    }
                }
            }
        }

        return false;                           // 음의 순환이 없으므로 false 반환
    }
}

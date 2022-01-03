package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

// 다익스트라 -> SwexpertAcademy에서 풀었던 문제
public class algo_1916_이주형 {
    public static class Bus {
        int to;
        int weight;

        Bus(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        List<Bus>[] buses = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            buses[i] = new LinkedList<>();
        }

        StringTokenizer st;

        int go, to, weight;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            go = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            weight = Integer.parseInt(st.nextToken());

            buses[go].add(new Bus(to, weight));
        }

        st = new StringTokenizer(br.readLine());
        go = Integer.parseInt(st.nextToken());
        to = Integer.parseInt(st.nextToken());

        System.out.println(dijkstra(go, to, n, m, buses));

    }

    private static long dijkstra(int go, int to, int n, int m, List<Bus>[] buses) {
        long[] dist = new long[n + 1];
        boolean[] visited = new boolean[n + 1];
        long max = 10000000000L;
        Arrays.fill(dist, max);
        dist[go] = 0;
        int idx = go;
        long min;

        while (true) {
            for (Bus bus : buses[idx]) {
                if (dist[bus.to] > dist[idx] + bus.weight) {
                    dist[bus.to] = dist[idx] + bus.weight;
                }
            }

            visited[idx] = true;
            min = max;

            for (int i = 1; i <= n; i++) {
                if (!visited[i] && min > dist[i]) {
                    min = dist[i];
                    idx = i;
                }
            }
            if (min == max)
                break;
        }

        return dist[to];
    }
}

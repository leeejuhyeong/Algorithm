package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class algo_11779_이주형 {
    public static class Bus {
        int to;
        int weight;

        public Bus(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        // 도시 방문 저장 배열
        int[] cities = new int[n + 1];
        // 버스 리스트 초기화
        List<Bus>[] buses = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            buses[i] = new ArrayList<>();
        }

        // 버스 초기화
        int from, to, weight;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            weight = Integer.parseInt(st.nextToken());
            buses[from].add(new Bus(to, weight));
        }

        int start, end;
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        StringBuilder result = dijkstra(start, end, n, cities, buses);
        System.out.println(result);
    }

    private static StringBuilder dijkstra(int start, int end, int n, int[] cities, List<Bus>[] buses) {
        int MAX = 100000000;
        boolean[] visited = new boolean[n + 1];     // 방문 처리
        int[] dist = new int[n + 1];
        Arrays.fill(dist, MAX);

        PriorityQueue<Bus> pq = new PriorityQueue<>(new Comparator<Bus>() {
            @Override
            public int compare(Bus o1, Bus o2) {
                return o1.weight - o2.weight;
            }
        });
        dist[start] = 0;
        pq.offer(new Bus(start, 0));

        Bus now;
        while (!pq.isEmpty()) {
            now = pq.poll();        // 현재 도시

            if (visited[now.to]) {
                continue;
            }
            visited[now.to] = true;

            for (Bus bus : buses[now.to]) {     // bus = 다음 도시
                if (dist[bus.to] > dist[now.to] + bus.weight) {
                    dist[bus.to] = dist[now.to] + bus.weight;
                    pq.offer(new Bus(bus.to, dist[bus.to]));

                    cities[bus.to] = now.to;        // bus.to(다음 도시)는 now.to(현재 도시)에서 왔다고 저장
                }
            }
        }

        // 방문도시 순서, 개수 저장
        int count = 0;
        int pre = end;
        List<Integer> city = new LinkedList<>();
        while (pre != start) {
            city.add(0, pre);
            pre = cities[pre];
            count++;
        }
        city.add(0, start);
        count++;

        StringBuilder result = new StringBuilder();
        result.append(dist[end]).append("\n").append(count).append("\n");
        for (Integer integer : city) {
            result.append(integer).append(" ");
        }

        return result;
    }
}

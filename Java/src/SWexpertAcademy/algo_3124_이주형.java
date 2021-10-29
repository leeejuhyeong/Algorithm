package SWexpertAcademy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class algo_3124_이주형 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        int v, e;
        int start, end, weight;
        long result;
        boolean[] visited;          // 방문 처리
        int[] minVertax;            // 최단거리
        List<int[]>[] vertax;


        int t = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= t; test_case++) {
            st = new StringTokenizer(br.readLine());
            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            vertax = new List[v+1];
            result = 0;

            for(int i = 1; i <= v; i++){
                vertax[i] = new ArrayList<int[]>();
            }

            int startMin, startNode;
            startMin = startNode = Integer.MAX_VALUE;

            for(int i = 0; i < e; i++){
                st = new StringTokenizer(br.readLine());
                start = Integer.parseInt(st.nextToken());
                end = Integer.parseInt(st.nextToken());
                weight = Integer.parseInt(st.nextToken());

                vertax[start].add(new int[]{end, weight});
                vertax[end].add(new int[]{start, weight});
                if(startMin > weight){
                    startMin = weight;
                    startNode = start;
                }
            }

            minVertax = new int[v+1];
            visited = new boolean[v+1];
            Arrays.fill(minVertax, Integer.MAX_VALUE);
            minVertax[startNode] = 0;

            PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[1] - o2[1];
                }
            });
            pq.add(new int[]{startNode, 0});

            while(!pq.isEmpty()){
                int[] current = pq.poll();
                int next = current[0];

                if(visited[next]) continue;

                visited[next] = true;
                result += minVertax[next];

                for(int[] arr : vertax[next]){
                    if(minVertax[arr[0]] > arr[1]){
                        minVertax[arr[0]] = arr[1];
                        pq.add(arr);
                    }
                }
            }
            bw.append("#").append(String.valueOf(test_case)).append(" ").append(String.valueOf(result));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
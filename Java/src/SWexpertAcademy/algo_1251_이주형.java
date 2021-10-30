package SWexpertAcademy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class algo_1251_이주형 {
    static long result = 0;
    public static class Island{
        int to;
        long weight;

        Island(){};
        Island(int to, long weight){
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        int t = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= t; test_case++) {
            int n = Integer.parseInt(br.readLine());
            int[][] islands = new int[n][2];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++){
                islands[i][0] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++){
                islands[i][1] = Integer.parseInt(st.nextToken());
            }

            double e = Double.parseDouble(br.readLine());

            ArrayList<Island>[] list = new ArrayList[n];
            long min = Long.MAX_VALUE;
            long xlen, ylen;
            int startidx = 0;
            for(int i = 0; i < n; i++){
                list[i] = new ArrayList<>();
                for(int j = 0; j < n; j++){
                    if(i == j) continue;
                    xlen = (long) Math.pow(islands[i][0] - islands[j][0], 2);
                    ylen = (long) Math.pow(islands[i][1] - islands[j][1], 2);
                    long temp = xlen + ylen;
                    if(min > temp) {
                        min = temp;
                        startidx = i;
                    }
                    list[i].add(new Island(j, temp));
                }
            }

            boolean[] visited = new boolean[n];
            long[] distance = new long[n];
            Arrays.fill(distance, Long.MAX_VALUE);
            distance[0] = 0;
            prim(startidx, n, visited, list, distance);

            bw.append("#").append(String.valueOf(test_case)).append(" ").append(String.valueOf(Math.round(result * e)));
            bw.newLine();
            result = 0;
        }
        bw.flush();
        bw.close();
    }

    public static void prim(int startidx, int n, boolean[] visited, ArrayList<Island>[] list, long[] distance){
        int cnt = 0;
        while(true){
            long min = Long.MAX_VALUE;
            int minidx = 0;

            for(int i = 0; i < n; i++){
                if(!visited[i] && min > distance[i]){
                    min = distance[i];
                    minidx = i;
                }
            }

            result += min;
            visited[minidx] = true;
            if(++cnt == n) break;

            int to;
            for(int i = 0; i < list[minidx].size(); i++){
                Island next = list[minidx].get(i);
                if (!visited[next.to] && distance[next.to] > next.weight) {
                    distance[next.to] = next.weight;
                }
            }
        }
    }
}

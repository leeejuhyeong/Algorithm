package SWexpertAcademy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class algo_1865_이주형 {
    public static double result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n;
        double input;
        double[][] work;
        int t = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= t; test_case++) {
            n = Integer.parseInt(br.readLine());
            work = new double[n][n];
            result = 0;

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    input = Double.parseDouble(st.nextToken());
                    work[i][j] = input / 100.0;
                }
            }

            boolean[] visited = new boolean[n];
            dfs(0, n, work, visited, 1.0);
            bw.write("#" + test_case + " " + String.format("%6f", result * 100) + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static void dfs(int level, int n, double[][] work, boolean[] visited, double sum) {
        if (level == n) {
            result = result < sum ? sum : result;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                if(sum * work[level][i] != 0 && sum * work[level][i] >= result)
                    dfs(level + 1, n, work, visited, sum * work[level][i]);
                visited[i] = false;
            }
        }
    }
}

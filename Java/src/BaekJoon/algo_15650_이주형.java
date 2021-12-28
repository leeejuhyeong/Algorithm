package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class algo_15650_이주형 {
    public static void main2(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2;
        int[] numbers = new int[n];
        int[] visited = new int[n];         // np 조합 배열

        for (int i = 0; i < n; i++) {
            numbers[i] = i + 1;
        }

        int count = 1;
        while (count <= m) visited[n - count++] = 1;        // 0 0 0 1 1 -> 1 1 0 0 0

        do {
            sb2 = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if (visited[i] == 1) {
                    sb2.append(numbers[i]).append(" ");
                }
            }
            sb2.append("\n");
            sb.insert(0, sb2);          // np로 m개를 뽑을 때 4, 3이라면 2 3 4부터 출력되기 때문에 이전보다 앞에 넣어줌
        } while (np(n, m, visited));
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }

    private static boolean np(int n, int m, int[] visited) {
        int i = n - 1;
        while (i > 0 && visited[i - 1] >= visited[i]) i--;
        if (i == 0) return false;

        int j = n - 1;
        while (visited[i - 1] >= visited[j]) j--;
        swap(i - 1, j, visited);

        int k = n - 1;
        while (i < k) swap(i++, k--, visited);
        return true;
    }

    private static void swap(int i, int j, int[] visited) {
        int temp = visited[i];
        visited[i] = visited[j];
        visited[j] = temp;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] numbers = new int[m];
        boolean[] visited = new boolean[n];
        StringBuilder sb = new StringBuilder();

        permu(0, 0, n, m, numbers, visited, sb);
        System.out.println(sb);
    }

    private static void permu(int start, int level, int n, int m, int[] numbers, boolean[] visited, StringBuilder sb) {
        if(level == m) {
            for (int i = 0; i < m; i++) {
                sb.append(numbers[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = start; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                numbers[level] = i + 1;
                permu(i, level + 1, n, m, numbers, visited, sb);
                visited[i] = false;
            }
        }
    }
}
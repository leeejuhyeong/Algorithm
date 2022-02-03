package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class algo_15657_이주형 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] numbers = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbers);

        int[] permu = new int[m];
        permutation(0, 0, n, m, numbers, permu, bw);
        bw.flush();
        bw.close();
    }

    private static void permutation(int start, int level, int n, int m, int[] numbers, int[] permu, BufferedWriter bw) throws Exception {
        if (level == m) {
            for (Integer integer : permu) {
                bw.write(integer + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = start; i < n; i++) {
            permu[level] = numbers[i];
            permutation(i, level + 1, n, m, numbers, permu, bw);
        }
    }
}
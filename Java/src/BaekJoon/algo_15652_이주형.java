package BaekJoon;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class algo_15652_이주형 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Stack<Integer> stack = new Stack<>();
        permutation(1, 0, n, m, stack, bw);

        bw.flush();
        bw.close();
    }

    private static void permutation(int start, int level, int n, int m, Stack<Integer> stack, BufferedWriter bw) throws Exception {
        if (level == m) {
            for (Integer integer : stack) {
                bw.write(integer + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = start; i <= n; i++) {
            stack.push(i);
            permutation(i, level + 1, n, m, stack, bw);
            stack.pop();
        }
    }
}

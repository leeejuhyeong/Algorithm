package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class algo_2263_이주형 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        int[] in;
        int[] post;
        int[] inIndex = new int[n + 1];

        in = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        post = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < n; i++) {
            inIndex[in[i]] = i;
        }
        solve(0, n - 1, 0, n - 1, sb, in, post, inIndex);
        System.out.println(sb);
    }

    public static void solve(int inStart, int inEnd, int postStart, int postEnd, StringBuilder sb, int[] in, int[] post, int[] inIndex) {
        if (inStart > inEnd || postStart > postEnd) return;
        int root = post[postEnd];                         // in에서 루트의 index
        sb.append(root).append(" ");
        int inRoot = inIndex[root];                             // 루트의 in에서의 Index
        int leftSize = inIndex[root] - 1 - inStart + 1;        // in에서 루트의 왼쪽 노드들의 개수

        solve(inStart, inRoot - 1, postStart, leftSize + postStart - 1, sb, in, post, inIndex);
        solve(inRoot + 1, inEnd, leftSize + postStart, postEnd - 1, sb, in, post, inIndex);
    }
}

/*
7
4 2 7 5 1 3 6
4 7 5 2 6 3 1
 */
package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class algo_1991_이주형 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();

        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        Map<Character, char[]> tree = new HashMap<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            tree.put(st.nextToken().charAt(0), new char[]{st.nextToken().charAt(0), st.nextToken().charAt(0)});
        }

        dfs('A', tree, sb1, sb2, sb3);
        bw.append(sb1);
        bw.newLine();
        bw.append(sb2);
        bw.newLine();
        bw.append(sb3);
        bw.flush();
        bw.close();
    }

    private static void dfs(char i, Map<Character, char[]> tree, StringBuilder sb1, StringBuilder sb2, StringBuilder sb3) {
        sb1.append(i);      // 전위
        char[] current = tree.get(i);


        if (current[0] != '.') {
            dfs(current[0], tree, sb1, sb2, sb3);
        }


        sb2.append(i);      // 중위


        if (current[1] != '.') {
            dfs(current[1], tree, sb1, sb2, sb3);
        }


        sb3.append(i);      // 후위
    }
}

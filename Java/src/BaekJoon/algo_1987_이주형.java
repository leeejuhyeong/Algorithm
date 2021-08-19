package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class algo_1987_이주형 {
    static int[][] deep = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static char[][] map;
    static boolean[] alph;
    static int result;
    static int r;
    static int c;

    public static void dfs(int row, int col, int cnt) {
        int moveR;
        int moveC;
        for (int k = 0; k < 4; k++) {
            moveR = row + deep[k][0];
            moveC = col + deep[k][1];
            if (moveR >= 0 && moveR < r && moveC >= 0 && moveC < c && !alph[map[moveR][moveC] - 'A']) {
                alph[map[moveR][moveC] - 'A'] = true;
                dfs(moveR, moveC, cnt + 1);
                alph[map[moveR][moveC] - 'A'] = false;
            }
        }
        result = Math.max(result, cnt);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        r = Integer.parseInt(input[0]);
        c = Integer.parseInt(input[1]);

        map = new char[r][c];

        for (int i = 0; i < r; i++) {
            String temp = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = temp.charAt(j);
            }
        }

        alph = new boolean[26];
        alph[map[0][0] - 'A'] = true;
        result = Integer.MIN_VALUE;

        dfs(0, 0, 1);
        System.out.println(result);
    }
}

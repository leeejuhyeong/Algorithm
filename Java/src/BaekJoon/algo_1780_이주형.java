package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class algo_1780_이주형 {
    public static int[] result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];

//        for (int i = 0; i < n; i++) {
//            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();       // 오히려 속도면에서 떨어짐!!
//        }
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());       // 초기화
            }
        }

        result = new int[3];
        go(0, 0, map, n);       // 나누기 시작
        for (int r : result) {
            bw.write(r + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static void go(int r, int c, int[][] map, int n) {
        if (!check(r, c, map, n, map[r][c])) {              // false라면 9분할
            int range = n / 3;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    go(r + range * i, c + range * j, map, range);
                }
            }
        } else {
            switch (map[r][c]) {
                case -1:
                    result[0]++;
                    break;
                case 0:
                    result[1]++;
                    break;
                case 1:
                    result[2]++;
                    break;
            }
        }
    }

    private static boolean check(int r, int c, int[][] map, int n, int paper) { // 다같은 종이인지 확인
        for (int i = r; i < r + n; i++) {
            for (int j = c; j < c + n; j++) {
                if (map[i][j] != paper)     // 아니라면 false
                    return false;
            }
        }
        return true;
    }
}

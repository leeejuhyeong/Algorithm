package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class algo_1012_이주형 {
    public static int[] movex = {-1, 1, 0, 0};
    public static int[] movey = {0, 0, -1, 1};

    public static void change(int i , int j , boolean[][] map){
        map[i][j] = false;
        for(int m = 0; m < 4; m++){
            if(map[i + movex[m]][j + movey[m]]) change(i + movex[m], j + movey[m], map);
        }
    }

    public static int howmanyworms(int row, int col, boolean[][] map, int result) {
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if(map[i][j]) {
                    change(i, j, map);
                    result++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        int t = Integer.parseInt(br.readLine());
        int row, col, k;   // 배추밭의 크기, 개수
        boolean[][] map;    // 배추 좌표 저장 배열
        int result;

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            row = Integer.parseInt(st.nextToken());
            col = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            map = new boolean[row + 2][col + 2];
            int r, c;

            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                r = Integer.parseInt(st.nextToken());
                c = Integer.parseInt(st.nextToken());
                map[r + 1][c + 1] = true;
            }

            result = 0;
            result = howmanyworms(row, col, map, result);
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}

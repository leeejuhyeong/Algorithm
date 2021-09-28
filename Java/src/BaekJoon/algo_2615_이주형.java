package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class algo_2615_이주형 {
    public static int[] xmove = {-1, 1, 1, 0};
    public static int[] ymove = {1, 0, 1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] map = new int[21][21];
        int winner = 0;

        for (int i = 1; i < 20; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j < 20; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int color, x, y;
        x = y = 0;
        int realx, realy;
        realx = realy = Integer.MAX_VALUE;

        Loop:
        for (int i = 1; i < 20; i++) {
            for (int j = 1; j < 20; j++) {
                color = map[i][j];

                if (color != 0) {
                    for (int m = 0; m < 4; m++) {
                        if (map[i + xmove[m]][j + ymove[m]] == color) {
                            if (five(i, j, m, map)) {
                                winner = color;
                                x = i;
                                y = j;

                                while (color == map[x][y]) {
                                    if(realy > y){
                                        realx = x;
                                        realy = y;
                                    }
                                    x += xmove[m];
                                    y += ymove[m];
                                }

                                x = i - xmove[m];
                                y = j - ymove[m];
                                while (color == map[x][y]) {
                                    if(realy > y){
                                        realx = x;
                                        realy = y;
                                    }
                                    x -= xmove[m];
                                    y -= ymove[m];
                                }
                                break Loop;
                            }
                        }
                    }
                }
            }
        }

        System.out.println(winner);
        if (winner != 0) {
            System.out.println(realx + " " + realy);
        }

    }

    public static boolean five(int i, int j, int m, int[][] map) {
        int count = 0;
        int x = i;
        int y = j;
        int color = map[i][j];

        while (color == map[x][y]) {
            count++;
            x += xmove[m];
            y += ymove[m];
        }
        x = i - xmove[m];
        y = j - ymove[m];

        while (color == map[x][y]) {
            count++;
            x -= xmove[m];
            y -= ymove[m];
        }

        return count == 5;
    }
}
package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class algo_7569_이주형 {
    public static int r, c, h;
    public static int[] moveR = {-1, 1, 0, 0, 0, 0};
    public static int[] moveC = {0, 0, -1, 1, 0, 0};
    public static int[] moveH = {0, 0, 0, 0, -1, 1};

    public static class Tomato {
        int row, col, height;

        Tomato(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        c = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        int count = 0;
        int[][][] boxes = new int[r][c][h];
        Queue<Tomato> queue = new LinkedList<>();

        for (int k = 0; k < h; k++) {
            for (int i = 0; i < r; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < c; j++) {
                    boxes[i][j][k] = Integer.parseInt(st.nextToken());
                    switch (boxes[i][j][k]) {
                        case -1:
                            count++;
                            break;
                        case 1:
                            count++;
                            queue.offer(new Tomato(i, j, k));
                            break;
                    }

                }
            }
        }

        int result = 0;
        int all = r * c * h;
        if (count == all) {
            System.out.println(0);
        } else {
            while (count != all && !queue.isEmpty()) {
                int size = queue.size();
                for (int d = 0; d < size; d++) {
                    Tomato current = queue.poll();      // 현재 토마토
                    int nextR, nextC, nextH;
                    for (int j = 0; j < 6; j++) {       // 4방 탐색
                        nextR = current.row + moveR[j];
                        nextC = current.col + moveC[j];
                        nextH = current.height + moveH[j];
                        if (isRange(nextR, nextC, nextH) && boxes[nextR][nextC][nextH] == 0) { // 익은 토마토 주변에 있는 안익은 토마토 체크
                            boxes[nextR][nextC][nextH] = 1;                          // 해당 토마토를 더이상 탐색하지않도록 1로 변경(visited 처리)
                            count++;
                            queue.offer(new Tomato(nextR, nextC, nextH));
                        }
                    }
                }
                result++;
            }
            if (count == all) System.out.println(result);     // 모든 토마토들이 익었다면 경과한 시간 출력
            else System.out.println(-1);
        }
    }

    public static boolean isRange(int i, int j, int k) {
        return i >= 0 && i < r && j >= 0 && j < c && k >= 0 && k < h;
    }

}

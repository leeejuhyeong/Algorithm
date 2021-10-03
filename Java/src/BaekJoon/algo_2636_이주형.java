package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class algo_2636_이주형 {

    // 공기가 있는 부분 탐색 -> 맞닿은 부분 녹이기
    // 전체 치즈가 녹을 때 까지 반복

    public static int row, col;
    public static int[] movex = {-1, 1, 0, 0};
    public static int[] movey = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        int[][] cheese = new int[row][col];
        boolean[][] visited = new boolean[row][col];
        int count = 0;                  // 전체 치즈 개수
        int time = 0;                   // 시간

        for (int r = 0; r < row; r++) {         // cheese 배열 초기화
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < col; c++) {
                cheese[r][c] = Integer.parseInt(st.nextToken());
                if (cheese[r][c] == 1) {
                    count++;
                }
            }
        }

        Queue<int[]> queue = new LinkedList<>();        // bfs
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;
        int size;
        int melt = 0;
        int[] next;
        int nextR, nextC;   // 다음 이동

        while (count > 0) {                          // 모든 치즈가 녹을 때 까지 반복
            melt = 0;                               // 1시간 후 녹을 치즈 개수
            while (!queue.isEmpty()) {      // bfs
                size = queue.size();
                for (int i = 0; i < size; i++) {
                    next = queue.poll();

                    for (int j = 0; j < 4; j++) {
                        nextR = next[0] + movex[j];
                        nextC = next[1] + movey[j];
                        if ((nextR >= 0 && nextR < row && nextC >= 0 && nextC < col) && !visited[nextR][nextC]) {       // 배열의 범위를 벗어나지 않을 때
                            if (cheese[nextR][nextC] == 0) {      // 지나왓던 길이 아니고, 0이다(공기가 있는 곳)
                                queue.offer(new int[]{nextR, nextC});
                            } else {      // 공기와 맞닿은 치즈일 경우
                                cheese[nextR][nextC] = 0;                                   // 녹아내림
                                melt++;
                            }
                            visited[nextR][nextC] = true;
                        }
                    }
                }
            }
            count -= melt;                  // 전체 치즈 개수 - 녹아내린 개수
            time++;
            visited = new boolean[row][col];
            queue.offer(new int[]{0, 0});
        }
        System.out.println(time);
        System.out.println(melt);
    }
}

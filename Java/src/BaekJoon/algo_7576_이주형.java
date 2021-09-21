package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class algo_7576_이주형 {
    public static int m, n;
    public static int[][] box;
    public static int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static class Tomato {
        int row;
        int col;

        Tomato(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        box = new int[n][m];
        Queue<Tomato> queue = new LinkedList<>();
        int count = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                switch (box[i][j]) {
                    case -1:                                // 토마토가 들어있지 않은 칸 확인
                        count++;
                        break;
                    case 1:
                        queue.offer(new Tomato(i, j));      // 익은 토마토의 위치 queue에 저장
                        count++;                            // 익은 토마토 개수 확인
                        break;
                }
            }
        }

        int size;
        int result = 0;
        if (count != m * n) {                       // 익은 토마토 개수 + 토마토가 들어있지 않은 칸의 합이 상자의 크기와 같지 않을 때
            while (count != m * n && !queue.isEmpty()) {              // BFS 탐색
                size = queue.size();
                for (int i = 0; i < size; i++) {
                    Tomato current = queue.poll();      // 현재 토마토
                    int nextR, nextC;
                    for (int j = 0; j < 4; j++) {       // 4방 탐색
                        nextR = current.row + move[j][0];
                        nextC = current.col + move[j][1];
                        if (isRange(nextR, nextC) && box[nextR][nextC] == 0) { // 익은 토마토 주변에 있는 안익은 토마토 체크
                            box[nextR][nextC] = 1;                          // 해당 토마토를 더이상 탐색하지않도록 1로 변경(visited 처리)
                            count++;
                            queue.offer(new Tomato(nextR, nextC));
                        }
                    }
                }
                result++;                           // 하루가 지날때마다 result 증가
            }
            if (count == m * n) System.out.println(result);     // 모든 토마토들이 익었다면 경과한 시간 출력
            else System.out.println(-1);                    // 그렇지 않다면 -1 출력
        } else {
            System.out.println(0);          // 모든 토마토들이 이미 익어있다면 0 출력
        }
    }

    public static boolean isRange(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < m;
    }
}

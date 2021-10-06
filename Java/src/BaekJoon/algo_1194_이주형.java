package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class algo_1194_이주형 {
    public static int[] moveR = {-1, 1, 0, 0};
    public static int[] moveC = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String input;
        char[][] map = new char[n][m];                          // 미로 배열
        Queue<int[]> queue = new LinkedList<>();                // bfs 탐색
        boolean[][][] visited = new boolean[n][m][1 << 6];      // 방문처리

        for (int i = 0; i < n; i++) {
            input = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = input.charAt(j);
                if (map[i][j] == '0') {
                    queue.offer(new int[]{i, j, 0});        // 현재 위치 큐에 저장
                    visited[i][j][0] = true;                // 방문처리
                    map[i][j] = '.';
                }
            }
        }

        int size, nextR, nextC; // 큐 사이즈, 다음 이동(행, 열)
        int result = 0;         // 결과값
        int[] current;          // queue에서 빼낸 현재 위치
        boolean flag = false;   // while문 탈출 flag
        while (!queue.isEmpty() && !flag) {
            size = queue.size();
            Loop:
            for (int i = 0; i < size; i++) {
                current = queue.poll();

                for (int j = 0; j < 4; j++) {
                    nextR = current[0] + moveR[j];
                    nextC = current[1] + moveC[j];
                    if (!isRange(nextR, nextC, n, m) || visited[nextR][nextC][current[2]])  // 배열 범위 벗어나거나, 방문한 곳 재방문 방지
                        continue;
                    // 벽
                    if (map[nextR][nextC] == '#') continue;     // 이동 불가능
                        // 빈공간
                    else if (map[nextR][nextC] == '.') {
                        queue.offer(new int[]{nextR, nextC, current[2]});   // 이동
                        visited[nextR][nextC][current[2]] = true;           // 방문처리
                    }
                    // 열쇠
                    else if (map[nextR][nextC] >= 'a' && map[nextR][nextC] <= 'f') {
                        int key = 1 << (map[nextR][nextC] - 'a');                   // 키 확인
                        queue.offer(new int[]{nextR, nextC, current[2] | key});     // 키 습득
                        visited[nextR][nextC][current[2] | key] = true;             // 방문 처리
                    }
                    // 문
                    else if (map[nextR][nextC] >= 'A' && map[nextR][nextC] <= 'F') {
                        int lock = 1 << (map[nextR][nextC] - 'A');
                        if ((lock & current[2]) != 0) {                             // 문에 해당하는 키 존재 확인
                            queue.offer(new int[]{nextR, nextC, current[2]});       // 이동
                            visited[nextR][nextC][current[2]] = true;               // 방문 처리
                        }
                    }
                    // 탈출
                    else if (map[nextR][nextC] == '1') {            // 탈출구
                        flag = true;
                        break Loop;
                    }
                }
            }
            result++;
        }
        if (flag) System.out.println(result);
        else System.out.println(-1);
    }

    private static boolean isRange(int i, int j, int n, int m) {
        return i >= 0 && j >= 0 && i < n && j < m;
    }
}

package SWexpertAcademy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// SWExpertAcademy
public class algo_1953_이주형 {
    public static int[][] moveR = {{}, {-1, 1, 0, 0}, {-1, 1}, {0, 0}, {-1, 0}, {1, 0}, {1, 0}, {-1, 0}};
    public static int[][] moveC = {{}, {0, 0, -1, 1}, {0, 0}, {-1, 1}, {0, 1}, {0, 1}, {0, -1}, {0, -1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        int n, m, r, c, l;
        int[][] map;

        for (int test_case = 1; test_case <= t; test_case++) {
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            l = Integer.parseInt(st.nextToken());

            map = new int[n][m];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            bw.append("#").append(String.valueOf(test_case)).append(" ").append(String.valueOf(bfs(n, m, r, c, l, map)));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    private static int bfs(int n, int m, int r, int c, int l, int[][] map) {
        int result = 1, size, nextR, nextC;                 // 결과값, queue사이즈, 다음 행, 열
        boolean[][] visited = new boolean[n][m];            // 방문 처리
        Queue<int[]> queue = new LinkedList<>();            // BFS

        queue.offer(new int[]{r, c});                       // 맨홀 저장
        visited[r][c] = true;                               // 방문 처리

        int[] current;                                      // 현재 위치
        int currentPip, nextPip;                            // 현재 위치의 파이프, 다음 위치의 파이프
        while (l > 1) {                                     // 맨홀에 들어가고 1시간 뒤에 파이프 도착하기 때문에 1이상으로 처리
            size = queue.size();                            // 해당 시간동안 움직일 수 있는 모든 방향 반복
            for (int i = 0; i < size; i++) {
                current = queue.poll();                     // 현재 위치
                currentPip = map[current[0]][current[1]];       // 현재 위치의 파이프 형태(이동 방향)
                for (int j = 0; j < moveR[currentPip].length; j++) {
                    nextR = current[0] + moveR[currentPip][j];      // 다음 행
                    nextC = current[1] + moveC[currentPip][j];      // 다음 열

                    if (!isRange(nextR, nextC, n, m) || visited[nextR][nextC] && map[nextR][nextC] != 0) continue;      // 범위 벗어낫을 경우 무시

                    nextPip = map[nextR][nextC];            // 이동 시의 파이프
                    boolean flag = true;
                    for (int k = 0; k < moveR[nextPip].length; k++) {               // 이동하려는 장소의 파이프가 연결되어 있는지 확인
                        if (nextR + moveR[nextPip][k] == current[0] && nextC + moveC[nextPip][k] == current[1]) flag = false;   // 연결되어있을경우 false
                    }
                    if (flag) continue;                             // 연결되어 있지 않을경우 기존의 true이므로 무시

                    queue.offer(new int[]{nextR, nextC});
                    visited[nextR][nextC] = true;
                    result++;
                }
            }
            l--;
        }

        return result;
    }

    private static boolean isRange(int r, int c, int n, int m) {
        return r >= 0 && c >= 0 && r < n && c < m;
    }
}
package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class algo_1600_이주형 {
//    public static int[] moveX = {-1, 1, 0, 0, -2, -2, -1, 1, 2, 2, 1, -1};
//    public static int[] moveY = {0, 0, -1, 1, -1, 1, 2, 2, 1, -1, -2, -2};
//
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int k = Integer.parseInt(br.readLine());
//
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        int row = Integer.parseInt(st.nextToken());
//        int col = Integer.parseInt(st.nextToken());
//        int[][] map = new int[row][col];
//        int[][] dp = new int[row][col];
//
//        for (int r = 0; r < row; r++) {
//            st = new StringTokenizer(br.readLine());
//            for (int c = 0; c < col; c++) {
//                map[r][c] = Integer.parseInt(st.nextToken());
//            }
//        }
//
//        Queue<int[]> qu = new LinkedList<>();
//        int[] location = {0, 0, k};
//        boolean[][][] visited = new boolean[row][col][k + 1];
//        qu.offer(location);
//        visited[0][0][k] = true;
//        int size = 0;
//        int time = 0;
//        boolean flag = false;
//
//        Loop:
//        while (!qu.isEmpty()) {
//            size = qu.size();
//            for (int i = 0; i < size; i++) {
//                location = qu.poll();
//
//                if (location[0] + 1 == row && location[1] + 1 == col) {
//                    flag = true;
//                    break Loop;
//                }
//
//                int nextR, nextC, horseCnt;
//                for (int j = 0; j < 12; j++) {
//                    nextR = location[0] + moveX[j];
//                    nextC = location[1] + moveY[j];
//                    horseCnt = location[2];
//                    if(j < 4) {
//                        if ((nextR >= 0 && nextR < row && nextC >= 0 && nextC < col) && map[nextR][nextC] != 1 && !visited[nextR][nextC][location[2]]) {
//                            visited[nextR][nextC][location[2]] = true;
//                            qu.offer(new int[]{nextR, nextC, location[2]});
//                        }
//                    } else{
//                        if ((nextR >= 0 && nextR < row && nextC >= 0 && nextC < col && horseCnt > 0) && map[nextR][nextC] != 1 && !visited[nextR][nextC][location[2]]) {
//                            visited[nextR][nextC][location[2] - 1] = true;
//                            qu.offer(new int[]{nextR, nextC, horseCnt - 1});
//                        }
//                    }
//                }
//            }
//            time++;
//        }
//        if(flag)
//            System.out.println(time);
//        else
//            System.out.println(-1);
//
//    }

    static int[][] map;
    static int[][] deltas = {{-1, 0}, {1, 0}, {0, -1}, {0, 1},
            {-2, -1}, {-2, 1}, {2, -1}, {2, 1}, {-1, -2}, {1, -2}, {-1, 2}, {1, 2}};
    static int K, W, H;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());	//가로길이
        H = Integer.parseInt(st.nextToken());	//세로길이

        map = new int[H][W];

        //정보 입력(초기화)
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        BFS(0,0,0,0); //(0,0)에서 출발
    }

    public static void BFS(int x, int y, int horseMove, int cnt) {
        Queue<int[]> queue = new LinkedList();
        boolean[][][] visited = new boolean[H][W][K+1]; //h행 w열에 말처럼 k번 움직여서 방문한 적이 있는가?

        queue.offer(new int[] {x, y, horseMove, cnt});
        visited[x][y][horseMove] = true;	//방문 처리

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();	//현재 지점 정보
            int curX = cur[0];
            int curY = cur[1];
            int curH = cur[2];
            int curC = cur[3];

            //(H-1, W-1)에 도착!
            if(curX == H-1 && curY == W-1) {
                System.out.println(curC);
                return ;
            }

            for (int i = 0; i < 12; i++) {
                int nextX = curX + deltas[i][0];
                int nextY = curY + deltas[i][1];
                int horseCnt = (i>=4) ? curH+1 : curH;

                //범위 안 & 미방문 & 평지
                if (isRange(nextX, nextY, horseCnt) && !visited[nextX][nextY][horseCnt] && map[nextX][nextY] == 0 ) {

                    visited[nextX][nextY][horseCnt] = true; //방문처리
                    queue.offer(new int[] {nextX, nextY, horseCnt, curC+1});
                }
            }
        }

        //여기까지 왔다는 것은 (H-1, W-1)에 갈 수 없다는 것
        System.out.println(-1);
    }

    //조건: map 범위를 벗어나지 않는다.
    public static boolean isRange(int x, int y, int horseMove) {
        return x>=0 && x < H && y >= 0 && y < W && horseMove <= K;
    }

}

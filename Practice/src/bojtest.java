import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bojtest {
    static int[] dx = { 0, -1, 0 ,1};// 왼 상 오
    static int[] dy = { -1, 0, 1 ,0};
    static int N, M, D;
    static int[][] map;
    static int[][] origin_map;
    static boolean[] check;
    static boolean[][] check_map; //
    static int[][] dis;
    static boolean[][] kill_map;

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static Queue<Point> q;
    static int ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        D = sc.nextInt();
        origin_map = new int[N][M];
        for (int n = 0; n < N; n++) {
            for (int m = 0; m < M; m++) {
                origin_map[n][m] = sc.nextInt();
            }
        } /// =========> input end

        check = new boolean[M];
        comb(0, 0);// M 개중에 3개를 뽑을 조합

        System.out.println(ans);

    }

    private static void comb(int idx, int cnt) {
        if (cnt == 3) {
            // System.out.println("===========라운드 시작==========");
            // 3개 조합 끝. 이 조합으로 게임해보기
            int count = 0;
            int round = 0;
            // 저번판에서 훼손된 맵 다시 원상복귀
            map = new int[N][M];
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    map[n][m] = origin_map[n][m];
                }
            }
            while (round != N) {
                for (int i = 0; i < M; i++) {
                    if (check[i]) {
                        System.out.println("공격 전 : ");
                        for(int[] a : map){
                            System.out.println(Arrays.toString(a));
                        }
                        System.out.print(" ");
                        for(int am = 0; am < M; am++){
                            if(check[am]) System.out.print("1, ");
                            else System.out.print("0, ");
                        }
                        System.out.println();
                        System.out.println();
                        // System.out.println("i번째 위치임"+i);
                        // 적의 위치 = (N,i)
                        // 첫번째 적으로 첫번째 공격하기
                        check_map = new boolean[N][M];
                        dis = new int[N + 1][M];
                        q = new LinkedList<>();
                        q.add(new Point(N, i));
                        dis[N][i] = 0;
                        while (!q.isEmpty()) {
                            Point p = q.poll();
                            for (int t = 0; t < 4; t++) {
                                int x = p.x + dx[t];
                                int y = p.y + dy[t];
                                if (x < 0 || x >= N || y < 0 || y >= M || check_map[x][y])
                                    continue;
                                dis[x][y] = dis[p.x][p.y] + 1;
                                if (dis[x][y] > D)
                                    continue;
                                if (map[x][y] == 1) {// 적이 있는 위치 발견
                                    // System.out.println("적이있음 x:"+x+"y"+y);
                                    map[x][y] = 3;
                                    count++;
                                    break;
                                } else if (map[x][y] == 3) {// 공격한 적이 겹친경우
                                    break;
                                }
                                check_map[x][y] = true;
                                q.add(new Point(x, y));
                            }
                        }
                        // System.out.println("한명당 공격");
                        // print();
                    } /// -> 적1개로 공격 한번
                }
                System.out.println("공격 체크 : ");
                for(int[] a : map){
                    System.out.println(Arrays.toString(a));
                }
                System.out.print(" ");
                for(int am = 0; am < M; am++){
                    if(check[am]) System.out.print("1, ");
                    else System.out.print("0, ");
                }
                System.out.println();
                System.out.println();

                // System.out.println("3명다 공격후");
                // print();
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                        if (map[i][j] == 3) {// 죽은 적의 위치
                            map[i][j] = 0;
                        }
                    }
                }

                System.out.println("공격 후 : ");
                for(int[] a : map){
                    System.out.println(Arrays.toString(a));
                }
                System.out.print(" ");
                for(int am = 0; am < M; am++){
                    if(check[am]) System.out.print("1, ");
                    else System.out.print("0, ");
                }
                System.out.println();
                System.out.println("잡은 병사 수 : " + count);
                System.out.println();

                // 맵 갱신해주고 병사 한칸씩 이동하기
                for (int i = N - 1; i >= 0; i--) {
                    for (int j = 0; j < M; j++) {
                        if (i == 0) {
                            map[i][j] = 0;
                        } else {
                            map[i][j] = map[i - 1][j];
                        }
                    }
                }
                // System.out.println("바뀐 맵의 모");
                // print();
                round++;
            }

            // ans 적의 최대수로 변경하기
            ans = Math.max(ans, count);

            return;
        }
        if (idx == M)
            return;
        check[idx] = true;
        comb(idx + 1, cnt + 1);
        check[idx] = false;
        comb(idx + 1, cnt);
    }

    static void print() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

}

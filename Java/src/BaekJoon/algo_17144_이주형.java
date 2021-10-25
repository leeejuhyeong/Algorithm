package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class algo_17144_이주형 {
    public static int r, c, t;
    public static AirCleaner airCleaner;            // 공기청정기 객체
    public static int[][] map;
    public static int[] deltaR = {-1, 0, 1, 0};     // 먼지확산, 반시계방향 순환 행이동
    public static int[] deltaC = {0, 1, 0, -1};     // 먼지확산, 반시계방향 순환 열이동
    public static int[] downR = {1, 0, -1, 0};      // 시계방향 순환 행이동
    public static int[] downC = {0, 1, 0, -1};      // 시계방향 순환 열이동

    public static class AirCleaner {            // 공기청정기 위아래 행, 열 저장
        int upRow, upCol, downRow, downCol;

        AirCleaner() {
            upRow = upCol = downRow = downCol = 0;
        }
    }

    public static class Dust {                  // 먼지 행, 열, 양 객체
        int row, col, dust;

        Dust(int row, int col, int dust) {
            this.row = row;
            this.col = col;
            this.dust = dust;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        map = new int[r][c];
        airCleaner = new AirCleaner();
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == -1) {
                    if (airCleaner.upRow == 0) airCleaner.upRow = i;
                    else airCleaner.downRow = i;
                }
            }
        }

        for (int i = 0; i < t; i++) {       // t시간 동안 반복
            // 먼지 확산
            diffusion();
            // 공기청정기 가동
            airCleaning();
        }

        int result = 0;                 // 남은 먼지
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                result += map[i][j];
            }
        }
        System.out.println(result + 2);     // 공기청정기인 -1 2개 더해주기
    }

    public static void diffusion() {
        List<Dust> dustes = new LinkedList<>();
        // 먼지 위치 리스트에 저장
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] != 0 && map[i][j] != -1 && map[i][j] >= 5) {
                    dustes.add(new Dust(i, j, map[i][j]));
                }
            }
        }

        // 먼지 확산
        int newR, newC;
        for (Dust dust : dustes) {
            int count = 0;
            int spread = dust.dust / 5;
            for (int i = 0; i < 4; i++) {
                newR = dust.row + deltaR[i];
                newC = dust.col + deltaC[i];
                if (isRange(newR, newC) && map[newR][newC] != -1) { // 확산이 가능할 때
                    map[newR][newC] += spread;                      // 확산
                    count++;                                        // 확산 개수 확인
                }
            }
            map[dust.row][dust.col] -= spread * count;              // 기존 먼지 중심지에서 확산된 먼지만큼 빼기
        }
    }

    public static void airCleaning() {
        // 윗부분 반시계방향
        int newR = airCleaner.upRow - 1;
        int newC = airCleaner.upCol;
        for (int i = 0; i < 4; i++) {       // 반시계방향 순환
            while (isRange(newR + deltaR[i], newC + deltaC[i]) && newR + deltaR[i] <= airCleaner.upRow && map[newR + deltaR[i]][newC + deltaC[i]] != -1) {
                map[newR][newC] = map[newR + deltaR[i]][newC + deltaC[i]];      // while문 범위지정(배열 범위 넘지않고, 공기청정기 행까지만 이동하기)
                newR += deltaR[i];
                newC += deltaC[i];
            }
        }
        map[newR][newC] = 0;
        // 아래부분 시계방향
        newR = airCleaner.downRow + 1;
        newC = airCleaner.downCol;
        for (int i = 0; i < 4; i++) {       // 시계방향 순환
            while (isRange(newR + downR[i], newC + downC[i]) && newR + downR[i] >= airCleaner.downRow && map[newR + downR[i]][newC + downC[i]] != -1) {
                map[newR][newC] = map[newR + downR[i]][newC + downC[i]];        // while문 범위지정(배열 범위 넘지않고, 공기청정기 행까지만 이동하기)
                newR += downR[i];
                newC += downC[i];
            }
        }
        map[newR][newC] = 0;
    }

    public static boolean isRange(int x, int y) {
        return x >= 0 && x < r && y >= 0 && y < c;
    }
}

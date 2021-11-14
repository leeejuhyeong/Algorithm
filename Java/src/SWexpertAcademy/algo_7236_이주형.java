package SWexpertAcademy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class algo_7236_이주형 {
    public static int[] xmove = {-1, -1, -1, 0, 1, 1, 1, 0};
    public static int[] ymove = {-1, 0, 1, 1, 1, 0, -1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        int n, deep;      // 저수지 구획 크기, 가장 깊은 물의 깊이
        char[][] pot;       // 저수지 배열

        for (int test_case = 1; test_case <= t; test_case++) {
            n = Integer.parseInt(br.readLine());
            pot = new char[n][n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    pot[i][j] = st.nextToken().charAt(0);       // 저수지 초기화
                }
            }

            deep = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (pot[i][j] == 'W') {                             // 해당 물의 깊이 탐색
                        deep = Math.max(deep, howtoDeep(i, j, pot, n));      // deep보다 깊을 경우 deep에 저장
                    }
                }
            }

            bw.append("#").append(String.valueOf(test_case)).append(" ").append(String.valueOf(deep));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    public static int howtoDeep(int i, int j, char[][] pot, int n) {
        int deep = 0;
        for (int move = 0; move < 8; move++) {      // 8방 탐색
            if (i + xmove[move] < 0 || i + xmove[move] >= n || j + ymove[move] < 0 || j + ymove[move] >= n) continue;   // 범위 벗어나면 무시
            if (pot[i + xmove[move]][j + ymove[move]] == 'W') deep++;       // 'W'라면 deep 증가
        }

        if (deep == 0) return 1;    // 0일경우 1로 변환(문제조건)
        return deep;
    }
}

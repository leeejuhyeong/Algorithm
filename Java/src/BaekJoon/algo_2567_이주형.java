package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class algo_2567_이주형 {
    public static int[] xmove = {-1, 0, 0, 1};
    public static int[] ymove = {0, 1, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int n = Integer.parseInt(br.readLine());
        boolean[][] drawing = new boolean[101][101];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for (int j = x; j < x + 10; j++) {
                for (int k = y; k < y + 10; k++) {
                    if (!drawing[j][k]) drawing[j][k] = true;       // 색종이 영역 true
                }
            }
        }

        System.out.println(round(drawing));

    }

    public static int round(boolean[][] drawing) {
        int count = 0;

        for (int i = 1; i <= 100; i++) {
            for (int j = 1; j <= 100; j++) {
                if (drawing[i][j]) {
                    for (int k = 0; k < 4; k++) {   // 상하좌우 확인
                        if (i + xmove[k] < 1 || i + xmove[k] > 100 || j + ymove[k] < 1 || j + ymove[k] > 100) {
                            count++;    // 색종이가 도화지를 벗어나지 않는다고 했으니 범위를 벗어날 경우도 둘레
                            continue;
                        }
                        if (!drawing[i + xmove[k]][j + ymove[k]]) count++; // 상하좌우 확인 시 faluse가 있다면 둘레
                    }
                }
            }
        }
        return count;
    }
}

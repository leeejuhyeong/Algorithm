package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class algo_10157_이주형 {
    static int[][] deque = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int c = Integer.parseInt(input[0]);                 // 행열, xy 전환
        int r = Integer.parseInt(input[1]);
        int k = Integer.parseInt(br.readLine());        // 목표 손님의 번호

        boolean[][] map = new boolean[r + 1][c + 1];

        int x = 1, y = 1;
        int count = 1;          // 손님 번호 카운트
        int sight = 0;          // 방향 전환 카운트

        if(k > r * c) System.out.println(0);            // r*c 좌석 수보다 넘어갈 경우 0 출력
        else {
            while (count < k) {             // 카운트가 목표 손님의 번호보다 작을 경우 반복
                map[x][y] = true;
                int rMove = x + deque[sight][0];        // 다음 좌석
                int cMove = y + deque[sight][1];

                if (rMove < 1 || cMove < 1 || rMove > r || cMove > c || map[rMove][cMove]) {        // 배열 밖으로 넘어가거나 다음 이동값이 True(자리 있는 좌석)인 경우 방향전환
                    sight++;
                    if (sight == 4) sight = 0;
                    rMove = x + deque[sight][0];
                    cMove = y + deque[sight][1];
                }
                x = rMove;
                y = cMove;

                count++;
            }
            System.out.println(y + " " + x);            // 전환했으니 다시 바꿔서 출력
        }
    }
}

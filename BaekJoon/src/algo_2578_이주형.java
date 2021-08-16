import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class algo_2578_이주형 {
    static int result;          // 빙고 개수
    static boolean[][] bingo;   // 빙고판(숫자 호출 시 true)
    static int[][] bingoIndex;  // 빙고 숫자의 R, C 위치
    static boolean upRightflag; // 왼쪽위->오른쪽아래 빙고
    static boolean downLeftflag; // 오른쪽위 -> 왼쪽아래 빙고

    public static boolean horiz(int r, int c) {     // 가로 빙고 확인
        int ctemp = 1;
        while (ctemp <= 5) {
            if (!bingo[r][ctemp]) return false;
            ctemp++;
        }
        return true;
    }

    public static boolean vertical(int r, int c) {      // 세로 빙고 확인
        int rtemp = 1;
        while (rtemp <= 5) {
            if (!bingo[rtemp][c]) return false;
            rtemp++;
        }
        return true;
    }

    public static void upRight() {      // 오른쪽아래 대각선 빙고 확인
        int r = 1;
        int c = 1;
        int count = 0;
        while (r <= 5) {
            if (bingo[r++][c++]) count++;
            else break;
        }
        if (count == 5) {
            upRightflag = true;
            result++;
        }
    }

    public static void downLeft() {     // 왼쪽위 대각선 빙고 확인
        int r = 1;
        int c = 5;
        int count = 0;
        while (r <= 5) {
            if (bingo[r++][c--]) count++;
            else break;
        }
        if (count == 5) {
            downLeftflag = true;
            result++;
        }
    }

    public static void gobingo(int r, int c) {  // 빙고 확인 시작
        bingo[r][c] = true;
        if (horiz(r, c)) result++;
        if (vertical(r, c)) result++;
        if (!upRightflag) upRight();        // uprightflag으로 오른쪽위 대각선이 빙고가 안되어있었다면 메소드 실행, 빙고된후는 메소드 실행 X
        if (!downLeftflag) downLeft();

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        bingo = new boolean[6][6];
        bingoIndex = new int[26][2];                // 숫자들의 위치 저장
        result = 0;
        upRightflag = false;
        downLeftflag = false;

        for (int i = 1; i <= 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 5; j++) {
                int temp = Integer.parseInt(st.nextToken());
                bingoIndex[temp][0] = i;                            // 해당 숫자의 빙고판에서의 위치 저장
                bingoIndex[temp][1] = j;
            }
        }

        int count = 0;
        while (count < 25) {
            if (count % 5 == 0) st = new StringTokenizer(br.readLine());

            int temp = Integer.parseInt(st.nextToken());
            gobingo(bingoIndex[temp][0], bingoIndex[temp][1]);

            if (result >= 3) {
                System.out.println(count + 1);
                break;
            }
            count++;
        }
    }
}

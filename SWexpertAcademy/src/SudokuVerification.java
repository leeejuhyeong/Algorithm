import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SudokuVerification {
    public static int[][] middle = {{1, 1}, {1, 4}, {1, 7}, {4, 1}, {4, 4}, {4, 7}, {7, 1}, {7,4}, {7,7}};  // 작은 정사각형의 가운데 좌표
    public static int[][] deque = {{0, 0}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};   // 자기 자신까지 9방탐색
    public static int[][] sudoku;
    public static int[] check;

    // 작은 정사각형 검증
    public static boolean smallrectangle(){
        boolean result = true;
        Loop : for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(check[sudoku[middle[i][0] - deque[j][0]][middle[i][1] - deque[j][1]]] != i) {
                    result = false;
                    break Loop;
                }
                else check[sudoku[middle[i][0] - deque[j][0]][middle[i][1] - deque[j][1]]]++;
            }
        }
        check = new int[10];
        return result;
    }
    // 수직 검증
    public static boolean vertical(){
        boolean result = true;
        Loop : for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(check[sudoku[j][i]] != i) {
                    result = false;
                    break Loop;
                }
                else check[sudoku[j][i]]++;
            }
        }
        check = new int[10];
        return result;
    }
    // 수평 검증
    public static boolean horizon(){
        boolean result = true;
        Loop : for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(check[sudoku[i][j]] != i) {
                    result = false;
                    break Loop;
                }
                else check[sudoku[i][j]]++;
            }
        }
        check = new int[10];
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= t; test_case++) {
            boolean flag = true;                            // 수평, 수직, 작은 정사각형의 검증이 완료되었는지 판별.
            sudoku = new int[9][9];
            check = new int[10];                      // 1~9 하나의 숫자만 사용했는지 체크


            for (int i = 0; i < 9; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < 9; j++) {
                    sudoku[i][j] = Integer.parseInt(st.nextToken());        // 스도쿠 입력
                }
            }

            if(vertical() && horizon() && smallrectangle()){
                System.out.println("#" + test_case + " " + 1);
            } else{
                System.out.println("#" + test_case + " " + 0);
            }
        }
    }
}

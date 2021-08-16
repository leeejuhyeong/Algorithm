import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FunOthelloGame {
    public static int[][] move = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
    public static int[][] board;

    public static void othello(int x, int y, int color, int direction){
        int reverse_color;
        if(color == 1) reverse_color = 2;
        else reverse_color = 1;
        board[x][y] = color;
        boolean flag = false;
        int count = 1;
        int move_x = x +move[direction][0];
        int move_y = y + move[direction][1];
        while(move_x >= 1 && move_x < board.length && move_y >= 1 && move_y < board.length){    //
            if(board[move_x][move_y] == color)  {
                flag = true;
                break;
            } else if(board[move_x][move_y] == reverse_color){
                move_x += move[direction][0];
                move_y += move[direction][1];
                count++;
            } else break;
        }
        if(flag) {
            for(int j = 1; j < count; j++){
                board[x + j*move[direction][0]][y + j*move[direction][1]] = color;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int test_case = 0; test_case < t; test_case++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            board = new int[n + 1][n + 1];
            board[n / 2][n / 2] = 2;
            board[n / 2 + 1][n / 2] = 1;
            board[n / 2 + 1][n / 2 + 1] = 2;
            board[n / 2][n / 2 + 1] = 1;

            for(int i = 0; i < m; i++){
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                int color = Integer.parseInt(st.nextToken());

                for(int k = 0; k < 8; k++){
                    othello(x, y, color, k);
                }
            }
            int black = 0;
            int white = 0;
            for(int[] arr : board){
                for(int a : arr){
                    if(a == 1) black++;
                    else if(a == 2) white++;
                }
            }
            for(int[] arr : board){
                for(int a : arr){
                    System.out.print(a);
                }
                System.out.println();
            }

            System.out.println("#" + (test_case+1) + " " + black + " " + white);
        }
    }
}

// 검 흰 검 흰 (새로운)검 ==> 검 검 검 검 검
/*
*   1
*   6 2
*   5 4 1
*   5 2 1
*
*  -> 1 6 1
*  -> 1 5 1
*       W(새로운 )
*   B W
*   W B W
*
*
*   B W W B
*   B W W W W
*   B W W W W
*   B W W W W
*   B W W W B
*
* */
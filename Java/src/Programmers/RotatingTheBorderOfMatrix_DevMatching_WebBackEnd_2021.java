package Programmers;

import java.util.Arrays;

public class RotatingTheBorderOfMatrix_DevMatching_WebBackEnd_2021 {
    public static void main(String[] args) {
        int rows = 6;
        int columns = 6;
        int[][] queries = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};
        System.out.println(Arrays.toString(solution(rows, columns, queries)));
    }

    public static int[] solution(int rows, int columns, int[][] queries) {
        int rotate = queries.length;
        int[] answer = new int[rotate];

        int[][] array = new int[rows][columns];
        init(rows, columns, array);

        for(int i = 0; i < rotate; i++) {
            answer[i] = rotateAndMinimum(rows, columns, queries[i], array);
        }

        return answer;
    }

    private static int rotateAndMinimum(int rows, int columns, int[] queries, int[][] array) {
        int row, col;
        row = queries[0] - 1;
        col = queries[1] - 1;
        int save = array[row][col];
        int min = save;
        int next;
        int[][] nextMove = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int flag = 0;
        col++;

        // 회전하면서 최소값 구하기
        while (row != queries[0] - 1 || col != queries[1] - 1) {
            next = array[row][col];     // 다음에 저장될 숫자
            array[row][col] = save;     // 회전
            save = next;
            min = Math.min(min, save);

            if (row + nextMove[flag][0] > queries[2] - 1 || row + nextMove[flag][0] < queries[0] - 1 || col + nextMove[flag][1] > queries[3] - 1 || col + nextMove[flag][1] < queries[1] - 1) {
                flag++;
            }
            row += nextMove[flag][0];
            col += nextMove[flag][1];
        }

        array[row][col] = save;

        return min;
    }

    private static void init(int rows, int columns, int[][] array) {
        int count = 1;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                array[i][j] = count++;
            }
        }
    }
}

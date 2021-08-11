import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class B16935_이주형 {
    public static int[][] one(int[][] array) {
        int n = array.length;
        int m = array[0].length;
        int[][] clone = new int[n][m];

        for (int c = 0; c < m; c++) {
            for (int r = 0; r < n; r++) {
                clone[r][c] = array[n - r - 1][c];
            }
        }
        return clone;
    }

    public static int[][] two(int[][] array) {
        int n = array.length;
        int m = array[0].length;
        int[][] clone = new int[n][m];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                clone[r][m - c - 1] = array[r][c];
            }
        }
        return clone;
    }

    public static int[][] three(int[][] array) {
        int n = array.length;
        int m = array[0].length;
        int[][] clone = new int[m][n];
        for (int c = 0; c < m; c++) {
            for (int r = n - 1; r >= 0; r--) {
                clone[c][n - 1 - r] = array[r][c];
            }
        }
        return clone;
    }

    public static int[][] four(int[][] array) {
        int n = array.length;
        int m = array[0].length;
        int[][] clone = new int[m][n];
        for (int c = m - 1; c >= 0; c--) {
            for (int r = 0; r < n; r++) {
                clone[m - 1 - c][r] = array[r][c];
            }
        }
        return clone;
    }

    public static int[][] five(int[][] array) {
        int n = array.length;
        int m = array[0].length;
        int[][] clone = new int[n][m];

        for (int r = 0; r < n / 2; r++) {
            for (int c = 0; c < m / 2; c++) {
                clone[r][c] = array[r + n / 2][c]; //array[r][c];
                clone[r][c + m / 2] = array[r][c]; //array[r][c + m / 2];
                clone[r + n / 2][c + m / 2] = array[r][c + m / 2]; //array[r + n / 2][c + m / 2];
                clone[r + n / 2][c] = array[r + n / 2][c + m / 2]; //array[r + n / 2][c];
            }
        }
        return clone;
    }

    public static int[][] six(int[][] array){
        int n = array.length;
        int m = array[0].length;
        int[][] clone = new int[n][m];

        for (int r = 0; r < n / 2; r++) {
            for (int c = 0; c < m / 2; c++) {
                clone[r][c] = array[r][c + m / 2]; //array[r][c];
                clone[r][c + m / 2] = array[r + n / 2][c + m / 2]; //array[r][c + m / 2];
                clone[r + n / 2][c + m / 2] = array[r + n / 2][c]; //array[r + n / 2][c + m / 2];
                clone[r + n / 2][c] = array[r][c]; //array[r + n / 2][c];
            }
        }
        return clone;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = null;
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int r = Integer.parseInt(input[2]);

        int[][] array = new int[n][];

        for (int i = 0; i < n; i++) {
            array[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int[] cases = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < r; i++) {
            switch (cases[i]) {
                case 1 -> array = one(array);
                case 2 -> array = two(array);
                case 3 -> array = three(array);
                case 4 -> array = four(array);
                case 5 -> array = five(array);
                case 6 -> array = six(array);
            }
        }
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int[] arr : array){
            for(int a : arr){
                bw.append(Integer.toString(a)).append(" ");
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
/*
# 1
4 5 1 9 8 2 1 3
1 3 2 8 7 9 2 1
2 1 3 8 6 3 9 2
5 9 2 1 9 6 1 8
9 7 8 2 1 4 5 3
3 2 6 3 1 2 9 7

#2
7 9 2 1 3 6 2 3
3 5 4 1 2 8 7 9
8 1 6 9 1 2 9 5
2 9 3 6 8 3 1 2
1 2 9 7 8 2 3 1
3 1 2 8 9 1 5 4

#3
4 1 2 5 9 3
5 3 1 9 7 2
1 2 3 2 8 6
9 8 8 1 2 3
8 7 6 9 1 1
2 9 3 6 4 2
1 2 9 1 5 9
3 1 2 8 3 7

#4
7 3 8 2 1 3
9 5 1 9 2 1
2 4 6 3 9 2
1 1 9 6 7 8
3 2 1 8 8 9
6 8 2 3 2 1
2 7 9 1 3 5
3 9 5 2 1 4

#5
2 1 3 8 3 2 6 3
1 3 2 8 9 7 8 2
4 5 1 9 5 9 2 1
6 3 9 2 1 2 9 7
7 9 2 1 1 4 5 3
8 2 1 3 9 6 1 8

#6
1 2 9 7 6 3 9 2
1 4 5 3 7 9 2 1
9 6 1 8 8 2 1 3
3 2 6 3 2 1 3 8
9 7 8 2 1 3 2 8
5 9 2 1 4 5 1 9

# 7
3 1 2 8 9 1 5 4
1 2 9 7 8 2 3 1
2 9 3 6 8 3 1 2
8 1 6 9 1 2 9 5
3 5 4 1 2 8 7 9
7 9 2 1 3 6 2 3
 */
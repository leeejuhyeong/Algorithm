package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class algo_10830_이주형 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        int[][] a = new int[n][n];              // 행렬 초기화
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] result = division(b, a, n);     // 제곱한 결과값

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                bw.write(result[i][j] % 1000 + " ");        // 마지막으로 1000으로 나머지 출력
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    // 분할정복
    private static int[][] division(long b, int[][] a, int n) {     // 먼저 제곱 분할
        if (b > 1L) {
            int[][] temp = division(b / 2, a, n);           // 지수를 2로 나누어서 분할

            // 분할한 것을 가지고 행렬 제곱
            temp = multiplyMatrix(temp, temp, n);

            if (b % 2 == 1L) {                               // 지수가 홀수라면 a 한번더 곱해주기
                temp = multiplyMatrix(temp, a, n);
            }

            return temp;
        } else {
            return a;
        }
    }

    // 행렬 곱
    public static int[][] multiplyMatrix(int[][] a, int[][] b, int n) {
        int[][] result = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
                result[i][j] %= 1000;
            }
        }
        return result;
    }
}

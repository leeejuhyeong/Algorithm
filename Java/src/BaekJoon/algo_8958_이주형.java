package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class algo_8958_이주형 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        char[] quizs;                       // 퀴즈 배열
        int count, result;                  // count - O일때 증가, result - 퀴즈 점수
        for (int i = 0; i < n; i++) {
            quizs = br.readLine().toCharArray();
            count = result = 0;

            for (char quiz : quizs) {
                if (quiz == 'O') count++;   // 맞았으면 증가
                else count = 0;             // 틀리면 0으로 초기화

                result += count;
            }
            bw.append(String.valueOf(result));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}

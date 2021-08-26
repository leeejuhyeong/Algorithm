package SWexpertAcademy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class algo_5356_이주형 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());    // 테스트 케이스 개수
        char[][] words = new char[5][];             // 문자열 저장 배열, 5개의 문자열

        for (int test_case = 1; test_case <= t; test_case++) {
            bw.append("#").append(String.valueOf(test_case)).append(" ");
            for (int i = 0; i < 5; i++) {
                words[i] = br.readLine().toCharArray();     // char배열로 변환
            }

            for (int i = 0; i < 15; i++) {      // 글자 수 1 ~ 15이므로 15만큼 반복
                for (int j = 0; j < 5; j++) {   // 5문자열 반복
                    if (i >= words[j].length) continue; // 문자열의 크기를 벗어날경우 무시
                    bw.append(words[j][i]);
                }
            }
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}
/*
#1 Aa0FfBb1GgCc2HhDd3IiEe4Jj
#2 Aa0aPAf985Bz1EhCz2W3D1gkD6x
 */
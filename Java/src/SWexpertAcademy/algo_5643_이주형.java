package SWexpertAcademy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class algo_5643_이주형 {
    // 키 순서를 알 수 있다 -> 자신의 부모와 자식의 개수가 자기자신을 제외한 나머지 학생 수이다 -> 모든 학생(노드)와 연결되어 있다.
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int max;                                            // 연결안되어 있음을 나타내는 가중치
        int t = Integer.parseInt(br.readLine().trim());     // 테스트케이스
        int n, m, studentA, studentB, result;               // 학생 수, 간선 수, 키 작은 학생, 키 큰 학생, 결과값
        int[][] map;                                        // 그래프

        for (int test_case = 1; test_case <= t; test_case++) {
            n = Integer.parseInt(br.readLine().trim());     // 학생 수 초기화
            m = Integer.parseInt(br.readLine().trim());     // 간선 수 초기화

            max = n * (n - 1) / 2;                          // 최대값 설정
            map = new int[n][n];                            // 그래프 초기화
            for (int i = 0; i < n; i++) {
                Arrays.fill(map[i], max);                   // 플로이드-와샬 초기화
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                studentA = Integer.parseInt(st.nextToken());    // 키 작은 학생
                studentB = Integer.parseInt(st.nextToken());    // 키 큰 학생

                map[studentA - 1][studentB - 1] = 1;            // 연결을 1로 나타냄
            }

            for (int k = 0; k < n; k++) {                       // 플로이드-와샬
                for (int i = 0; i < n; i++) {
                    if (i == k) continue;
                    for (int j = 0; j < n; j++) {
                        if (j == k || j == i) continue;
                        if (map[i][j] > map[i][k] + map[k][j]) {
                            map[i][j] = map[i][k] + map[k][j];
                        }
                    }
                }
            }

            result = 0;                                         // 결과값
            boolean flag;                                       // 탈출 flag
            for (int i = 0; i < n; i++) {
                flag = false;
                for (int j = 0; j < n; j++) {
                    if (i == j) continue;                           // 자기 자신 제외
                    if (map[i][j] == max && map[j][i] == max) {     // 그래프로 연결되어있어야해서 map[i][j] 또는 map[j][i] 둘 다 max 값일 경우 연결되어 있지 않은 것을 의미
                        flag = true;                                // 그럴경우 flag을 true로 변경해서 result의 증가가 되지 않도록 해줌
                        break;
                    }
                }
                if (flag) continue;
                result++;
            }

            bw.append("#").append(String.valueOf(test_case)).append(" ").append(String.valueOf(result));
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }

}

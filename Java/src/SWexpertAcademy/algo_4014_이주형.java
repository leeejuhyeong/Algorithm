package SWexpertAcademy;

import java.io.*;
import java.util.StringTokenizer;

public class algo_4014_이주형 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        int n, x;
        int[][] map1, map2;
        int input, result;

        for (int test_case = 1; test_case <= t; test_case++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());

            map1 = new int[n][n];                   // 행 체크
            map2 = new int[n][n];                   // 열 체크
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++){
                    input = Integer.parseInt(st.nextToken());
                    map1[i][j] = input;
                    map2[j][i] = input;
                }
            }

            result = 0;
            result += check(n, x, map1);
            result += check(n, x, map2);

            bw.append("#").append(String.valueOf(test_case)).append(" ").append(String.valueOf(result));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    private static int check(int n, int x, int[][] map) {
        int sum = 0;
        int count;
        boolean[] visited;
        for (int j = 0; j < n; j++) {
            int i;
            visited = new boolean[n];                       // 활주로 중복 체크
            for (i = 1; i < n; i++) {
                if (map[i - 1][j] == map[i][j]) continue;
                if (map[i - 1][j] < map[i][j] && Math.abs(map[i - 1][j] - map[i][j]) == 1) {     // 오르막길
                    count = 1;                  // 활주로의 길이까지 반복
                    visited[i - 1] = true;
                    while (count < x) {         // 활주로의 길이를 놓을 수 있는지 확인
                        if (i - 1 - count < 0 || map[i - 1][j] != map[i - 1 - count][j] || visited[i - 1 - count])  // 배열의 범위를 벗어나거나, 평지가 아니거나,
                            break;                                                                                  // 이미 활주로가 설치되었다면 정지
                        visited[i - 1 - count] = true;
                        count++;
                    }
                    if (count < x) break;      // 놓을 수 없을 경우 반복 정지
                } else if (map[i - 1][j] > map[i][j] && Math.abs(map[i - 1][j] - map[i][j]) == 1) {     // 내리막길
                    count = 1;                  // 활주로의 길이까지 반복
                    visited[i] = true;
                    while (count < x) {
                        if (i + count >= n || map[i][j] != map[i + count][j] || visited[i + count])                 // 배열의 범위를 벗어나거나, 평지가 아니거나,
                            break;                                                                                  // 이미 활주로가 설치되었다면 정지
                        visited[i + count] = true;
                        count++;
                    }
                    if (count < x) break;
                } else break;
            }
            if (i == n) {       // 배열의 끝까지 탐색이 됬다면 => 활주로가 이상없이 설치할 수 있음
                sum++;
            }
        }
        return sum;
    }
}
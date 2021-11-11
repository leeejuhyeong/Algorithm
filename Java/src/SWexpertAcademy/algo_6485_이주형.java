package SWexpertAcademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class algo_6485_이주형 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int n, p, c;      // 버스 노선 개수, 버스 정류장 개수, 버스 정류장 번호
        int[][] bus;        // 버스 노선 배열
        int[] result;       // 버스 정류장 배열(답)

        for (int test_case = 1; test_case <= t; test_case++) {
            n = Integer.parseInt(br.readLine());
            bus = new int[n][];

            for (int i = 0; i < n; i++) {
                bus[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            p = Integer.parseInt(br.readLine());
            result = new int[p];
            for (int i = 0; i < p; i++) {           // 버스 정류장 p만큼 반복
                c = Integer.parseInt(br.readLine());    // 버스 정류장 번호

                for (int j = 0; j < n; j++) {     // 버스 정류장 i번째인 정류장 번호 c를
                    if (bus[j][0] <= c && c <= bus[j][1]) result[i]++;   // 지나가는 버스 노선 개수 확인
                }
            }

            sb.append("#").append(test_case).append(" ");
            for (int i = 0; i < p; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}

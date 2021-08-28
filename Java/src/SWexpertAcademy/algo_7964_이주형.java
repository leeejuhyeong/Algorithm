package SWexpertAcademy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class algo_7964_이주형 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        int n, distance;    // 왕국의 개수, 이동 거리
        int result;         // 필요한 차원관문 개수

        for (int test_case = 1; test_case <= t; test_case++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());           // 왕국의 개수 초기화
            distance = Integer.parseInt(st.nextToken());    // 이동 거리 초기화

            result = 0;
            int count = 0;          // 차원관문의 이동 가능한 거리 확인
            int next;               // 다음 도시
            st = new StringTokenizer(br.readLine());            // 0번과 n+1에는 차원관문이 있음.
            for (int i = 1; i <= n; i++) {
                next = Integer.parseInt(st.nextToken());
                count++;            // 다음 도시로 이동하면서 거리 증가
                if(next == 1) count = 0;    // 다음 도시에 차원관문이 있다면 거리 0 초기화
                if(count == distance){      // 이동 가능한 거리에 마지막일 경우 관문 생성
                    result++;
                    count = 0;      // 새로운 관문이 생겼으니 거리 초기화
                }
            }

            bw.append("#").append(String.valueOf(test_case)).append(" ").append(String.valueOf(result));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}

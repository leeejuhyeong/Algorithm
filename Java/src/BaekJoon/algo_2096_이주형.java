package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 백트래킹하려다보니 메모리초과,, -> 거꾸로하려다보니 인풋 숫자배열을 모두 저장해줄 필요가 있었기에,,
public class algo_2096_이주형 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] maxDP = new int[3];
        int[] minDP = new int[3];

        int n1, n2, n3;
        int nowMax0, nowMax1, nowMin0, nowMin1;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            n1 = Integer.parseInt(st.nextToken());
            n2 = Integer.parseInt(st.nextToken());
            n3 = Integer.parseInt(st.nextToken());
            if (i == 0) {
                maxDP[0] = minDP[0] = n1;
                maxDP[1] = minDP[1] = n2;
                maxDP[2] = minDP[2] = n3;
            } else {
                nowMax0 = maxDP[0];
                nowMax1 = maxDP[1];
                maxDP[0] = Math.max(nowMax0, nowMax1) + n1;
                maxDP[1] = Math.max(nowMax0, Math.max(nowMax1, maxDP[2])) + n2;
                maxDP[2] = Math.max(nowMax1, maxDP[2]) + n3;

                nowMin0 = minDP[0];
                nowMin1 = minDP[1];
                minDP[0] = Math.min(nowMin0, nowMin1) + n1;
                minDP[1] = Math.min(nowMin0, Math.min(nowMin1, minDP[2])) + n2;
                minDP[2] = Math.min(nowMin1, minDP[2]) + n3;
            }
        }
        bw.write(Math.max(maxDP[0], Math.max(maxDP[1], maxDP[2])) + " " + Math.min(minDP[0], Math.min(minDP[1], minDP[2])));
        bw.flush();
        bw.close();
    }
}
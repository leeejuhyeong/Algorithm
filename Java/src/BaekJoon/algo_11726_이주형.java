package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class algo_11726_이주형 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] method = n == 1 ? new int[3] : new int[n+1];      // n이 1이라면 배열 3개 생성(아래의 method[2]에 ArrayOutOfIndex터져서..)
        method[1] = 1;
        method[2] = 2;

        for (int i = 3; i <= n; i++) {
            method[i] = (method[i - 1] + method[i - 2]) % 10007;        // 점화식으로 접근할때마다 나머지연산해서 저장.
        }
        System.out.println(method[n]);
    }
}

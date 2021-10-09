package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class algo_1629_이주형 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a, b, c;
        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());
        c = Long.parseLong(st.nextToken());

        System.out.println(dfs(a, b, c));

    }

    private static long dfs(long a, long b, long c) {   // 제곱을 분할정복 적용
        if (b == 1) return a % c;

        long temp = dfs(a, b / 2, c);       // 메모이제이션

        if (b % 2 == 0) {
            return temp * temp % c;
        } else {
            return (((temp * temp) % c) * a) % c;
        }
    }

    // return dfs(a, b / 2, c) * dfs(a, b / 2, c) 이렇게 하니까 두번을 계산해서 시간초과...
}

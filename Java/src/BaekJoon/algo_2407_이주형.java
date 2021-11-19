package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class algo_2407_이주형 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        BigInteger up = BigInteger.ONE;         // BigInteger 객체.. 분자
        BigInteger down = BigInteger.ONE;           // 분모

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i = 0; i < m; i++) {
            up = up.multiply(new BigInteger(String.valueOf(n - i)));
            down = down.multiply(new BigInteger(String.valueOf(i + 1)));
        }
        System.out.println(up.divide(down));        // 나누기
    }
}

package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class algo_1676_이주형 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // 졸릴때풀어서 문제이해를 못했었음..
        int n = Integer.parseInt(br.readLine());

        BigInteger bigInteger = new BigInteger("1");
        while (n > 1) {
            bigInteger = bigInteger.multiply(BigInteger.valueOf(n));        // 팩토리얼 만들고
            n--;
        }
        int count = 0;
        String number = String.valueOf(bigInteger);
        for (int i = number.length() - 1; i >= 0 ; i--) {       // 0세주기..ㅋㅋ
            if(number.charAt(i) != '0')
                break;
            count++;
        }
        System.out.println(count);

    }
}
package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class algo_2851_이주형 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;    // 버섯 접수 합
        int temp = 0;   // 버섯 점수
        int count = 0;  // 0 ~ 9까지

        while (count < 10) {
            temp = Integer.parseInt(br.readLine());         // 새로운 버섯
            if (sum + temp >= 100) break;                   // 새로운 버섯 + 기존의 합이 100보다 크면 탈출
            sum += temp;
            count++;
        }

        if(count == 10) temp = 0;
        if ((100 - sum) >= (sum + temp - 100)) System.out.println(sum + temp);  // 기존버섯합보다 새로운버섯을 더한값이 100에 가깝거나 같다면 더한값 출력
        else System.out.println(sum);
    }
}
/*
1
1
1
1
1
1
1
1
1
1
 */

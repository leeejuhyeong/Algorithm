package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class algo_2810_이주형 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] sits = br.readLine().toCharArray();

        int count = 0;      // 좌석의 왼쪽의 컵홀더를 센다고 생각
        for (int i = 0; i < n; i++) {
            if (sits[i] == 'L') i++;    // 커플석의 가운데는 컵홀더가 없으므로 i증가
            count++;
        }

        count += 1; // 마지막 컵홀더

        System.out.println(Math.min(count, n));
    }
}

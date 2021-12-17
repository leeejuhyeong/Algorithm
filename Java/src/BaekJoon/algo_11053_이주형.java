package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class algo_11053_이주형 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int input, i, now;
        int[] numbers = new int[1001];

        StringTokenizer st = new StringTokenizer(br.readLine());
        numbers[0] = Integer.parseInt(st.nextToken());
        now = 0;
        while (n-- > 1) {
            input = Integer.parseInt(st.nextToken());

            if (numbers[now] < input) { // 현재 위치보다 크다면
                numbers[++now] = input;     // 저장
            } else {                    // 작다면
                i = 0;
                while (input > numbers[i]) {    // 인풋값보다 작은 값이 나올때까지 반복
                    i++;
                }
                numbers[i] = input;
            }
        }

        i = 0;
        while (numbers[i] != 0)
            i++;
        System.out.println(i);
    }

}

// 10 20 10 30 20 50
// 10 20 30 50
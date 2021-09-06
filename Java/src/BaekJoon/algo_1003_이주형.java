package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class algo_1003_이주형 {
    public static class Num {       // 해당 숫자 호출 횟수 저장 객체
        int zero;       // 0 호출 횟수
        int one;        // 1 호출 횟수
        boolean visited;    // 방문 여부

        Num(int zero, int one, boolean visited) {
            this.zero = zero;
            this.one = one;
            this.visited = visited;
        }
    }

    public static void pibo(int level, Num[] numbers) {
        if (!numbers[level].visited) {          // 방문하지 않았다면
            numbers[level].visited = true;  // 방문 처리

            if (level == 0) {
                numbers[level].zero++;
            } else if (level == 1) {
                numbers[level].one++;
            } else {
                pibo(level - 1, numbers);
                pibo(level - 2, numbers);
                numbers[level].zero = numbers[level - 1].zero + numbers[level - 2].zero;        // 0의 개수는 leve -1 , level - 2에서 호출된 0 횟수의 합
                numbers[level].one = numbers[level - 1].one + numbers[level - 2].one;           // 1의 개수는 leve -1 , level - 2에서 호출된 1 횟수의 합
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int input;

        Num[] numbers = new Num[41];        // 0부터 40까지이므로 41 생성
        for (int i = 0; i < 41; i++) {
            numbers[i] = new Num(0, 0, false);
        }

        pibo(40, numbers);      // 호출 횟수 생성

        for (int i = 0; i < t; i++) {
            input = Integer.parseInt(br.readLine());
            sb.append(numbers[input].zero).append(" ").append(numbers[input].one).append("\n");
        }
        System.out.println(sb);
    }
}

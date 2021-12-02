package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class algo_1541_이주형 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] eraseMinus = br.readLine().split("-");     // -를 빼고 스트링배열로 만듦 -> 빼주는 값들이 사라지면서 배열로 만들어짐
        int len = eraseMinus.length;

        int sum = 0;
        String[] start = eraseMinus[0].split("\\+");        // -를 제거한 각각의 문자열에는 모두 양수값들이며 이 배열들이 괄호로 묶여져있는 경우가 가장 작은 값을 만드는 방법
        for (int i = 0; i < start.length; i++) {
            sum += Integer.parseInt(start[i]);
        }

        for (int i = 1; i < len; i++) {                     // 맨처음 문자열만 유일하게 양수이므로 더해주고 나머지는 다 빼주기
            start = eraseMinus[i].split("\\+");
            for (int j = 0; j < start.length; j++) {
                sum -= Integer.parseInt(start[j]);
            }
        }

        System.out.println(sum);

    }
}


// 30 - 50 + 40 - 20 + 100
// 30 / 50 + 40 / 20 + 100
// 30 - ( 50 + 40) - (20 + 100)
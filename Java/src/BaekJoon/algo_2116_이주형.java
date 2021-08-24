package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class algo_2116_이주형 {
    static int n;
    static int[][] dices;
    static int[] move = {5, 3, 4, 1, 2, 0}; // 해당 면의 반대면

    // 주사위 면은 A B C D E F로 아랫면이 B라면 윗면은 그 뒤에 값인 C이다.
    public static int makeTower(int num, int floor) {
        boolean[] check = new boolean[7];   // 아랫면, 윗면으로 선택된 주사위값 체크
        int idx = diceIndex(num, floor);    // num의 인덱스 찾기
        check[dices[floor][idx]] = true;                  // 아랫면 체크
        check[dices[floor][move[idx]]] = true;            // 윗면 체크

        if (floor == n - 1) {                     // 기저조건 : 마지막 층일 경우
            return maxNumber(check);
        }

        return maxNumber(check) + makeTower(dices[floor][move[idx]], floor + 1);
    }

    public static int maxNumber(boolean[] check) {       // 아랫면 윗면을 제외한 가장 큰 주사위 값
        int i = 6;
        while (check[i]) i--;

        return i;
    }

    public static int diceIndex(int num, int floor) {       // num값의 인덱스(위치) 찾기
        int i = 0;
        while(!(dices[floor][i] == num)) i++;

        return i;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        dices = new int[n][];       // n개의 주사위

        for (int i = 0; i < n; i++) {
            dices[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int result = Integer.MIN_VALUE;
        for (int i = 0; i < 6; i++) {     // 1층 주사위의 아랫면 선택
            boolean[] check = new boolean[7];
            check[dices[0][i]] = true;              // 윗면
            check[dices[0][move[i]]] = true;        // 아랫면

            int temp = maxNumber(check) + makeTower(dices[0][i], 1);       // 선택한 Top 숫자에 따라 최대 옆면 반환
            if (temp > result) result = temp;
        }

        System.out.println(result);
    }
}

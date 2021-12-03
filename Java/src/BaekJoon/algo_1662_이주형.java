package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class algo_1662_이주형 {
    public static int i;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] numbers = br.readLine().toCharArray();

        int result = 0;
        int len = numbers.length;
        i = 0;
        while (i < len - 1) {
            if ((numbers[i] >= '0' && numbers[i] <= '9') && numbers[i + 1] == '(') {
                int front = numbers[i] - '0';
                i += 2;
                result += front * dfs(numbers);
            } else if(numbers[i] >= '0' && numbers[i] <= '9'){
                result++;
            }
            i++;
        }
        if (numbers[len - 1] >= '0' && numbers[len - 1] <= '9') result++;
        System.out.println(result);
    }

    private static int dfs(char[] numbers) {
        int count = 0;
        while (true) {
            if (numbers[i] >= '0' && numbers[i] <= '9' && numbers[i + 1] == '(') {
                int front = numbers[i] - '0';
                i += 2;
                count += front * dfs(numbers);
            } else if (numbers[i] == ')') {
                return count;
            } else
                count++;
            i++;
        }

    }
}

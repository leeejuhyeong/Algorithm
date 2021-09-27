package SWexpertAcademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class algo_1223_이주형 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        for (int test_case = 1; test_case <= 10; test_case++) {
            int n = Integer.parseInt(br.readLine());
            char[] numbers = br.readLine().toCharArray();

            Stack<Character> calculator = new Stack<>();
            Stack<Integer> sum = new Stack<>();
            char[] change = new char[n];
            int count = 0;

            for (int i = 0; i < n; i++) {
                if (numbers[i] >= '0' && numbers[i] <= '9') {
                    change[count++] = numbers[i];
                } else {
                    if (!calculator.isEmpty()) {
                        if (calculator.peek() == '*' && numbers[i] == '+') {
                            while (!calculator.isEmpty()) {
                                change[count++] = calculator.pop();
                            }
                        } else if (calculator.peek() == numbers[i]) {
                            change[count++] = calculator.pop();
                        }
                    }
                    calculator.push(numbers[i]);
                }
            }
            while (!calculator.isEmpty()) {
                change[count++] = calculator.pop();
            }

            int a = 0;
            int b = 0;
            for (int i = 0; i < n; i++) {
                if (change[i] >= '0' && change[i] <= '9') sum.push(change[i] - '0');
                else {
                    b = sum.pop();
                    a = sum.pop();
                    if (change[i] == '+') sum.push(a + b);
                    else sum.push(a * b);
                }
            }

            System.out.println("#" + test_case + " " + sum.pop());
        }
    }
}

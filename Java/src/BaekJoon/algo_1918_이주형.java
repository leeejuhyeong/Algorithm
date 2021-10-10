package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class algo_1918_이주형 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] input = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length; i++) {
            if (input[i] >= 'A' && input[i] <= 'Z') {           // 문자가 들어왔을 때는 bw에 바로 추가
                bw.append(input[i]);
            } else {                                            // 계산식이 들어왔을 때 : 계산식의 우선순위는 +, -가 가장 낮고 그다음 *, /임.
                if (!stack.isEmpty()) {
                    if (!(input[i] == '(')) {                   // 여는 괄호가 아닐 때만
                        while (!stack.isEmpty()) {              // 기본적으로 스택이 비워질때까지 반복
                            if (stack.peek() == '(') {          // 여는 괄호일때
                                if (input[i] == ')') stack.pop();       // 닫는 괄호가 들어왔을때만 여는 괄호 삭제
                                break;
                            }
                            if ((input[i] == '*' || input[i] == '/') && (stack.peek() == '+' || stack.peek() == '-'))   // *, / 이면서 스택에 가장 나중에 저장된 것이
                                break;                                                                                  //  +, -이면 그대로 스택에 저장 => pop 중지
                            bw.append(stack.pop());             // +, - 일경우 우선순위가 가장 낮으므로 +, -, *, / 모두 pop
                        }
                    }
                }
                if (input[i] == ')') continue;
                stack.push(input[i]);                           // 앞서있던 연산을 모두 처리한 후 스택에 저장(닫는 괄호는 무시)
            }
        }

        while (!stack.isEmpty()) bw.append(stack.pop());
        bw.flush();
        bw.close();
    }
}

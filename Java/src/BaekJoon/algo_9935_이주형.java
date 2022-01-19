package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class algo_9935_이주형 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        int input_len = input.length();
        String explousion = br.readLine();
        int explousion_len = explousion.length();

        Stack<Character> stack = new Stack<>();
        int sizeOfStack;
        boolean flag;                               // 폭발 문자열 확인 flag
        for (int i = 0; i < input_len; i++) {
            stack.push(input.charAt(i));            // 스택에 문자열 저장

            sizeOfStack = stack.size();
            if (sizeOfStack >= explousion_len) {        // 스택의 사이즈가 폭발 문자열의 길이보다 크거나 같을 때, 폭발할 문자가 있는지 탐색
                flag = true;
                for (int j = 0; j < explousion_len; j++) {
                    if (stack.get(sizeOfStack - explousion_len + j) != explousion.charAt(j)) {      // 폭발 문자가 없다면
                        flag = false;
                        break;
                    }
                }
                if (flag) {                                                                         // 폭발 문자가 있다면
                    for (int j = 0; j < explousion_len; j++) {
                        stack.pop();
                    }
                }
            }
        }

        if (stack.isEmpty()) {
            bw.append("FRULA");
        } else {
            for (Character character : stack) {
                bw.append(character);
            }
        }
        bw.flush();
        bw.close();
    }
}

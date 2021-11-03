package SWexpertAcademy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
// 21,348KB, 123ms
public class algo_4789_이주형 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        String input;
        int count;      // 현재 기립박수를 치는 사람
        int next;       // 다음 기립박수를 치기위해 필요한 사람
        int result;     // 고용해야하는 사람(답)

        for (int test_case = 1; test_case <= t; test_case++) {
            result = 0;
            input = br.readLine();
            count = input.charAt(0) - '0';        // 0번째 사람 = 아무도 없을 때 기립박수 치는 사람

            for (int i = 1; i < input.length(); i++) {
                next = input.charAt(i) - '0';
                if (count < i) {
                    result += i - count;
                    count += i - count;
                }
                count += next;
            }

            bw.append("#").append(String.valueOf(test_case)).append(" ").append(String.valueOf(result));
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}

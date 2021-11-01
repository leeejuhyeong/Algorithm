package SWexpertAcademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
// 18,720KB 110ms
public class algo_2007_이주형 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        String input;
        StringBuilder count;

        for (int test_case = 1; test_case <= t; test_case++) {
            input = br.readLine().trim();           // 문자열 초기화
            count = new StringBuilder();            // 반복되는 문자열(답)
            boolean flag = true;

            for (int i = 0; i < input.length(); i++) {      // 입력받은 문자열 0부터 끝까지 반복
                count.append(input.charAt(i));              // count에 넣어줌
                for (int j = 0; j < count.length(); j++) {      // count길이만큼 입력받은 문자열의 다음부터 같은지 비교
                    if (input.charAt(i + j + 1) != count.charAt(j)) {
                        flag = false;                       // 같지 않다면 flag false
                        break;
                    }
                }
                if (flag) break;                            // flag가 false가 아니면 다 같은 문자열이니 반복되는 문자열이므로 for문 탈출
                flag = true;
            }
            System.out.println("#" + test_case + " " + count.length());
        }
    }
}
/*
3
KOREAKOREAKOREAKOREAKOREAKOREA
SAMSUNGSAMSUNGSAMSUNGSAMSUNGSA
GALAXYGALAXYGALAXYGALAXYGALAXY
 */

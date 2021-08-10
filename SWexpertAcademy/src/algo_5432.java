import java.io.BufferedReader;
import java.io.InputStreamReader;

public class algo_5432 {
    static String input;
    static int result;

    // 스택 오버플로우 발생
//    public static void razer(int i, int cnt) {
//        if (i < input.length()) {
//            if (i + 1 < input.length() && input.charAt(i) == '(' && input.charAt(i + 1) == ')') {
//                result += cnt;
//                razer(i + 2, cnt);
//            } else if (input.charAt(i) == '(') {
//                razer(i + 1, cnt + 1);
//            } else if (input.charAt(i) == ')') {
//                result += 1;
//                razer(i + 1, cnt - 1);
//            }
//        }
//    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= t; test_case++) {
            input = br.readLine();
            result = 0;
            int count = 0;      // 쇠막대기 갯수
            for(int i = 0; i < input.length(); i++){
                if (i + 1 < input.length() && input.charAt(i) == '(' && input.charAt(i + 1) == ')') {       // 레이저일 경우 기존에 쇠막대기들이 잘라지면서 그 개수만큼 증가
                    result += count;
                    i += 1;
                } else if (input.charAt(i) == '(') {    // 새로운 쇠막대기가 생기면서 count 증가
                    count++;
                } else if (input.charAt(i) == ')') {    // 쇠막대기가 끝날 때 잘려지고 남은 것을 포함하기 때문에 reuslt 1 증가
                    result += 1;
                    count--;
                }
            }
            System.out.println("#" + test_case + " " + result);
        }
    }
}
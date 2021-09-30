package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// 18380KB, 184ms
public class algo_2635_이주형 {
    static int len = Integer.MIN_VALUE;
    static List<Integer> result;
    public static void makeNumbers(int n){
        for(int i = 1; i <= n; i++) {                   // 1 ~ n까지 두번째 숫자로 선택하면서 가장 긴 수열 판별.
            List<Integer> numbers = new ArrayList<>();

            numbers.add(n);
            numbers.add(i);

            int num = n - i;

            while(num >= 0){            // 음의 정수일 때 배열 생성 중지
                numbers.add(num);       // 양의 정수일 시 ArrayList에 저장.
                num = numbers.get(numbers.size() - 2) - numbers.get(numbers.size() - 1); // 다음 num[i] = num[i-2] + num[i-1]
            }

            if(numbers.size() > len){
                result = numbers;
                len = result.size();
            }
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());    // 첫번째 숫자

        makeNumbers(n);                             // 숫자 배열 생성

        sb.append(result.size()).append("\n");

        for(Integer number : result){
            sb.append(number).append(" ");
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }
}

// 규칙이 있는지 98 ~ 102까지 찾아보다가 38이라는 숫자가 반드시 들어가게되어서 이게 핵심이구나 생각했었음.
// 그러나 그런 규칙은 없고 2번째 숫자를 찾는 것이 핵심.
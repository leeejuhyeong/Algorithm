package SWexpertAcademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class algo_1984_이주형 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine().trim());
        int[] numbers;
        double sum;

        for(int test_case = 1; test_case <= t; test_case++){
            sum = 0;
            numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();        // 숫자 초기화
            Arrays.sort(numbers);           // 정렬

            for(int i = 1; i < numbers.length - 1; i++){        // 가장 작은 수와 가장 큰 수를 제외한 나머지 더하기
                sum += numbers[i];
            }
            sb.append("#").append(test_case).append(" ").append(Math.round(sum / 8));   // 평균구하기(Math.round메소드는 소수 첫째자리 반올림)
            sb.append("\n");
        }

        System.out.println(sb);
    }
}

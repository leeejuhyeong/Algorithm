package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class algo_2559_이주형 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int days = Integer.parseInt(input[0]);          // 전체 날짜 수
        int serial = Integer.parseInt(input[1]);        // 연속적인 날짜의 수

        Deque<Integer> deque = new LinkedList<>();      // 온도 저장
        int sum = 0;                                    // 연속적인 날짜의 온도 합
        int result = Integer.MIN_VALUE;                 // 가장 큰 온도합(answer)

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < days; i++){
            if(deque.size() == serial){                 // 연속적인 날짜일 경우
                if(result < sum) result = sum;          // 최대값 비교
                sum -= deque.pollFirst();               // 연속적인 날짜 다음 날 빼기
            }
            int temp = Integer.parseInt(st.nextToken());
            deque.offerLast(temp);                          // deque에 저장
            sum += temp;                                    // 온도 합
        }
        if(result < sum) result = sum;                  // 마지막날 연산

        System.out.println(result);
    }
}

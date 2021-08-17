package JUNGOL;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class algo_1828_이주형 {
    static class Chemical implements Comparable<Chemical> {
        int start;  // 화학물질 저장 최저 온도
        int end;    // 화학물질 저장 최고 온도

        public Chemical(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Chemical o) {
            int value = this.end - o.end;           // 최고 온도 기준으로 비교

            if (value != 0) return value;
            else {
                int temp = this.start - o.start;    // 최고 온도가 같을 시 최저 온도가 낮은 순으로 정렬
                return temp;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Chemical[] subset = new Chemical[n];        // 화확 물질 저장

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            subset[i] = new Chemical(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
        }

        Arrays.sort(subset);        // 화학물질 저장 최고 온도가 낮은 순서대로 정렬.
        Stack<Chemical> stack = new Stack<>();
        stack.push(subset[0]);
        int count = 0;

        for (int i = 1; i < n; i++) {
            if (stack.peek().end < subset[i].start) {   // 새로운 화학물질의 최저 온도가 스택에 저장된 저장 최고 온도 보다 클 경우
                count++;                        // 냉장고 추가
                stack.pop();                    // 스택에서 뺌
                stack.push(subset[i]);          // 스택에 새로운 화학물질 추가
            }
        }

        if (stack.size() != 0) count++;     // 스택이 비어있지 않을 경우 새로운 냉동고 필요
        System.out.println(count);

    }
}

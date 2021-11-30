package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class algo_14719_이주형 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Deque<Integer> deque = new LinkedList<>();
        deque.offerLast(Integer.parseInt(st.nextToken()));      // 첫 번째 높이 저장

        int next;
        int result = 0;
        int behind;
        for (int i = 1; i < w; i++) {
            next = Integer.parseInt(st.nextToken());        // 다음 높이
            if (deque.peekFirst() <= next) {                // 다음 높이가 현재 높이보다 같거나 높을 경우
                behind = deque.pollFirst();                 // deque에 쌓인 것은 첫번째보다 낮은 높이이니
                while (!deque.isEmpty()) {
                    result += behind - deque.pollFirst();   // 다 더해줌
                }
            }
            deque.offerLast(next);                          // 다음 높이가 높지 않다면 deque에 저장
        }

        if (!deque.isEmpty()) {
            behind = deque.pollLast();
            while (!deque.isEmpty()) {
                if (deque.peekLast() > behind) {
                    behind = deque.pollLast();
                } else {
                    result += behind - deque.pollLast();
                }
            }
        }

        System.out.println(result);

    }
}

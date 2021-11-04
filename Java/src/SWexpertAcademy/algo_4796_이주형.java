package SWexpertAcademy;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class algo_4796_이주형 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = sc.nextInt();
        int count;

        for (int test_case = 1; test_case <= t; test_case++) {
            int n = sc.nextInt();

            count = 0;
            boolean flag = false;   // flag가 false일때 -> 증가, flag가 true일때 -> 감소
            Deque<Integer> towering = new LinkedList<>();
            int temp = 0;
            for (int i = 0; i < n; i++) {
                int next = sc.nextInt();        // 다음 산의 높이
                if (towering.isEmpty()) {                            // 큐가 비어있을 경우 poll
                    towering.offerLast(next);
                    continue;
                }
                if(!flag) { // 산의 높이가 증가하고 있음   산이 증가하고 있으면서, 다음 산의 높이가 큰 경우 큐에 넣어줌
                    if (towering.peekLast() > next) {         // 다음 탑의 높이가 작을 경우 -> 우뚝 선 산
                        count += towering.size() - 1;       // 큐의 크기 - 1만큼 우뚝 선 산 가능.
                        temp = towering.size() - 1;     // 우뚝 선 산 개수 저장
                        flag = true;
                    }
                } else {    // 산의 높이가 감소하고 있음
                    if (towering.peekLast() > next) {               // 산이 감소하고 있으면서, 다음 산의 높이가 작은 경우
                        count += temp;                      // 기존 우뚝 선 산 개수 만큼 경우의 수 더해줌
                    }
                    else {
                        flag = false;
                        temp = 0;                   // 기존 경우의 수 초기화
                        int peek = towering.peekLast(); // 새로운 높이보다 작은 산
                        towering.clear();           // 큐 초기화
                        towering.offerLast(peek);       // 기존 큐에 다시 저장
                    }
                }
                towering.offerLast(next);
            }
            bw.append("#").append(String.valueOf(test_case)).append(" ").append(String.valueOf(count));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
/*
3
3
1 3 2
3
3 2 1
9
1 4 6 5 3 7 9 2 8


#1 1
#2 0
#3 6
 */
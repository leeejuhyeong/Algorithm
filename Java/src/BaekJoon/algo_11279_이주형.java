package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

public class algo_11279_이주형 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());     // 최대힙
        int input;

        for (int i = 0; i < n; i++) {
            input = Integer.parseInt(br.readLine());

            switch (input) {
                case 0:                                 // 0일 경우
                    if (priorityQueue.isEmpty()) {      // 힙이 비어있다면
                        bw.append(String.valueOf(0));   // 0출력
                    } else {
                        bw.append(String.valueOf(priorityQueue.poll()));    // 그렇지 않다면 최대값 출력
                    }
                    bw.newLine();
                    break;
                default:
                    priorityQueue.offer(input);         // 0이 아닐경우 힙에 추가
            }
        }
        bw.flush();
        bw.close();
    }
}

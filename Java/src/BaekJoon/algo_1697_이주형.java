package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class algo_1697_이주형 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[100001];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        int size, num;      // queue의 사이즈, 받는 값
        boolean flag = true;    // 무한 반복
        int result = 0;
        visited[n] = true;

        if(n == k) System.out.println(0);
        else {
            while (flag) {
                size = queue.size();
                result++;
                loop:
                for (int i = 0; i < size; i++) {
                    num = queue.poll();

                    int next;
                    for (int j = 0; j < 3; j++) {
                        if (j == 0) next = num + 1;
                        else if (j == 1) next = num - 1;
                        else next = 2 * num;

                        if (next == k) {
                            flag = false;
                            break loop;
                        }

                        if (next >= 0 && next <= 100000 && !visited[next]) {
                            visited[next] = true;
                            queue.offer(next);
                        }
                    }

                }
            }
            System.out.println(result);
        }
    }
}

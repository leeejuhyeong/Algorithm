package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class algo_15666_이주형 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n, m;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        Set<Integer> set = new HashSet<>();                 // 중복 수 제거
        PriorityQueue<Integer> pq = new PriorityQueue<>();  // 정렬 횟수 감소
        ArrayList<Integer> list = new ArrayList<>();        // 중복이 제거된 상태의 n을 정렬된 순서로 저장

        st = new StringTokenizer(br.readLine());
        int now;
        for (int i = 0; i < n; i++) {
            now = Integer.parseInt(st.nextToken());
            if (set.contains(now))
                continue;
            set.add(now);
            pq.offer(now);
        }

        while (!pq.isEmpty()) {
            list.add(pq.poll());
        }

        int[] save = new int[m];                    // 문자열 저장
        StringBuilder sb = new StringBuilder();     // 결과값 출력
        int len = list.size();
        permutation(0, 0, m, len, list, save, sb);

        System.out.println(sb);
    }

    private static void permutation(int start, int level, int m, int len, ArrayList<Integer> list, int[] save, StringBuilder sb) {
        if (level == m) {
            for (int i = 0; i < m; i++) {           // 만들어진 m 길이의 순열 출력
                sb.append(save[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < len; i++) {         // 0부터 중복을 제외한 len 개수만큼 반복
            save[level] = list.get(i);
            permutation(i, level + 1, m, len, list, save, sb);
        }
    }
}

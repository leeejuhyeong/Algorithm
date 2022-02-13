package Programmers;

import java.util.*;

public class MenuRenewal_KakaoBlindRecrument_2021 {
    public static void main(String[] args) {
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2, 3, 4};
        System.out.println(Arrays.toString(solution(orders, course)));
    }

    public static String[] solution(String[] orders, int[] course) {
        String[] answer;

        char[] sort;
        Map<String, Integer> count;
        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        boolean[] visited;
        for (int nowCourse : course) {
            count = new HashMap<>();
            for (String order : orders) {

                // 문자열 분해 및 정렬
                sort = order.toCharArray();
                Arrays.sort(sort);

                // 조합
                visited = new boolean[sort.length];
                dfs(0, 0, nowCourse, sort, visited, count);
            }
            int max = 2;
            List<String> list = new LinkedList<>();
            for (String order : count.keySet()) {
                if (count.get(order) > max) {
                    max = count.get(order);
                    list = new ArrayList<>();
                    list.add(order);
                } else if (count.get(order) == max)
                    list.add(order);
            }
            for (String canCourse : list) {
                pq.offer(canCourse);
            }
        }

        answer = new String[pq.size()];
        int size = pq.size();
        for (int i = 0; i < size; i++) {
            answer[i] = pq.poll();
        }

        return answer;
    }

    private static void dfs(int start, int level, int nowCourse, char[] sort, boolean[] visited, Map<String, Integer> count) {
        if (level == nowCourse) {
            String now = "";
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    now += sort[i];
                }
            }
            count.put(now, count.getOrDefault(now, 0) + 1);
            return;
        }

        for (int i = start; i < sort.length; i++) {
            visited[i] = true;
            dfs(i + 1, level + 1, nowCourse, sort, visited, count);
            visited[i] = false;
        }

    }

// 문자열마다 배열로 만들면서 정렬하고
// 조합으로 문자열 만들고
// map에다 키를 문자열 값을 횟수로 저장
// 그 조합 주문이 2번 이상일 때 pq에 저장
}

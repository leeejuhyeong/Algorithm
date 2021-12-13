package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class algo_7662_이주형 {
    public static BufferedReader br;
    public static BufferedWriter bw;
    public static StringTokenizer st;
    public static PriorityQueue<Integer> minPriority;
    public static PriorityQueue<Integer> maxPriority;
    public static HashMap<Integer, Integer> removeMinHash;
    public static HashMap<Integer, Integer> removeMaxHash;

    public static void makePQ() throws Exception {
        int k = Integer.parseInt(br.readLine());
        int num;
        String calculation;

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            calculation = st.nextToken();
            num = Integer.parseInt(st.nextToken());

            if (calculation.equals("I")) {      // Input연산일 경우 각각 min, max 우선순위 큐에 저장.
                minPriority.offer(num);
                maxPriority.offer(num);
            } else {                            // Delete일 경우
                if (maxPriority.isEmpty() || minPriority.isEmpty()) continue;
                int current;
                if (num == 1) {                             // 최대값 제거일 경우
                    current = maxPriority.poll();           // 최대 우선순위 큐에서 poll한 값을

                    if (removeMinHash.containsKey(current)) {           // min우선순위큐에서도 삭제해야하므로 removeMinHash에 (제거하는 값, 개수)로 저장.
                        removeMinHash.replace(current, removeMinHash.get(current) + 1);         // 개수는 중복되는 숫자의 제거 횟수를 카운팅하기 위해
                    } else removeMinHash.put(current, 1);
                } else {                                                // 최소값 제거일 경우
                    current = minPriority.poll();

                    if (removeMaxHash.containsKey(current)) {           // max우선순위큐에서도 삭제해야하므로 removeMaxHash에 (제거하는 값, 개수)로 저장.
                        removeMaxHash.replace(current, removeMaxHash.get(current) + 1);
                    } else removeMaxHash.put(current, 1);
                }

                while (removeMinHash.containsKey(minPriority.peek())) {     // 최소 우선순위큐의 peek가 제거해야하는 값(removeMinHash에 키가 존재)일 경우 삭제
                    current = minPriority.poll();

                    if (removeMinHash.get(current) == 1) {              // 해당 값이 1개일경우 hash에서 삭제
                        removeMinHash.remove(current);
                    } else {
                        removeMinHash.replace(current, removeMinHash.get(current) - 1);     // 여러 개일 경우 1 빼줌
                    }
                }

                while (removeMaxHash.containsKey(maxPriority.peek())) {     // 최대 우선순위큐의 peek가 제거해야하는 값(removeMaxHash에 키가 존재)일 경우 삭제
                    current = maxPriority.poll();

                    if (removeMaxHash.get(current) == 1) {              // 해당 값이 1개일 경우 hash에서 삭제
                        removeMaxHash.remove(current);
                    } else {
                        removeMaxHash.replace(current, removeMaxHash.get(current) - 1);     // 여러 개일 경우 1 빼줌
                    }
                }
            }
        }
        if (maxPriority.isEmpty() || minPriority.isEmpty()) bw.append("EMPTY");             // max혹은 min 우선순위큐 둘중 하나라도 비엇을 경우 empty
        else bw.append(String.valueOf(maxPriority.peek())).append(" ").append(String.valueOf(minPriority.peek()));
        bw.newLine();
    }

    // 우선순위 큐, Hasp 사용해서 이중우선순위 큐 구현
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            minPriority = new PriorityQueue<>();
            maxPriority = new PriorityQueue<>(Collections.reverseOrder());
            removeMinHash = new HashMap<>();
            removeMaxHash = new HashMap<>();

            makePQ();
        }
        bw.flush();
        bw.close();
    }

    // TreeMap 사용
    public static void main2(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        int t = Integer.parseInt(br.readLine());
        int k, input;
        String calculation;

        TreeMap<Integer, Integer> treeMap;

        for (int i = 0; i < t; i++) {
            k = Integer.parseInt(br.readLine());

            treeMap = new TreeMap<>();

            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                calculation = st.nextToken();
                input = Integer.parseInt(st.nextToken());

                if (calculation.equals("I")) {
                    if (treeMap.containsKey(input)) {
                        treeMap.put(input, treeMap.get(input) + 1);
                        continue;
                    }
                    treeMap.put(input, 1);
                } else {
                    if (treeMap.isEmpty()) continue;
                    int key, value;

                    key = input == 1 ? treeMap.lastKey() : treeMap.firstKey();
                    value = treeMap.get(key);
                    if (value != 1) {
                        treeMap.put(key, value - 1);
                    } else {
                        treeMap.remove(key);
                    }
                }
            }
            treeMap.lastEntry();
            if (treeMap.size() == 0) bw.append("EMPTY");
            else {
                bw.append(String.valueOf(treeMap.lastKey())).append(" ").append(String.valueOf(treeMap.firstKey()));
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
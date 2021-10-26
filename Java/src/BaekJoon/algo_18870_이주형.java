package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class algo_18870_이주형 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] list = new int[n];
        int input;
        TreeMap<Integer, List<Integer>> treeMap = new TreeMap<>();      // 좌표를 트리맵에 저장

        st = new StringTokenizer(br.readLine());
        List<Integer> temp;
        for (int i = 0; i < n; i++) {
            input = Integer.parseInt(st.nextToken());               // 좌표
            if (treeMap.containsKey(input)) {                       // 트리맵에 이미 저장된 key(값)이라면
                temp = treeMap.get(input);                          // 트리맵에서 해당 리스트 가져오기
            } else {
                temp = new LinkedList<>();                          // 그렇지 않다면 새로운 리스트 생성(리스트 초기화)
            }
            temp.add(i);                                            // 해당 좌표값 저장
            treeMap.put(input, temp);                               // 트리맵에 저장 (key : 좌표값, value : 저장된순서(i번째)
        }                                                           // 즉, i번째 좌표인 좌표값 key, 정렬은 좌표값이 낮은 순서대로 정렬되어 저장됨.

        while (!treeMap.isEmpty()) {
            int last = treeMap.lastKey();                   // 큰값의 좌표부터 불러오기
            temp = treeMap.get(last);

            for (int a : temp) {                        // temp 리스트 순회 => 몇번째 좌표인가
                list[a] = treeMap.size() - 1;           // 해당 배열에 트리노드의 사이즈 - 1을 입력.
            }
            treeMap.remove(last);                       // 배열에 다 입력한 후 해당 키 트리맵에서 삭제
        }

        for (int a : list) {
            sb.append(a).append(" ");                   // 출력
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }
}
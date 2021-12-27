package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class algo_17471_이주형 {

    static int N, half, countA, countB, pA, pB, visited, P[], MIN;
    static int[][] map;
    static boolean[] selected;
    static ArrayList<Integer> aList, bList;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(in.readLine());
        half = N / 2;
        map = new int[N][N];
        selected = new boolean[N];
        P = new int[N];
        MIN = Integer.MAX_VALUE;

        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        //입력 처리
        for (int i = 0; i < N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0, j = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine(), " ");
            int cnt = Integer.parseInt(st.nextToken());
            for (int c = 0; c < cnt; c++) {
                j = Integer.parseInt(st.nextToken()) - 1;
                map[j][i] = map[i][j] = 1;
            }
        }
        //입력 처리 완료

        for (int i = 1; i <= half; i++) {
            divide(0, 0, i);
        }
        System.out.println(MIN == Integer.MAX_VALUE ? -1 : MIN);
    }

    //지역구 나누기
    private static void divide(int index, int cnt, int target) {
        if (cnt == target) {
            compare();
            return;
        }
        //true --> A, false-> B
        for (int j = index; j < N; j++) {
            selected[j] = true;
            divide(j + 1, cnt + 1, target);
            selected[j] = false;
        }

    }

    private static void compare() {
        aList = new ArrayList<Integer>();
        bList = new ArrayList<Integer>();
        for (int i = 0; i < N; i++) { // 지역구 나누어 넣기.
            if (selected[i]) aList.add(i);
            else bList.add(i);
        }
        countA = countB = pA = pB = 0;
        visited = 0;
        //A지역구 dfs 탐색
        dfs(aList, aList.get(0), true);
//		bfs(aList,true);
        if (countA != aList.size()) return;

        visited = 0;
        //B지역구 dfs 탐색
        dfs(bList, bList.get(0), false);
//		bfs(bList,false);
        if (countB != bList.size()) return;

        if (MIN > Math.abs(pA - pB)) MIN = Math.abs(pA - pB);

    }

    private static void dfs(ArrayList<Integer> list, int v, boolean type) {
        visited |= 1 << v;
        if (type) {
            countA++;
            pA += P[v];
        } else {
            countB++;
            pB += P[v];
        }

        for (int i = 0; i < N; i++) {
            //리스트에 포함되고, 정점끼리 연결되어 있는지, 방문한적 있는지 확인
            if (list.contains(i) && map[v][i] > 0 && (visited & 1 << i) == 0) {
                dfs(list, i, type);
            }
        }
    }

    private static void bfs(ArrayList<Integer> list, boolean type) {

        Queue<Integer> queue = new LinkedList<Integer>();
        int start = list.get(0);
        queue.offer(start);
        visited |= 1 << start;

        while (!queue.isEmpty()) {
            int v = queue.poll();
            if (type) {
                countA++;
                pA += P[v];
            } else {
                countB++;
                pB += P[v];
            }

            for (int i = 0; i < N; i++) {
                if (list.contains(i) && map[v][i] > 0 && (visited & 1 << i) == 0) {
                    visited |= 1 << i;
                    queue.offer(i);
                }
            }
        }
    }
}

/*
1. 구역을 2개의 선거구로 나누기.
    -> 각 선거구에 1개 이상 구역을 반드시 포함.
    -> 특정 지역 뽑기(1구역), 나머지 구역들(2구역)
    ex ) 전체 {1, 2, 3, 4, 5, 6}
    -> 1구역 : {1}, 2구역 : {2, 3, 4, 5, 6}
        ~ 1구역 : {2, 3, 4, 5, 6}, 2구역 {1}
    => 조합 또한 부분집합으로 접근 가능
2. 각 선거구의 연결성 확인
3. 최소값 확인
 */
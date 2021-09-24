package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class algo_1927_이주형 {
    // 27316KB, 328ms
//    public static void main(String[] args) throws Exception{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        int n = Integer.parseInt(br.readLine());
//        int input;
//        PriorityQueue<Integer> pq = new PriorityQueue<>();        // 우선순위 큐 사용해 최소힙 구하기
//
//        for(int i = 0; i < n; i++){
//            input = Integer.parseInt(br.readLine());
//            if(input == 0){                       // 0일때
//                if(pq.isEmpty()){                 // 우선순위 큐가 비어있다면 0 출력
//                    bw.append("0");
//                } else{
//                    bw.append(String.valueOf(pq.poll())); // 그렇지 않다면 poll
//                }
//                bw.newLine();
//            } else{
//                pq.offer(input);              // 0이 아닐때 우선순위 큐에 삽입
//            }
//        }
//        bw.flush();
//        bw.close();
//    }

    // 최소힙 구현
    // 24508KB, 328ms
    public static class Heap {
        int size;       // 트리 길이, 초기 10;
        int idx;        // 다음 삽입 노드 인덱스
        int[] tree;     // 트리를 배열로 선언

        public Heap() {
            idx = 0;
            size = 10;
            tree = new int[10];
        }

        public void resize() {      // 트리 배열의 크기를 벗어났을 때, 크기 증가
            int[] now_tree = new int[size * 2];

            for (int i = 0; i < size; i++) {
                now_tree[i] = tree[i];
            }
            size *= 2;
            tree = now_tree;
        }

        public void add(int a) {    // 새로운 노드 추가 시 -> 배열의 맨 끝에 삽입, 부모와 비교해 새로운 노드 값이 더 클 시 위로
            tree[idx] = a;
            make_min();
            idx++;
            if (idx == size) {
                resize();
            }
        }

        public void make_min() {        // 부모와 비교, 최소힙 만드는 메소드
            int temp, parent, now;
            now = idx;
            while (true) {
                parent = (now + 1) / 2 - 1;
                if (parent < 0) break;
                if (tree[now] < tree[parent]) {
                    temp = tree[now];               // swqp
                    tree[now] = tree[parent];
                    tree[parent] = temp;
                    now = parent;
                } else break;
            }
        }

        public int pop() {      // 루트 노드를 출력, 루트 노드에 마지막 노드 값 삽입, 자식과 비교하면서 최소힙 만들기 => 엉성하게 코딩, 아마 메모리 효율이 나쁠것이라 예상
            int min = tree[0];
            if (idx == 1) {
                tree[0] = 0;
                idx--;
            } else {
                tree[0] = tree[--idx];
                tree[idx] = 0;
            }

            int temp, lchild, rchild, now;
            now = 0;
            while (true) {
                lchild = (now + 1) * 2 - 1;
                rchild = (now + 1) * 2;

                if (lchild < idx && rchild < idx) {
                    if (tree[lchild] >= tree[rchild]) {
                        if (tree[now] > tree[rchild]) {
                            temp = tree[now];
                            tree[now] = tree[rchild];
                            tree[rchild] = temp;
                            now = rchild;
                        } else break;
                    } else {
                        if (tree[now] > tree[lchild]) {
                            temp = tree[now];
                            tree[now] = tree[lchild];
                            tree[lchild] = temp;
                            now = lchild;
                        } else break;
                    }
                } else if (lchild < idx) {
                    if (tree[now] > tree[lchild]) {
                        temp = tree[now];
                        tree[now] = tree[lchild];
                        tree[lchild] = temp;
                        now = lchild;
                    } else break;
                } else break;
            }
            return min;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int input;
        Heap heap = new Heap();

        for (int i = 0; i < n; i++) {
            input = Integer.parseInt(br.readLine());

            if (input == 0) {
                if (heap.idx == 0) bw.append("0");
                else bw.append(String.valueOf(heap.pop()));
                bw.newLine();
            } else {
                heap.add(input);
            }
        }
        bw.flush();
        bw.close();
    }


}

/*
13 15 8 23 4 2 1 3 9 22 48 3 90 34
15
0
0
8
23
4
0
2
1
0
0
0
3
9
22
48
3
90
34
 */

// https://github.com/KJY97/Algo-Study/blob/main/2week/leeejuhyeong/algo_1463_이주형.java
// https://github.com/KJY97/Algo-Study/blob/main/2week/leeejuhyeong/algo_1463_이주형.java
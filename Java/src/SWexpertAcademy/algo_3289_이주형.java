package SWexpertAcademy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// DisJointSet - Union_Find Algorithm
public class algo_3289_이주형 {
    private static void make(int[] disjoinSet){                 // 서로소 집합 생성
        for(int i = 1; i < disjoinSet.length; i++){
            disjoinSet[i] = i;
        }
    }

    private static int find(int x, int[] disjoinSet){           // root 찾기
        if(disjoinSet[x] == x) return x;                        // 자기자신, 즉 root일 시 반환
        return disjoinSet[x] = find(disjoinSet[x], disjoinSet);     // 루트가 아닐 시 재귀하면서 자신의 루트로 포인터 설정
    }

    private static void union(int a, int b, int[] disjoinSet){       // 집합 합치기(a <- b)
        int aRoot = find(a, disjoinSet);        // a의 루트
        int bRoot = find(b, disjoinSet);        // b의 루트
        if(aRoot == bRoot) return;        // 이미 서로 같은 집합

        disjoinSet[bRoot] = aRoot;
    }

    private static boolean unionCheck(int a, int b, int[] disjoinSet){
        int aRoot = find(a, disjoinSet);        // a의 루트
        int bRoot = find(b, disjoinSet);        // b의 루트

        return aRoot == bRoot;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        int t = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= t; test_case++){
            bw.append("#").append(String.valueOf(test_case)).append(" ");
            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());           // 집합의 개수
            int m = Integer.parseInt(st.nextToken());           // 연산 개수

            int[] disjointSet = new int[n+1];

            make(disjointSet);
            int set, a, b;

            for(int i = 0; i < m; i++){
                st = new StringTokenizer(br.readLine(), " ");
                set = Integer.parseInt(st.nextToken());             // 0: 합집합, 1: 포함여부 확인
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());

                switch(set){
                    case 0:
                        union(a, b, disjointSet);           // 합집합 생성
                        break;
                    case 1:
                        if(unionCheck(a, b, disjointSet)) bw.append("1");       // 같은 집합이면 1
                        else bw.append("0");                                    // 다른 집합이면 0
                        break;
                }
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
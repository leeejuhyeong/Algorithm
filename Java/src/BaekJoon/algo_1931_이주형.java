package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// Greedy문제
public class algo_1931_이주형 {
    public static class Session implements Comparable<Session>{
        int start;
        int end;

        Session(int start, int end){
            this.start = start;
            this.end = end;
        }


        @Override
        public int compareTo(Session o) {       // 끝나는 시간을 기준으로 정렬(같을 시 회의 시간이 짧은 것을 먼저)
            if(this.end != o.end)
                return this.end - o.end;
            else
                return this.start - o.start;
        }
    }
    // 회의 객체선언해서 회의 배열로 Arrays.sort
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        Session[] sessions = new Session[n];
        int start, end;

        for(int i = 0; i < n;  i++){
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());

            sessions[i] = new Session(start, end);
        }

        Arrays.sort(sessions);              // 회의 시간이 빠른 순서대로 정렬된 배열
        List<Session> sequence = new LinkedList<>();
        sequence.add(sessions[0]);

        for(int i = 1; i < n; i++){
            if(sequence.get(sequence.size() - 1).end <= sessions[i].start){     // 끝나는 시간보다 시작하는 시간이 앞서는건 무시
                sequence.add(sessions[i]);
            }
        }
        System.out.println(sequence.size());
    }

    // 회의 객체를 우선순위 큐로 정렬
    public static void main2(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Session> pq = new PriorityQueue<>();
        int start, end;

        for(int i = 0; i < n;  i++){
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());

            pq.offer(new Session(start, end));
        }

        Session current = pq.poll();
        end = current.end;
        int cnt = 1;

        while(!pq.isEmpty()){
            current = pq.poll();
            if(end <= current.start){
                cnt++;
                end = current.end;
            }
        }

        System.out.println(cnt);
    }

    // 회의 객체 사용X
    public static void main3(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] != o2[1]){
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });
        int start, end;

        for(int i = 0; i < n;  i++){
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());

            pq.offer(new int[]{start, end});
        }

        int[] current = pq.poll();
        end = current[1];
        int cnt = 1;

        while(!pq.isEmpty()){
            current = pq.poll();
            if(end <= current[0]){
                cnt++;
                end = current[1];
            }
        }

        System.out.println(cnt);
    }
}

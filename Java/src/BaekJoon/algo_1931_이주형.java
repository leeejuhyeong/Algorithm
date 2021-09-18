package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class algo_1931_이주형 {
    public static class Session implements Comparable<Session>{
        int start;
        int end;

        Session(int start, int end){
            this.start = start;
            this.end = end;
        }


        @Override
        public int compareTo(Session o) {
            if(this.end != o.end)
                return this.end - o.end;
            else
                return this.start - o.start;
        }
    }
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

        Arrays.sort(sessions);
        List<Session> sequence = new LinkedList<>();
        sequence.add(sessions[0]);

        for(int i = 1; i < n; i++){
            if(sequence.get(sequence.size() - 1).end <= sessions[i].start){
                sequence.add(sessions[i]);
            }
        }

        System.out.println(sequence.size());

    }
}

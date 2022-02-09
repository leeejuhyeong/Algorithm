package BaekJoon;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class algo_18258_이주형 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Deque<Integer> deque = new LinkedList<>();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push":
                    deque.offerLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    if(!deque.isEmpty())
                        bw.write(deque.pollFirst() + "\n");
                    else
                        bw.write(-1 + "\n");
                    break;
                case "size":
                        bw.write(deque.size() + "\n");
                    break;
                case "empty":
                    if(!deque.isEmpty())
                        bw.write(0 + "\n");
                    else
                        bw.write(1 + "\n");
                    break;
                case "front":
                    if(!deque.isEmpty())
                        bw.write(deque.peekFirst() + "\n");
                    else
                        bw.write(-1 + "\n");
                    break;
                case "back":
                    if(!deque.isEmpty())
                        bw.write(deque.peekLast() + "\n");
                    else
                        bw.write(-1 + "\n");
                    break;
            }
        }
        bw.flush();
        bw.close();
    }
}

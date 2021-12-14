package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;

public class algo_5430_이주형 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        String p, temp;
        int n;
        char[] input;
        Deque<String> deque;
        for (int i = 0; i < t; i++) {
            deque = new LinkedList<>();
            p = br.readLine();
            n = Integer.parseInt(br.readLine());
            input = br.readLine().toCharArray();

            temp = "";
            for (int j = 0; j < input.length; j++) {
                if (input[j] != '[' && input[j] != ']') {
                    if (input[j] != ',') {
                        temp += input[j];
                    } else {
                        deque.offerLast(temp);
                        temp = "";
                    }
                }
            }
            if (n != 0 && !temp.equals(""))
                deque.offerLast(temp);

            boolean reverse = true;
            boolean flag = true;
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == 'R') {
                    reverse = !reverse;
                } else {
                    if (deque.isEmpty()) {
                        flag = false;
                        break;
                    }
                    if (reverse)
                        deque.pollFirst();
                    else
                        deque.pollLast();
                }
            }

            if (flag) {
                bw.append("[");
                if(!deque.isEmpty()) {
                    StringBuilder sb = new StringBuilder();
                    while (!deque.isEmpty()) {
                        if (reverse)
                            sb.append(deque.pollFirst());
                        else
                            sb.append(deque.pollLast());
                        sb.append(",");
                    }
                    sb.setLength(sb.length() - 1);
                    bw.append(sb.toString());
                }
                bw.append("]");
            } else {
                bw.append("error");
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}

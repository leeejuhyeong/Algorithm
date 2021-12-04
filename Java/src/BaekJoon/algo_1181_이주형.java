package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class algo_1181_이주형 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        List<String> list = new ArrayList<>();
        for (int i = 0; i < t; i++) {
            list.add(br.readLine());
        }

        list.sort((a1, b1) -> {
            int a = a1.length();
            int b = b1.length();

            if(a == b){
                return a1.compareTo(b1);
            }else {
                return a - b;
            }
        });


        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((o1, o2) -> {
            if(o1[1] > o2[1]){
                return -1;
            }
            return 1;
        });
        bw.append(list.get(0));
        bw.newLine();
        for (int i = 1; i < list.size(); i++) {
            if(list.get(i).equals(list.get(i - 1))) continue;
            bw.append(list.get(i));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}

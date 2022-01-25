package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class algo_11286_이주형 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int x, absX;
        TreeMap<Integer, Integer> nowTm;
        int now;
        TreeMap<Integer, TreeMap<Integer, Integer>> tm = new TreeMap<>();       // key = 절대값, TreeMap = 절대값 중 작은 값

        for (int i = 0; i < n; i++) {
            x = Integer.parseInt(br.readLine());
            switch (x) {
                case 0:
                    if(tm.isEmpty()) bw.write(0 + "\n");
                    else {
                        nowTm = tm.get(tm.firstKey());          // 절대값이 가장 작은 트리맵
                        now = nowTm.firstKey();      // 그 중 가장 작은 값
                        bw.write(now + "\n");               // 출력

                        if (nowTm.get(now) == 1) {
                            nowTm.remove(now);
                        } else {
                            nowTm.put(now, nowTm.get(now) - 1);
                        }

                        if (!nowTm.isEmpty()) {
                            tm.put(tm.firstKey(), nowTm);       // 비어있다면 트리맵에 넣지 않기
                        } else {
                            tm.remove(tm.firstKey());
                        }
                    }
                    break;
                default:
                    absX = Math.abs(x);
                    if(tm.containsKey(absX)) {              // 절대값이 tm에 있을 때
                        nowTm = tm.get(absX);
                        if(nowTm.containsKey(x)) {          // 중복된 값일 때
                            nowTm.put(x, nowTm.get(x) + 1);
                        } else {
                            nowTm.put(x, 1);
                        }
                        tm.put(absX, nowTm);
                    } else {
                        nowTm = new TreeMap<>();
                        nowTm.put(x, 1);
                        tm.put(absX, nowTm);
                    }
                    break;
            }
        }
        bw.flush();
        bw.close();
    }
}

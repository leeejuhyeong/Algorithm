package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class algo_1764_이주형 {
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        int n = Integer.parseInt(st.nextToken());
//        int m = Integer.parseInt(st.nextToken());
//
//        Map<String, String> list = new HashMap<>();
//        String input;
//
//        for (int i = 0; i < n; i++) {
//            input = br.readLine();
//            list.put(input, input);
//        }
//
//        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                if (o1.length() >= o2.length()) {
//                    for (int i = 0; i < o2.length(); i++) {
//                        if(o1.charAt(i) == o2.charAt(i)) continue;
//                        return o1.charAt(i) - o2.charAt(i);
//                    }
//                    return 1;
//                } else {
//                    for (int i = 0; i < o1.length(); i++) {
//                        if(o1.charAt(i) == o2.charAt(i)) continue;
//                        return o1.charAt(i) - o2.charAt(i);
//                    }
//                    return -1;
//                }
//            }
//        });
//
//        for(int i = 0 ;i < m; i++){
//            input = br.readLine();
//            if(list.containsKey(input)) pq.offer(input);
//        }
//
//        int size = pq.size();
//        System.out.println(size);
//        for(int i = 0; i < size; i++){
//            System.out.println(pq.poll());
//        }
//    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashSet<String> list = new HashSet<>(); // set과 차이X, treeset 집합에 정렬도 함, 듣도못한 사람 저장
        List<String> nonSee = new ArrayList<>();    // 듣지도 보지도 못한 사람 저장
        String input;

        for (int i = 0; i < n; i++) {
            input = br.readLine();
            list.add(input);
        }

        int count = 0;
        for(int i = 0; i < m; i++){
            input = br.readLine();
            if(list.contains(input))
            {
                nonSee.add(input);
                count++;
            }
        }

        Collections.sort(nonSee);       // 사전순 정렬
        StringBuilder sb = new StringBuilder();

        sb.append(count).append("\n");
        for(String a : nonSee){
            sb.append(a).append("\n");
        }

        System.out.println(sb);

    }
}

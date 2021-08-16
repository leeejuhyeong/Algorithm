import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class goormCrossingTheBridge {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] persons = new int[n];
//        Deque<Integer> deque = new LinkedList<>();
        List<Integer> front = new LinkedList<>();
        List<Integer> behind = new LinkedList<>();

        for(int i = 0; i < n; i++){
            persons[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(persons);

        for(int i = 0; i < n; i++){
//            deque.offerLast(persons[i]);
            front.add(persons[i]);
        }

        int result = 0;
//        int first = persons[0];
//        int second;
//        if(n == 1) second = first;
//        else second = persons[1];

//            while(true){
//            deque.pollFirst();
//            deque.pollFirst();
//            result += second;
//
//            if(deque.isEmpty()) break;
//
//            deque.offerFirst(first);
//            result += first;
//
//            result += deque.pollLast();
//            deque.pollLast();
//
//            if(deque.isEmpty()) break;
//
//            deque.offerFirst(second);
//            result += second;
//        }

        while(true){
            if(front.size() == 1){
                result += front.get(0);
                break;
            }
            behind.add(0, front.get(0));           // 제일 빠른 두명 넘어가기
            front.remove(0);
            behind.add(1, front.get(0));
            result += front.get(0);
            front.remove(0);

            if(front.size() == 0) break;

            front.add(0, behind.get(0));        // 제일 빠른 한명 돌아가기
            behind.remove(0);
            result += front.get(0);

            behind.add(front.get(front.size() - 1));    // 제일 느린 두명 넘어가기
            front.remove(front.size() - 1);
            behind.add(behind.size() - 1, front.get(front.size() - 1));
            front.remove(front.size() - 1);
            result += behind.get(behind.size() - 1);

            if(front.size() == 0) break;

            front.add(1, behind.get(0));        // 두번째로 빠른 한명 돌아가기
            result += behind.get(0);
            behind.remove(0);
        }

        System.out.println(result);
    }
}

/*
10 20 30 40 50 60 70 -> 0
30 40 50 60 70 -> 10 20 (20)
10 30 40 50 60 70 -> 20 (10)    30
10 30 40 50 -> 20 60 70 (70)    100
10 20 30 40 50 -> 60 70 (20)    120

30 40 50 -> 10 20 60 70 (20)    140
10 30 40 50  -> 20 60 70 (10)   150
10 30 -> 20 40 50 60 70 (50)    200
10 20 30 -> 40 50 60 70 (20)    220

30 -> 10 20 40 50 60 70  (20)   240
10 30 -> 20 40 50 60 70 (10)    250
0 -> 10 20 30 40 50 60 70 (30)  280

1 1 1 1 -> 0
1 1 -> 1 1 (1)
1 1 1 -> 1 (1)
1 -> 1 1 1 (1)
1 1 -> 1 1 (1)
0 -> 1 1 1 1 (1) 5

1 1 1 1 1 -> 0
1 1 1 -> 1 1 (1)
1 1 1 1 -> 1 (1)
1 1 -> 1 1 1 (1)
1 1 1 -> 1 1  (1)
1 -> 1 1 1 1 (1)
1 1 -> 1 1 1 (1)
0 -> 1 1 1 1 1 ( 1) 7

1 1 2 -> 0
1 -> 1 2 (2)
1 1 -> 2 (1)
0 -> 1 1 2 (1)

1 1 2 -> 0
2 -> 1 1 (1)
1 2 -> 1 (1)
0 -> 1 1 2 (2)
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class algo_2164_이주형 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        Deque<Integer> deque = new LinkedList<>();

        /*
        1 2 3 4 5 6 7
        2 3 4 5 6 7 -> 3 4 5 6 7 2
        4 5 6 7 2 -> 5 6 7 2 4
        6 7 2 4 -> 7 2 4 6       홀수는 queue에 안들어감, for문을 n번 돌렸을 때 결과적으로 짝수만 들어감.
         */
        for(int i = 2; i <= n; i+=2){
            deque.offerLast(i);        // 짝수만 deque에 넣음.
        }
        if(n % 2 == 1) deque.offerFirst(n);  // 마지막이 홀수일 경우 앞에 추가.

        while(true){
            if(deque.size() == 1){
                System.out.println(deque.pollFirst());
                break;
            }
            deque.pollFirst();              // 앞에 빼주고 그다음 것 뒤로 이동.2
            deque.offerLast(deque.pollFirst());
        }
    }
}

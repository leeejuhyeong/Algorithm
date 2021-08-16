import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class algo_2493 {
    static public class Tower{
        int height;
        int index;

        Tower(int height, int index){
            this.height = height;
            this.index = index;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Deque<Tower> deque = new LinkedList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= n; i++){
            int height = Integer.parseInt(st.nextToken());
            while(!deque.isEmpty()){
                if(deque.peekLast().height >= height) {
                    System.out.print(deque.peekLast().index + " ");
                    break;
                } deque.pollLast();
            }
            if(deque.isEmpty()) System.out.print("0 ");
            deque.offer(new Tower(height, i));
        }
    }
}

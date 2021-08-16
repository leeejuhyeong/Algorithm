import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class ATM {
    public static void main(String[] args) throws IOException {
        List<Integer> list = new ArrayList();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        int total = 0;
        int sum = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < T; i++){
            int temp = Integer.parseInt(st.nextToken());
            list.add(temp);
        }

        Collections.sort(list);

        for(Integer integer : list){
            sum += integer;
            total += sum;
        }

        System.out.println(total);
    }
}



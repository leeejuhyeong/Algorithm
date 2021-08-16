import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class RollCake_16206 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int cnt = 0;

        List<Integer> rollcakes = new ArrayList<>();        // 10으로 나누어 떨어지지 않는 케이크
        List<Integer> zero = new ArrayList<>();             // 10으로 나누어 떨어지는 케이크

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int rollcake = Integer.parseInt(st.nextToken());
            if (rollcake % 10 == 0) zero.add(rollcake);
            else {
                rollcakes.add(rollcake);
            }
        }

        Collections.sort(rollcakes);
        Collections.sort(zero);

        for (Integer integer : zero) {
            if (integer == 10) cnt++;
            else {
                int shape = integer / 10;
                for (int j = 1; j < shape; j++) {
                    if (m == 0) break;
                    m--;
                    cnt++;
                    if (j == shape - 1) cnt++;
                }
            }
        }

        if(m != 0){
            for(Integer integer : rollcakes){
                if(m == 0) break;
                if(integer > 10){
                    int shape = integer / 10;
                    for(int j = 1; j <= shape; j++){
                        if(m== 0) break;
                        m--;
                        cnt++;
                    }
                }
            }
        }
        System.out.println(cnt);

    }
}

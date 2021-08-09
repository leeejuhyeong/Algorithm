import java.io.BufferedReader;
import java.io.InputStreamReader;

public class algo_1940 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= t; test_case++){
            int n = Integer.parseInt(br.readLine());
            int result = 0;
            int now_accel = 0;

            for(int i = 0; i < n; i++) {
                String[] input = br.readLine().split(" ");
                int gear = Integer.parseInt(input[0]);      // 1 : 가속, 2 : 감속
                int accel = 0;                              // 가속도
                if(gear != 0) accel = Integer.parseInt(input[1]);  // 0일때 현재속도 유지

                if(gear == 1){
                    now_accel += accel;
                } else if(gear == 2){
                    now_accel -= accel;
                    if(now_accel < 0) now_accel = 0;
                }
                result += now_accel;
            }
            System.out.println("#" + test_case + " " + result);
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RollCake {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int l = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[] rollcake = new int[l+1];
        int prediction = 0;
        int prediction_person = Integer.MAX_VALUE;
        int real = 0;
        int real_person = 0;

        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());       // 방문자가 적은 케이크의 시작 번호
            int end = Integer.parseInt(st.nextToken());         // 방문자가 적은 케이크의 끝 번호
            int temp = 0;

            if((end-start) + 1 >= prediction) {                 // 케이크를 받는 예상 수량 : 현재 사람의 받는 수량 > 기존에 가장 많이 받는 수량
                if(end-start + 1 == prediction) prediction_person = Math.min(i, prediction_person);     // 수량이 같을 경우 번호가 작은 사람
                else {
                    prediction = end - start + 1;
                    prediction_person = i;
                }
            }

            for(int j = start; j <= end; j++){
                if(rollcake[j] != 0) continue;      // 이미 받아간거면 무시
                else{
                    rollcake[j] = i;
                    temp++;
                }
            }
            if(temp > real) {               // temp 현재 받아간 수량, real 이미 가져간 사람의 수
                real = temp;
                real_person = i;
            }
        }
        System.out.println(prediction_person);
        System.out.println(real_person);
    }
}

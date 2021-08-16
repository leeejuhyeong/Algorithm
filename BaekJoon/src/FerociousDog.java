import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FerociousDog {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a_attck = Integer.parseInt(st.nextToken());     // Adog의 공격시간
        int a_rest = Integer.parseInt(st.nextToken());      // Adog의 휴식시간
        int b_attck = Integer.parseInt(st.nextToken());     // Bdog의 휴식시간
        int b_rest = Integer.parseInt(st.nextToken());      // Bdog의 휴식시간

        st = new StringTokenizer(br.readLine());
        int[] persons = new int[3];
        for(int i =0; i < 3; i++){
            persons[i] = Integer.parseInt(st.nextToken());      // 우체부, 우유배달부, 신문배달부의 방문 시간
        }

        for(int i = 0; i < 3; i++){
            int count = 0;                  // person의 방문시간 % dog의 공격+휴식시간 0~공격시간 -> 공격받음, 0~ 휴식시간 -> 공격안받음
            if((persons[i]%(a_attck+a_rest)) > 0 && (persons[i]%(a_attck+a_rest)) <= a_attck) count++;
            if((persons[i]%(b_attck+b_rest)) > 0 && (persons[i]%(b_attck+b_rest)) <= b_attck) count++;
            System.out.println(count);
        }
    }
}

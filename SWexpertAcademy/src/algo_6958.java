import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class algo_6958 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int t = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= t; test_case++){
            String[] nm = br.readLine().split(" ");
            int n = Integer.parseInt(nm[0]);
            int m = Integer.parseInt(nm[1]);


            int max_person = 0;         // 최대 갯수만큼 맞힌 사람 수
            int max_score = 0;          // 맞힌 최대 갯수

            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                int new_score = 0;

                for(int j = 0; j < m; j++){
                    new_score += Integer.parseInt(st.nextToken());        // 문제 맞힌 사람 계산
                }


                if(new_score > max_score){        //  더 많이 맞은 사람일 경우
                    max_score = new_score;        // 맞힌 최대 갯수 변경
                    max_person = 1;         // 사람 수 1로 초기화
                }
                else if (max_score == new_score) max_person++;    // 같은 개수의 문제만큼 맞을 경우 person 증가
            }
            System.out.println("#" + test_case + " " + max_person + " " + max_score);
        }
    }
}

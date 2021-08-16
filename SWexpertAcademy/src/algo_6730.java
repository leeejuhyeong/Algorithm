import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class algo_6730 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= t; test_case++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] blocks = new int[n - 1];          // 첫번째 시작점을 제외한 나머지 계단
            int back = Integer.parseInt(st.nextToken());    // 첫번재 시작점 높이

            int upMax = 0;             // 올라갈 때 가장 심한 높이 변화
            int downMax = 0;            // 내려갈 때 가장 심한 높이 변화

            for (int i = 0; i < n - 1; i++) {
                int temp = Integer.parseInt(st.nextToken());
                blocks[i] = temp - back;            // 새로운 높이 temp에서 현재 높이 back을 빼줌

                back = temp;                        // 기존의 높이를 변경
                if (blocks[i] > 0 && blocks[i] > upMax) upMax = blocks[i];      // blocks가 양수 => 올라갔다.
                else if (blocks[i] < 0 && blocks[i] < downMax) downMax = blocks[i]; // blocks가 음수 => 내려갔다.
            }

            System.out.println("#" + test_case + " " + upMax + " " + Math.abs(downMax));
        }
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class algo_2477_이주형 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int k = Integer.parseInt(br.readLine());

        int[][] direction = new int[6][2];          // 방향과 길이 저장 배열(0 : 방향, 1 : 길이)

        for (int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine());
            int direct = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());

            direction[i][0] = direct;                   // 동서남북 방향 초기화
            direction[i][1] = len;                      // 길이 초기화
        }

        int smallRow = 0;                   // ㄱ모양 밭에서 작은 사각형 높이
        int smallColumn = 0;                // 작은 사각형 너비
        int bigRow = 0;                     // 큰사각형 높이
        int bigColumn = 0;                  // 큰사각형 너비

        int idx = 0;
        while (true) {      // ㄱ의 모양은 그대로이고 90, 180, 270으로 회전만 한다고 하였으니 임의의 꼭지점에서 시작해도 아래와 같이 반복되는 구간이 존재.
            int first = idx;
            int second = idx + 1 < 6 ? idx + 1 : idx + 1 - 6;
            int thrid = idx + 2 < 6 ? idx + 2 : idx + 2 - 6;
            int fourth = idx + 3 < 6 ? idx + 3 : idx + 3 - 6;

            if(direction[first][0] == direction[thrid][0] && direction[second][0] == direction[fourth][0]){
                smallColumn = direction[second][1];                 // 작은 사각형의 너비
                smallRow = direction[thrid][1];                     // 작은 사각형의 높이
                bigRow = direction[first][1] + smallRow;
                bigColumn = direction[fourth][1] + smallColumn;
                break;
            }
            idx++;
        }

        int dimensions = bigRow * bigColumn - smallRow * smallColumn;
        int result = k * dimensions;

        System.out.println(result);

    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B17406_이주형 {
    static int[][] map;         // 원본 배열
    static int[][] arr;         // 복사 배열(회전 연산할 배열)
    static int[][] boxes;       // 회전 연산 저장 배열
    static int[][] sequence;    // 회전 연산 순열 저장 배열
    static boolean[] visit;     // 순열 생성 방문 체크
    static int min;             // 최소값

    public static void rotation(int n0, int m0, int n, int m) { // 한칸씩 시계방향 회전
        int temp = arr[n0][m];
        for (int i = m; i > m0; i--) {
            arr[n0][i] = arr[n0][i - 1];
        }
        for (int i = n0; i < n; i++) {
            arr[i][m0] = arr[i + 1][m0];
        }
        for (int i = m0; i < m; i++) {
            arr[n][i] = arr[n][i + 1];
        }
        for (int i = n; i > n0 + 1; i--) {
            arr[i][m] = arr[i - 1][m];
        }
        arr[n0 + 1][m] = temp;
    }

    public static void findMin(){   // 최소값 연산
        for(int i = 0; i < map.length; i++){
            int sum = 0;
            for(int j = 0; j < map[0].length; j++){
                sum += arr[i][j];       // 각 행의 합
            }
            if(min > sum) min = sum;        // 각 행의 합 중 최소값 저장
        }
    }
    // 순열 생성
    public static void makePermu(int level){
        if(level == sequence.length){   // level이 회전 연산 개수 일 시 => 순열 완성
            arr = new int[map.length][map[0].length];       // 회전 연산할 복사 배열 선언
            for(int i = 0; i < map.length; i++){
                System.arraycopy(map[i], 0, arr[i], 0, map[0].length);  // 복사 배열 초기화(깊은 복사 중요!)
            }

            /*
            배열의 바깥부터 한줄씩 회전
            count = 껍데기 갯수(한줄) -> sequence[x][2]
            sequence[x][0] - sequence[x][2] = 영역 시작 r좌표, sequence[x][1] - sequence[x][2] = 영역 시작 c좌표 
            sequence[x][0] + sequence[x][2] = 영역 끝 r좌표, sequence[x][1] + sequence[x][2] = 영역 끝 c좌표
             */
            for(int x = 0; x < sequence.length; x++){
                for(int count = 0; count < sequence[x][2]; count++){    // 회전 연산 동작
                    rotation(sequence[x][0] - sequence[x][2] - 1 + count, sequence[x][1] - sequence[x][2] - 1 + count, sequence[x][0] + sequence[x][2] - 1 - count, sequence[x][1] + sequence[x][2] - 1 - count);
                }
            }

            findMin(); // 최소값 연산
        }
        // 순열 탐색
        for(int i = 0; i < sequence.length; i++){
            if(!visit[i]){
                sequence[level] = boxes[i];
                visit[i] = true;
                makePermu(level + 1);   // 회전 연산 선택 시 1씩 level 증가
                visit[i] = false;
            }
        }
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nmr = br.readLine().split(" ");
        int n = Integer.parseInt(nmr[0]);
        int m = Integer.parseInt(nmr[1]);
        int r = Integer.parseInt(nmr[2]);

        map = new int[n][];         // 원본 배열 선언

        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray(); // 원본 배열 초기화
        }

        boxes = new int[r][];       // 회전 연산 선언
        for(int i = 0; i < r; i++){
            boxes[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();   // 회 연산 초기화
        }

        sequence = new int[r][3];   // 회전 연산 순열
        visit = new boolean[r];     // 순열 방문 체크
        min = Integer.MAX_VALUE;    // 최소값
        makePermu(0);       // 순열 생성

        System.out.println(min);
    }
}
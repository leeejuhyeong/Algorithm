import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//play() :적을 모두 처리할때까지 게임 진행
//moveTarget() : 적들 한칸씩 아래로 이동
//findTarget() : 궁수가 공격할 수 있는 최소거리에 적 계산
//np() : 넥퍼, 조합 만들기
//init() : 맵의 상태를 초기화하기 위한 메소드
public class cassle {

    static int N,M,D;
    static int input[][],map[][];

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " " );
        N = Integer.parseInt(st.nextToken().trim());
        M = Integer.parseInt(st.nextToken().trim());
        D = Integer.parseInt(st.nextToken().trim());

        input = new int[N][M]; //원본 배치 판
        map = new int[N+1][M]; // 마지막행을 궁수행으로 처리하기 위해 N+1

        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(in.readLine(), " " );
            for (int j = 0; j < M; ++j) {
                input[i][j] = Integer.parseInt(st.nextToken()); //원본 배치 받아오기.
            }
        }

        map[N][M-3]=map[N][M-2]=map[N][M-1]=1; //초기궁수위치

        int MAX = 0;
        do {
            init(); //원본 복사한 새로운 판 준비
            int r=play();
            if(MAX<r) MAX = r;
        } while (np(map[N]));
        System.out.println(MAX);
    }


    private static int play() {
        int killCnt = 0; //죽인 적의 수 저장
        while(true) {
            // 궁수 수만큼 반복하며 각 궁수마다 공격가능한 적을 찾아 쏘기
            for (int j = 0; j < M; ++j) {
                if(map[N][j]==0) continue; // 궁수가 없는 빈칸이면 패스

                // 현재 궁수 기준으로 가장 가까운 적 찾기
                int[] target = findTarget(N,j);
                if(target != null) { // 적이 있으면
                    map[target[0]][target[1]]++; //아직 적을 제거 하지 않았습니다. 2가 되면, 성하고 겹치지 않나요?
                }
            }

            killCnt += removeTarget();// 죽인 적의 수 누적
            if(moveTarget()==0) break;
        }
        return killCnt;
    }

    private static int moveTarget() {
        int count = 0;

        for (int i = N-1; i >=1 ; --i) { // 아래서 2번째행부터 아래로 행복사
            for (int j = 0; j < M; ++j) {
                map[i][j] = map[i-1][j];
                if(map[i][j]>0) count++; // 남은 적의 수 세기
            }
        }
        for (int j = 0; j < M; ++j) map[0][j] = 0; //맨윗줄 빈칸 처리
        return count;
    }

    private static int removeTarget() {
        int count = 0;
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                if(map[i][j]>1) {// 궁수의 화살을 맞았다면
                    count++;
                    map[i][j] = 0;// 죽은 적 제거
                }
            }
        }
        return count;
    }
    private static int[] findTarget(int r, int c) {
        int d = 0, min = Integer.MAX_VALUE, minR=0,minC=0;
        for (int i = N-1; i >=0; --i) {
            for (int j = 0; j < M; ++j) {
                if(map[i][j]<1) continue; // 빈칸
                d = Math.abs(r-i)+Math.abs(c-j);
                if(d<=D) {// 공격제한거리에 포함되어 공격가능한 타겟이면
                    if(min>d) { // 최소거리인지 확인
                        min = d;
                        minR = i;
                        minC = j;
                    }else if(min==d) { // 거리가 같으면
                        if(minC>j) { // 가장왼쪽
                            minR = i;
                            minC = j;
                        }
                    }
                }
            }
        }
        return (min == Integer.MAX_VALUE)? null : new int[] {minR,minC};
    }

    private static boolean np(int p[]) {
        int i = M-1;
        while(i>0 && p[i-1]>=p[i]) --i;
        if(i==0) return false;

        int j = M-1;
        while(p[i-1]>=p[j]) --j;

        int temp = p[i-1];
        p[i-1] = p[j];
        p[j] = temp;

        int k = M-1;
        while(i<k) {
            temp = p[i];
            p[i] = p[k];
            p[k] = temp;
            i++; --k;
        }
        return true;
    }
    private static void init() {
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                map[i][j] = input[i][j];
            }
        }// 판 복사
    }

    public static void print(int[][] copymap,int count) {
        for(int i=0; i<N;i++) {
            for(int j=0; j<M; j++) {
                System.out.print(copymap[i][j]);
            }
            System.out.println();
        }
        System.out.println("----------count = "+count+"---------------");

    }

}

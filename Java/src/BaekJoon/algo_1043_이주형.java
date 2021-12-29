package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class algo_1043_이주형 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n, m, truePersonCnt;
        Set<Integer> truePersons = new HashSet<>();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        truePersonCnt = Integer.parseInt(st.nextToken());               // 진실을 아는 사람 수
        for (int i = 0; i < truePersonCnt; i++) {
            truePersons.add(Integer.parseInt(st.nextToken()));          // 진실을 아는 사람 집합
        }

        boolean[] party = new boolean[m];                   // 방문처리
        Set<Integer>[] partySet = new Set[m];               // 파티에 참가한 사람 집합의 배열
        int invitePersonCnt;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            invitePersonCnt = Integer.parseInt(st.nextToken());     // 파티에 참가하는 총 사람 수

            partySet[i] = new HashSet<>();
            for (int j = 0; j < invitePersonCnt; j++) {
                partySet[i].add(Integer.parseInt(st.nextToken()));      // 파티에 참가하는 사람
            }
        }

        int size;
        boolean flag = true;            // 반복 기준
        while (flag) {
            flag = false;
            loop:
            for (int i = 0; i < m; i++) {
                if (!party[i]) {                                    // 진실을 아는 사람이 파티에 참가하지 않았다면
                    for (Integer truePerson : truePersons) {
                        if (partySet[i].contains(truePerson)) {
                            size = truePersons.size();
                            truePersons.addAll(partySet[i]);  // 파티 집합에 들어있는 사람들 모두 truepersons에 넣기
                            party[i] = true;                  // 해당 파티는 진실된 파티임으로 더이상 탐색X
                            if (size != truePersons.size()) {    // 진실된 사람 집합에 새로운 사람이 추가됬을 경우
                                flag = true;                    // while 반복
                                break loop;
                            }
                        }
                    }
                }
            }
        }

        int result = 0;
        for (int i = 0; i < m; i++) {
            if (!party[i])
                result++;
        }
        System.out.println(result);
    }
}

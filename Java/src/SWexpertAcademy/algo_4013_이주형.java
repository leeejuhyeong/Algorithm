package SWexpertAcademy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

// SWExpertAcademy
public class algo_4013_이주형 {
    public static class Magnet {                // 자석 클래스
        boolean start, left, right;             // 빨간색 화살표 위치, 왼쪽 극, 오른쪽 극
        List<Boolean> magnet;                   // 각 위치의 극

        Magnet(String[] input) {
            magnet = new LinkedList<>();

            for (int i = 0; i < 8; i++) {
                switch (input[i]) {
                    case "0":                   // N극 = false
                        magnet.add(false);
                        break;
                    case "1":                   // S극 = true
                        magnet.add(true);
                        break;
                }
            }
            change();                           // 빨각색 화살표, 왼쪽, 오른쪽 극 저장
        }

        public void change() {
            start = magnet.get(0);          // 빨간색 화살표
            left = magnet.get(6);           // 왼쪽
            right = magnet.get(2);          // 오른쪽
        }

        public void leftRotation() {        // 반시계 회전
            boolean temp = magnet.get(0);
            magnet.remove(0);
            magnet.add(temp);
            change();
        }

        public void rightRotation() {       // 시계 회전
            boolean temp = magnet.get(7);
            magnet.remove(7);
            magnet.add(0, temp);
            change();
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        int k, input, direction, result;                        // 연산 횟수, 회전하고자하는 자석, 회전 방향(시계/반), 결과값
        boolean[] rotation;                                     // 회전여부
        Magnet[] magnets = new Magnet[5];                       // 자석

        for (int test_case = 1; test_case <= t; test_case++) {
            k = Integer.parseInt(br.readLine());

            for (int i = 1; i <= 4; i++) {
                magnets[i] = new Magnet(br.readLine().split(" "));      // 자석 초기화
            }

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                input = Integer.parseInt(st.nextToken());           // 회전하는 자석
                direction = Integer.parseInt(st.nextToken());       // 회전 방향

                rotation = new boolean[5];
                rotation[input] = true;                             // 회전하는 자석 true

                // 상반되는 극 확인(회전 여부)
                for (int j = input; j > 1; j--) {       // 회전하는 자석의 왼쪽 확인
                    if (magnets[j - 1].right != magnets[j].left) rotation[j - 1] = true;
                    else break;
                }
                for (int j = input; j < 4; j++) {       // 회전하는 자석의 오른쪽 확인
                    if (magnets[j].right != magnets[j + 1].left) rotation[j + 1] = true;
                    else break;
                }

                // 자석 회전
                for (int j = 1; j <= 4; j++) {
                    if (rotation[j] && input % 2 == j % 2) {                // 회전하는 자석이면서 회전하고자하는 자석과 회전하는 자석이 둘다 홀수이거나 둘다 짝수일 때
                        if (direction == 1) magnets[j].rightRotation();     // 같은 방향으로 회전
                        else magnets[j].leftRotation();
                    } else if (rotation[j] && input % 2 != j % 2) {     // 회전하는 자석이면서 둘다 홀수거나 둘다 짝수가 아닐 때 (홀 짝, 짝 홀)
                        if (direction == 1) magnets[j].leftRotation();  // 다른 방향으로 회전
                        else magnets[j].rightRotation();
                    }

                }
            }

            result = 0;
            for (int i = 1; i <= 4; i++) {
                if (magnets[i].start) result += (int) Math.pow(2, i - 1);
            }
            bw.append("#").append(String.valueOf(test_case)).append(" ").append(String.valueOf(result));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
/*
1
2
0 0 1 0 0 1 0 0
1 0 0 1 1 1 0 1
0 0 1 0 1 1 0 0
0 0 1 0 1 1 0 1
1 1
3 -1
 */

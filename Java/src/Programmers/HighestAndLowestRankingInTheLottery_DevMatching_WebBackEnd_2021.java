package Programmers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// 로또의 최고 순위와 최저 순위
public class HighestAndLowestRankingInTheLottery_DevMatching_WebBackEnd_2021 {
    public static void main(String[] args) {
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};
        System.out.println(Arrays.toString(solution(lottos, win_nums)));
    }

    public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int correctCnt = 0;
        int zeroCnt = 0;
        Set<Integer> set = new HashSet<>();

        for(int lotto : lottos) {
            if(lotto == 0)
                zeroCnt++;
            set.add(lotto);
        }

        for(int win_num : win_nums) {
            if(set.contains(win_num))
                correctCnt++;
        }

        answer[1] = 7 - correctCnt <= 5 ? 7 - correctCnt : 6;
        answer[0] = 7 - (correctCnt + zeroCnt) <= 5 ? 7 - (correctCnt + zeroCnt) : 6;

        return answer;
    }
}

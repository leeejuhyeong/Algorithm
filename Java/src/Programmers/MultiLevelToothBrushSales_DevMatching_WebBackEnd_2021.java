package Programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MultiLevelToothBrushSales_DevMatching_WebBackEnd_2021 {
    public static void main(String[] args) {
        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"young", "john", "tod", "emily", "mary"};
        int[] amount = {12, 4, 2, 5, 10};

        System.out.println(Arrays.toString(solution(enroll, referral, seller, amount)));
    }

    public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        Map<String, Integer> personToIdx = new HashMap<>();
        Map<String, String> recommender = new HashMap<>();

        int person = enroll.length;
        for(int i = 0; i < person; i++) {
            personToIdx.put(enroll[i], i);

            if(!referral[i].equals("-")) {
                recommender.put(enroll[i], referral[i]);
            }
        }

        int[] result = new int[person];
        String now;
        int profit;
        for(int i = 0; i < seller.length; i++) {
            now = seller[i];
            profit = amount[i] * 100;
            while(recommender.containsKey(now)) {
                if(profit < 10)
                    break;
                result[personToIdx.get(now)] += profit - (int) (profit * 0.1);
                profit = (int) (profit * 0.1);
                now = recommender.get(now);
            }

            if(profit < 10) {
                result[personToIdx.get(now)] += profit;
            } else {
                result[personToIdx.get(now)] += profit - (int) (profit * 0.1);
            }
        }
        return result;
    }
}

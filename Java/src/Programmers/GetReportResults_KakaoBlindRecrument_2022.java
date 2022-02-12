package Programmers;

import java.util.*;

public class GetReportResults_KakaoBlindRecrument_2022 {
    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;
        System.out.println(Arrays.toString(solution(id_list, report, k)));
    }

    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        Map<String, Integer> userIdx = new HashMap<>();
        for (int i = 0; i < id_list.length; i++) {
            userIdx.put(id_list[i], i);
        }

        // 신고 유저
        Map<String, Integer> reportUser = new HashMap<>();
        // 유저별 신고 유저
        Map<String, Set<String>> userReportInfo = new HashMap<>();

        String[] info;
        Set<String> set;
        for (String content : report) {
            info = content.split(" ");

            // 동일한 유저에 대한 신고는 1회로 처리
            if (userReportInfo.get(info[0]) != null && userReportInfo.get(info[0]).contains(info[1]))
                continue;

            // 신고 횟수 저장
            if (!reportUser.containsKey(info[1])) {
                reportUser.put(info[1], 1);
            } else {
                reportUser.put(info[1], reportUser.get(info[1]) + 1);
            }

            // 유저별 신고 유저 저장
            if (!userReportInfo.containsKey(info[0])) {
                set = new HashSet<>();
            } else {
                set = userReportInfo.get(info[0]);
            }
            set.add(info[1]);
            userReportInfo.put(info[0], set);
        }

        for (String reportCount : reportUser.keySet()) {
            if (reportUser.get(reportCount) >= k) {
                for (String user : userReportInfo.keySet()) {
                    if (userReportInfo.get(user) != null && userReportInfo.get(user).contains(reportCount)) {
                        answer[userIdx.get(user)]++;
                    }
                }
            }
        }

        return answer;
    }

}

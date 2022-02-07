package Programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class ParkingFeeCalculation_KakaoBlindRecrument_2022 {
    public static void main(String[] args) {
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        System.out.println(Arrays.toString(solution(fees, records)));
    }

    public static int[] solution(int[] fees, String[] records) {
        Map<String, Integer> parking = new HashMap<>();
        TreeMap<String, Integer> accumulatedTime = new TreeMap<>(); // 차량 번호가 작은 자동차부터

        String[] carInfo, timeInfo;
        int hourToMin, time;
        for (String record : records) {
            carInfo = record.split(" ");
            // 시간 -> 분
            timeInfo = carInfo[0].split(":");
            hourToMin = Integer.parseInt(timeInfo[0]) * 60 + Integer.parseInt(timeInfo[1]);

            if (carInfo[2].equals("IN")) {
                parking.put(carInfo[1], hourToMin);
            } else {
                time = hourToMin - parking.get(carInfo[1]);
                if (accumulatedTime.containsKey(carInfo[1])) {
                    accumulatedTime.put(carInfo[1], accumulatedTime.get(carInfo[1]) + time);
                } else {
                    accumulatedTime.put(carInfo[1], time);
                }
                parking.remove(carInfo[1]);
            }
        }

        // 23:59분에 나간 차 계산
        hourToMin = 23 * 60 + 59;
        for (String key : parking.keySet()) {
            time = hourToMin - parking.get(key);
            if (accumulatedTime.containsKey(key)) {
                accumulatedTime.put(key, accumulatedTime.get(key) + time);
            } else {
                accumulatedTime.put(key, time);
            }
        }

        int[] answer = new int[accumulatedTime.size()];
        int idx = 0;
        // 차량 번호가 작은 자동차부터
        for (String car : accumulatedTime.keySet()) {
            time = accumulatedTime.get(car);
            System.out.println(time);
            if (time > fees[0]) {
                answer[idx++] = fees[1] + (int) Math.ceil((double)(time - fees[0]) / fees[2]) * fees[3];
            } else
                answer[idx++] = fees[1];
        }

        return answer;
    }
}

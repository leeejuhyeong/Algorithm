package Programmers;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class OpenChatRoom_KakaoBlindRecrument_2019 {
    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        StringBuilder sb = new StringBuilder();
        for(String str : solution(record)) {
            sb.append(str).append("\n");
        }
        System.out.println(sb);
    }

    public static class Node {
        String move;
        String id;

        Node(String move, String id) {
            this.move = move;
            this.id = id;
        }
    }
    public static String[] solution(String[] record) {
        int len = record.length;
        List<Node> list = new LinkedList();
        String[] split;
        Map<String, String> nickname = new HashMap();
        for(int i = 0; i < len; i++) {
            split = record[i].split(" ");

            switch(split[0]) {
                case "Enter":
                    nickname.put(split[1], split[2]);
                    list.add(new Node(split[0], split[1]));
                    break;
                case "Leave":
                    list.add(new Node(split[0], split[1]));
                    break;
                case "Change":
                    nickname.put(split[1], split[2]);
                    break;
            }
        }

        String[] answer = new String[list.size()];
        int i = 0;
        for(Node node : list) {
            switch(node.move) {
                case "Enter":
                    answer[i] = nickname.get(node.id) + "님이 들어왔습니다.";
                    break;
                default:
                    answer[i] = nickname.get(node.id) + "님이 나갔습니다.";
                    break;
            }
            i++;
        }
        return answer;
    }
}

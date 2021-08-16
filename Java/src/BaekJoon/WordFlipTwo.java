import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class WordFlipTwo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String result = "";
        Stack<Character> stack = new Stack<Character>();

        String temp = br.readLine();
        List<Character> notFlip = new ArrayList<>();
        boolean flag = false;

        for (int i = 0; i < temp.length(); i++) {
            if (temp.charAt(i) == '<') {
                flag = true;
                if (!stack.empty()) {
                    int height = stack.size();
                    for (int j = 0; j < height; j++) {
                        result += stack.pop();
                    }
                }
            }
            if (flag) {
                notFlip.add(temp.charAt(i));
                if (temp.charAt(i) == '>') {
                    flag = false;
                    for(int j = 0; j< notFlip.size(); j++){
                        result += notFlip.get(j);
                    }
                    notFlip.clear();
                }
            } else if(temp.charAt(i) == ' ') {
                if (!stack.empty()) {
                    int height = stack.size();
                    for (int j = 0; j < height; j++) {
                        result += stack.pop();
                    }
                    result += " ";
                }
            } else {
                stack.push(temp.charAt(i));
            }
        }
        if(!stack.isEmpty()){
            int height = stack.size();
            for (int j = 0; j < height; j++) {
                result += stack.pop();
            }
        }
        for(int i = 0; i < result.length(); i++){
            System.out.print(result.charAt(i));
        }
    }

}

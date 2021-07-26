import java.util.Scanner;

public class Glasses_no {
    public static char[] one = {'A', 'D', 'O', 'P', 'Q', 'R'};
    public String Solution(String first, String second){
        if(first.length() != second.length()) return "DIFF";
        else{
            for(int i = 0; i < first.length(); i++) {
                if (!IsitSame(first.charAt(i), second.charAt(i))) return "DIFF";
            }
            return "SAME";
        }
    }

    public static boolean IsitSame(char first, char second){
        int first_result = 0; // zero = 0, one = 1, two = 2
        int second_result = 0;
        if(first == 'B') first_result = 2;
        else {
            for (int i = 0; i < one.length; i++) {
                if (first == one[i]) {
                    first_result = 1;
                    break;
                }
            }
        }
        if(second == 'B') second_result = 2;
        else {
            for (int i = 0; i < one.length; i++) {
                if (second == one[i]) {
                    second_result = 1;
                    break;
                }
            }
        }
        if(first_result == second_result) return true;
        else return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for(int test_case = 1; test_case <= T; test_case++){
            Glasses_no glasses_no = new Glasses_no();
            String first = scanner.next();
            String second = scanner.next();

            String solution = glasses_no.Solution(first, second);
            System.out.println("#" + test_case + " " + solution);
        }
    }
}

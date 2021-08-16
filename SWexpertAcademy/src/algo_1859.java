import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class algo_1859 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, Integer> hashMap = null;

        int t = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= t; test_case++) {
            int n = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");

            int[] products = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();        // 물건의 매매가
            int sell = 0;
            long result = 0;

            for(int i = n-1; i >= 0; i--){
                if(products[i] > sell){
                    sell = products[i];
                } else result += sell - products[i];
            }

            System.out.println("#" + test_case + " " + result);
        }
    }

//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        HashMap<Integer, Integer> hashMap = null;
//
//        int t = Integer.parseInt(br.readLine());
//
//        for (int test_case = 1; test_case <= t; test_case++) {
//            int n = Integer.parseInt(br.readLine());
//            String[] input = br.readLine().split(" ");
//
//            int[] products = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();        // 물건의 매매가
//            int[] sort_product = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();    // 정렬된 물건의 매매가
//            Arrays.sort(sort_product);
//
//            hashMap = new HashMap<>();        // 물건의 매매가의 index 저장
//            for (int i = 0; i < n; i++) {
//                hashMap.put(products[i], i);
//            }
//
//            int max_index = n - 1;
//            long result = 0;
//            for (int i = 0; i < n; i++) {
//                if(max_index == -1) break;
//                if (i < hashMap.get(sort_product[max_index])) {
//                    result += (long)sort_product[max_index] - (long)products[i];
//                } else if(i == hashMap.get(sort_product[max_index])) {
//                    max_index--;
//                } else{
//                    max_index--;
//                    i--;
//                }
//            }
//
//            System.out.println("#" + test_case + " " + result);
//            hashMap.clear();
//        }
//
//    }
}

package codingTest;

import java.util.*;

public class p1 {
    static int solution(String[] id_list, int k) {
        int answer = 0;
        List<String> Array = new ArrayList<String>();

        for (int i = 0; i < id_list.length; i++) {
            String[] split = id_list[i].split(" ");
            String[] resultArr = Arrays.stream(split).distinct().toArray(String[]::new);
            System.out.println("resultArr = " + Arrays.toString(resultArr));
            for (int j = 0; j < resultArr.length; j++) {
                Array.add(resultArr[j]);
            }
        }

        for (String i : Array) System.out.println("i = " + i);

        Set<String> set = new HashSet<String>(Array);
        for (String str :
                set) {
            int frequency = Collections.frequency(Array, str);
            System.out.println(str + " : " + frequency);
            if (frequency > k) {
                answer += k;
            } else {
                answer += frequency;
            }
        }
        System.out.println("answer = " + answer);

        return answer;
    }

    public static void main(String[] args) {
        String[] id_list = {"A B A A", "A B C D", "C D", "B B"};
        solution(id_list,2);
        String[] b = {"A B A A", "A B C D", "C D", "B B"};
        solution(b,1);
    }
}

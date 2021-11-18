package chap08;

import java.util.Scanner;

public class BFmatch {
//    브루트-포스법으로 문자열 검색
    static int bfMatch(String txt, String pat) {
        int pt = 0;     //txt 커서
        int pp = 0;     //pat 커서

        while (pt != txt.length() && pp != pat.length()) {
            if (txt.charAt(pt) == pat.charAt(pp)) {
                pt++;
                pp++;
            } else {
                pt = pt - pp + 1;
                pp = 0;
            }
        }
        if (pp == pat.length())     //검색 성공
            return pt -pp;
        return -1;                  //검색 실패
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("텍스트 : ");
        String s1 = stdIn.next();

        System.out.println("패턴 : ");
        String s2 = stdIn.next();

        int idx = bfMatch(s1, s2);

        if (idx == -1)
            System.out.println("텍스트에 패턴이 없습니다.");
        else {
            int len = 0;
            for (int i = 0; i < idx; i++) {
                len += s1.substring(i, i + 1).getBytes().length;
            }
            len += s2.length();

            System.out.println((idx + 1) + "번째 문자부터 일치합니다.");
            System.out.println("텍스트 : " + s1);
            System.out.printf(String.format("패턴 : %%%ds\n", len), s2);
        }
    }
}

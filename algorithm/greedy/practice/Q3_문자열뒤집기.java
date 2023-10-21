package algorithm.greedy.practice;

import java.util.*;
import java.io.*;

/**
 * Tip : 문자가 변환되는 횟수를 카운트하여 그룹된 횟수가 적은 숫자의 그룹수를 세면 된다.
 *       이 때 규칙은 홀수번 변환되었다는 것은 그룹의 수가 같다는 것이고
 *       짝수번 변환되었다는 것은 그룹의 수가 다르다는 것이다.
 *       그룹의 수가 같다면 전체 그룹수를 2분할하면 된다 -> 전체그룹수(= 홀수번 변환 + 1) / 2
 *       그룹의 수가 다르다면 '전체 그룹수 - 1'을 2분할 하면 된다. -> 전체 그룹수((짝수번 변환 + 1) - 1) / 2
 */
public class Q3_문자열뒤집기 {

    private static int i;

    public static void main(String[] args) throws IOException{

        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(r.readLine());

        String s = st.nextToken();

        int change = 0;
        int prev = s.charAt(0) - '0'; ;

        for(int i = 1; i < s.length(); i++){

            int current = s.charAt(i) - '0';

            if(prev != current)
                change++;

            prev = current;
        }

        change = (change + 1) / 2;

        System.out.println(change);
    }
}

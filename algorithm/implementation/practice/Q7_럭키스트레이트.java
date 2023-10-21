package algorithm.implementation.practice;

import java.util.*;
import java.io.*;

public class Q7_럭키스트레이트 {

    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

/**     -> 내가 작성한 2N 번 돌아가는 코드
          ArrayList<Integer> scores = new ArrayList<>();
//
//        for(int i = 0; i < str.length(); i++){
//            scores.add(str.charAt(i) - '0');
//        }
//
//        int split = scores.size()/2;
//        int left = 0;
//        int right = 0;
//
//        for(int i = 0; i < split; i++)
//            left += scores.get(i);
//
//        for(int i = split; i < scores.size(); i++)
//            right += scores.get(i);
//
//        if(left == right)
//            System.out.println("LUCKY");
//        else
//            System.out.println("READY");
*/

        /**
         *  -> 나동빈이 작성한 N번 돌아가는 코드
         */
        int summary = 0;

        for(int i = 0; i < str.length()/2; i++)
              summary += str.charAt(i) - '0';

        for(int i = str.length()/2; i < str.length(); i++)
              summary -= str.charAt(i) - '0';

        if(summary == 0) System.out.println("LUCKY");
        else System.out.println("READY");

    }
    public static void main(String[] args) throws IOException{
        new Q7_럭키스트레이트().solution();
    }
}

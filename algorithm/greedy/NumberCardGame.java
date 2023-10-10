package algorithm.greedy;

import java.util.*;
import java.io.*;

/**
 * Tip : 최솟값과 최댓값만 필요한 경우, 배열을 통해 가져오는 것보다는 즉각적으로 비교하여 저장함으로써 메모리를 아낄 수 있다.
 */
public class NumberCardGame {

    public static void main(String[] args) throws IOException{

        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(r.readLine());

        int row = Integer.parseInt(st.nextToken());
        int column = Integer.parseInt(st.nextToken());
        int max = 0;

        for(int i = 0; i < row; i++) {
            st = new StringTokenizer(r.readLine());
            int min = 10001;
            for(int j = 0; j < column; j++){
                int value = Integer.parseInt(st.nextToken());
                min = Math.min(value, min);
            }
            max = Math.max(min, 0);
        }

        System.out.println(max);


// 초기 답안 -> 개선된 답안에 비해 배열의 선언으로 메모리를 훨씬 많이 차지하고 sort 계산으로 인해 시간이 더 소요된다.
//        int[][] cards = new int[row][column];
//        int[] maxofmin = new int[row];
//
//        for( int i = 0; i < row; i++) {
//            st = new StringTokenizer(r.readLine());
//            for (int j = 0; j < column; j++) {
//                cards[i][j] = Integer.parseInt(st.nextToken());
//            }
//            Arrays.sort(cards[i]);
//            maxofmin[i] = cards[i][0];
//        }
//
//        Arrays.sort(maxofmin);
//        OptionalInt max = Arrays.stream(maxofmin).max();
//
//        System.out.println(max.getAsInt());


    }
}

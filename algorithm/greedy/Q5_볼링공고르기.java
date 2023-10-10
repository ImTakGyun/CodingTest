package algorithm.greedy;

import java.util.*;
import java.io.*;

/**
 * Tip : 그룹 지어진 상황에서의 Combination
 */
public class Q5_볼링공고르기 {

    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(r.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(r.readLine());

        int[] weights = new int[k+1];

        for(int i = 0; i < n; i++){
            int x = Integer.parseInt(st.nextToken());
            weights[x] += 1;
        }

        int count = 0;

        for(int j = 1; j <=k; j++){
            n -= weights[j];
            count += n * weights[j];
        }

        System.out.println(count);

//  문제의 정답은 맞췄지만 2중 for문과 배열으로 인해 복잡도가 보다 복잡해짐
//        int[] balls = new int[n];
//
//        for(int i = 0; i < n; i++){
//            balls[i] = Integer.parseInt(st.nextToken());
//        }
//
//        int count = 0;
//
//        for(int i = 0; i < n; i++)
//            for(int j = i + 1; j < n; j++)
//                if(balls[i] != balls[j])
//                    count++;
//
//        System.out.println(count);
    }
}

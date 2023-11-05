package SWEA;

import java.util.*;
import java.io.*;
/**
 *  <핵심 Point> : <빈도를 비교하고 조건에 만족하면 점수 조건을 비교하고 만족하면 채워넣기!>
 *                  (1) 점수가 1~100점으로 측정되어 있으니 arr[101]을 선언하여 등장하는 모든 점수의 빈도를 체크한다.
 *                  (2) 같은 빈도의 경우 가장 큰 수를 반환하라는 조건에 의해 뒤에서부터 접근하여 큰 수부터 차례로 빈도를 비교한다.
 *                  (2)-1 사실 뒤에서부터 접근하지 않고 앞에서부터 접근해도 된다. 같은 빈도의 경우 큰 수를 저장하면 되기 때문이다.
 *                  (3) 빈도가 가장 높은 수를 최빈수로 저장하고 끝까지 진행한다.
 *                  (4) 반환되는 값은 가장 빈도가 높으면서 가장 큰 점수가 반환된다.
 */

public class SW_1204 {

    public static int[] arr;

    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            br.readLine();
            st = new StringTokenizer(br.readLine());

            arr = new int[101]; //가비지 컬렉터가 이미 힙 메모리에 할당되어있던 공간을 회수하고 새로 저장 공간을 할당한다.

            for(int i = 0; i < 1000; i++){
                arr[Integer.parseInt(st.nextToken())] += 1;
            }

            int max = 0;
            int result = 0;

            for(int i = 100; i > 0; i--){
                if(max < arr[i]){
                    max = arr[i];
                    result = i;
                }
            }

            System.out.println("#" + test_case + " " + result);
        }
    }
}

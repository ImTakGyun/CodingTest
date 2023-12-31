package SWEA.D3;

import java.util.*;
import java.io.*;

/**
 *  핵심 Point : 단순 구현 -> <마름모 구하기는 start 와 end를 설정하여(초기는 n/2(중간값)) 중간을 지나기 전까지는(i < n/2)
 *                                      start - 1, end + 1로 총합을 구하고,
 *                                      중간을 지난 이후(i >= (n/2))부터는
 *                                      start + 1, end - 1로 초압을 구한다.
 */
public class SW_2805 {

    public static int[][] arr;

    public static void main(String args[]) throws Exception
    {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            arr = new int[n][n];

            for(int i = 0; i < n; i++){
                String str = br.readLine();
                for(int j = 0; j < n; j++){
                    arr[i][j] = str.charAt(j) - '0';
                }
            }

            int sum = 0;

            /**
             *  문제의 규칙을 찾아내서 푸는 방식 -> 가장 기본적인 방법
             *

                for(int i = 0; i < n; i++){
                    if(i <= (n/2)){
                        for(int j = (n/2) - i; j <= (n/2) + i; j++)
                            sum += arr[i][j];
                    }
                    else{
                        for(int j = i - (n/2); j <= (n - 1) - (i - (n/2)); j++)
                            sum += arr[i][j];
                    }
                }
             */


            /**
             *   문제에 맞는 조건을 보다 편하게 구하는 방법
             *   start와 end를 설정하여 풀이한다.
             */

            // 0번 행에서 계산할 값이 들어있는 위치 설정
            int start = n/2;
            int end = n/2;

            // 0번 행에서부터 시작한다.
            for(int i = 0; i < n; i++){
                // start부터 end까지의 총합을 구한다.
                for(int j = start; j <= end; j++){
                    sum += arr[i][j];
                }

                // 행 번호가 전체의 1/2 미만이라면 계산 범위를 늘려준다.
                if(i < (n/2)){
                    start -= 1;
                    end += 1;
                }
                // 행 번호가 전체의 1/2 이상이라면 계산 범위를 좁혀준다.
                else{
                    start += 1;
                    end -= 1;
                }
            }
            // 계산 범위가 늘었다가 줄음을 통해 마름모 계산이 가능하다.
            System.out.println("#" + test_case + " " + sum);
        }
    }
}

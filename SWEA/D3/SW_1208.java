package SWEA.D3;

import java.util.*;
import java.io.*;

/**
 *  핵심 Point : 전형적인 그리디 문제 -> 가장 큰 값을 가지는 인덱스와 가장 작은 값을 가지는 인덱스를 각각 max와 min으로 구하고
 *              max의 높이는 -1, min의 높이는 +1 을 주어진 덤프수만큼 반복한다.
 *              이후에 max와 min이 나타내는 값의 차이를 구하면 정답이 된다.
 */
public class SW_1208 {

    public static int[] arr;

    public static void main(String args[]) throws Exception
    {
        int T =10;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int test_case = 1; test_case <= T; test_case++)
        {
            arr = new int[100];

            StringTokenizer st = new StringTokenizer(br.readLine());
            int dump = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < 100; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int result = 0;


            for(int i = 0; i < dump+1; i++){

                int max = 0;
                int min = 0;

                for(int j = 1; j < 100; j++){
                    if(arr[j] > arr[max]) max = j;
                    else if(arr[j] < arr[min]) min = j;
                }

                // i가 dump 일 때(dump수만큼 반복한 이후) max와 min이 가리키는 값의 차이를 구한다.
                if(i == dump) result = arr[max] - arr[min];

                arr[max] -= 1;
                arr[min] += 1;

            }

            System.out.println("#" + test_case + " " + result);
        }
    }
}

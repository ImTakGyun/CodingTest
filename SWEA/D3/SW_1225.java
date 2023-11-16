package SWEA.D3;

import java.util.*;
import java.io.*;

/**
 * 핵심 Point : <문제의 조건에 주어진 1~5만큼 감소하는 것을 반복하기 위해서는 6으로 나누는 것이 기본이 됨과 동시에 나머지가 0인 경우 1로 늘려주는 예외처리가 필요>
 */
public class SW_1225 {

    public static int[] arr;

    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = 10;

        for(int test_case = 1; test_case <= T; test_case++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int test = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            arr = new int[8];

            for(int i = 0; i < 8; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int i = 0;

            while(arr[7] > 0) {
                i = i % 6;

                if(i == 0) i++;

                int temp = arr[0] - i;
                for(int j = 1; j < 8; j++) {
                    arr[j-1] = arr[j];
                }
                if(temp < 0) temp = 0;
                arr[7] = temp;
                i++;
            }

            System.out.print("#" + test);
            for(int k = 0; k < 8; k++) {
                System.out.print(" " + arr[k]);
            }
            System.out.println();
        }
    }
}

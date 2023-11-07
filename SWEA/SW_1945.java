package SWEA;

import java.util.*;
import java.io.*;

/**
 *  핵심 Point : 단순 구현
 */
public class SW_1945 {

    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            int[] arr = new int[5];

            while(n != 1){
                if(n % 2 == 0) {
                    n = n / 2;
                    arr[0]++;
                }
                else if(n % 3 == 0) {
                    n = n / 3;
                    arr[1]++;
                }
                else if(n % 5 == 0) {
                    n = n / 5;
                    arr[2]++;
                }
                else if(n % 7 == 0) {
                    n = n / 7;
                    arr[3]++;
                }
                else if(n % 11 == 0) {
                    n = n / 11;
                    arr[4]++;
                }
            }

            System.out.print("#" + test_case + " ");
            for(int i = 0; i < 5; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }

}

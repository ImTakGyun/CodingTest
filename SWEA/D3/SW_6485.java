package SWEA.D3;

import java.util.*;
import java.io.*;

/**
 *  핵심 Point : 단순 구현 - 모드 정류장을 배열에 담고 노선이 지나가는 정류장에 +1 을 진행한다.
 *                        이후 주어진 정류장의 지나가는 노선의 합을 구하면 된다.
 */
public class SW_6485 {

    public static int[] BusStop;

    public static void main(String args[]) throws Exception
    {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            BusStop = new int[5001];

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                for(int j = start; j < end + 1; j++){
                    BusStop[j] += 1;
                }
            }

            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());

            int[] arr = new int[p];

            for(int i = 0; i < p; i++){
                st = new StringTokenizer(br.readLine());
                arr[i] = Integer.parseInt(st.nextToken());
            }

            System.out.print("#" + test_case + " ");
            for(int i = 0; i < arr.length; i++){
                System.out.print(BusStop[arr[i]] + " ");
            }
            System.out.println();
        }
    }

}

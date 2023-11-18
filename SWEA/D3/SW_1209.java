package SWEA.D3;

import java.util.*;
import java.io.*;

/**
 *  핵심 Point : 단순 구현 - 모든 방향의 값들을 차례대로 계산하여 list에 담고 sort를 통해 가장 큰 값을 뽑는다.
 */
public class SW_1209 {

    public static int[][] arr;

    public static void main(String args[]) throws Exception
    {
        int T = 10;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int test_case = 1; test_case <= T; test_case++)
        {
            br.readLine();

            StringTokenizer st;

            arr = new int[100][100];

            for(int i = 0; i < 100; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < 100; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            ArrayList<Integer> list = new ArrayList<>();

            int cross1 = 0;
            int cross2 = 0;

            for(int i = 0; i < 100; i++){

                int s1 = 0;
                int s2 = 0;

                for(int j = 0; j < 100; j++){
                    s1 += arr[i][j];
                    s2 += arr[j][i];
                }
                list.add(s1);
                list.add(s2);

                cross1 += arr[i][i];
                cross2 += arr[i][99-i];
            }

            list.add(cross1);
            list.add(cross2);

            Collections.sort(list);

            int result = list.get(list.size()-1);

            System.out.println("#" + test_case + " " + result);

        }
    }
}

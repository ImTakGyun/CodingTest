package SWEA.D2;

import java.util.*;
import java.io.*;

/**
 * 핵심 Point : <입력되는 2차원 배열에 0 패딩을 해줌으로써 (i,j)는 (i-1,j-1) + (i-1, j)가 성립되도록 한다.>
 */
public class SW_2005 {

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

            arr = new int[n][n+1];
            arr[0][1] = 1;

            for(int i = 1; i < n; i++){
                for(int j = 1; j < i+2; j++)
                    arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
            }

            System.out.println("#" + test_case);

            for(int i = 0; i < n; i++){
                for(int j = 1; j < i+2; j++)
                    System.out.print(arr[i][j] + " ");
                System.out.println();
            }
        }
    }
}

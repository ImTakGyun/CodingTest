package SWEA.D2;

import java.io.*;
import java.util.*;

public class SW_1961 {

    public static int[][] retrix(int[][] arr){
        int n = arr.length;
        int m = arr[0].length;

        int[][] ret = new int[m][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                ret[j][n - i - 1] = arr[i][j];
            }
        }

        return ret;
    }

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for (int test_case = 1; test_case <= T; test_case++) {

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            int[][] arr = new int[n][n];
            int[][] arr90 = new int[n][n];
            int[][] arr180 = new int[n][n];
            int[][] arr270 = new int[n][n];

            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            arr90 = retrix(arr);
            arr180 = retrix(arr90);
            arr270 = retrix(arr180);

            System.out.println("#" + test_case);

            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++)
                    System.out.print(arr90[i][j]);
                System.out.print(" ");
                for(int j = 0; j < n; j++)
                    System.out.print(arr180[i][j]);
                System.out.print(" ");
                for(int j = 0; j < n; j++)
                    System.out.print(arr270[i][j]);
                System.out.println();
            }

        }
    }
}

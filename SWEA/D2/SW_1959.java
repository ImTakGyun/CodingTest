package SWEA.D2;

import java.io.*;
import java.util.*;

public class SW_1959 {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for (int test_case = 1; test_case <= T; test_case++) {

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] a = new int[n];
            int[] b = new int[m];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++){
                a[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < m; i++){
                b[i] = Integer.parseInt(st.nextToken());
            }



            if(n <= m){
                int[] sum = new int[m-n+1];

                for(int i = 0; i < (m - n) + 1; i++){
                    for(int j = 0; j < n; j++)
                        sum[i] += a[j] * b[i + j];
                }
                Arrays.sort(sum);
                System.out.println("#" + test_case + " " + sum[m-n]);
            }
            else{
                int[] sum = new int[n-m+1];

                for(int i = 0; i < (n - m) + 1; i++){
                    for(int j = 0; j < m; j++)
                        sum[i] += a[i+j] * b[j];
                }
                Arrays.sort(sum);
                System.out.println("#" + test_case + " " + sum[n-m]);
            }
        }
    }
}
